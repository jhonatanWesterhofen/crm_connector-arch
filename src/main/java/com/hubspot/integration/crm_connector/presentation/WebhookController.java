package com.hubspot.integration.crm_connector.presentation;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Jhonatan
 */
@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private static final String CLIENT_SECRET = "SEU_CLIENT_SECRET_AQUI";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/hubspot/contact/creation")
    public ResponseEntity<String> handleContactCreationWebhook(
            @RequestBody String rawBody,
            @RequestHeader("X-HubSpot-Signature") String signature) {

        try {

            if (!validateSignature(rawBody, signature)) {
                return ResponseEntity.status(401).body("Assinatura inválida");
            }

            // 2. Parsear o corpo da requisição
            JsonNode events = objectMapper.readTree(rawBody);
            if (!events.isArray()) {
                return ResponseEntity.badRequest().body("Formato inválido");
            }

            // 3. Processar apenas eventos de contact.creation
            for (JsonNode event : events) {
                String subscriptionType = event.get("subscriptionType").asText();
                if ("contact.creation".equals(subscriptionType)) {
                    processContactCreation(event);
                }
            }

            // 4. Responder com sucesso
            return ResponseEntity.ok("Eventos de criação de contato processados com sucesso");

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao processar webhook: " + e.getMessage());
        }
    }

    private boolean validateSignature(String rawBody, String providedSignature)
            throws NoSuchAlgorithmException, InvalidKeyException {
        String data = CLIENT_SECRET + rawBody;
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(
                CLIENT_SECRET.getBytes(StandardCharsets.UTF_8),
                "HmacSHA256");
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        String calculatedSignature = bytesToHex(hash);
        return calculatedSignature.equalsIgnoreCase(providedSignature);
    }

    private void processContactCreation(JsonNode event) {
        // Extrair informações relevantes do evento de criação de contato
        long objectId = event.get("objectId").asLong(); // ID do novo contato
        long occurredAt = event.get("occurredAt").asLong(); // Timestamp do evento
        int portalId = event.get("portalId").asInt(); // ID da conta HubSpot
        String changeSource = event.get("changeSource").asText(); // Origem da criação
        int attemptNumber = event.get("attemptNumber").asInt(); // Número da tentativa

        // Exemplo de lógica: apenas logar as informações
        System.out.println("Novo contato criado:");
        System.out.println("Contact ID: " + objectId);
        System.out.println("Portal ID: " + portalId);
        System.out.println("Criado em: " + occurredAt);
        System.out.println("Origem: " + changeSource);
        System.out.println("Tentativa: " + attemptNumber);

        // Aqui você pode adicionar sua lógica específica, como:
        // - Salvar no banco de dados
        // - Enviar para uma fila
        // - Chamar outra API
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}