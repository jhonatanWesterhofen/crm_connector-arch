package com.hubspot.integration.crm_connector.service;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HbProperties;
import com.hubspot.integration.crm_connector.presentation.OAuthController;

@Service
public class WebhookService {

    private final HbProperties hubspotProperties;
    private static final Logger logger = LoggerFactory.getLogger(OAuthController.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WebhookService(HbProperties hubspotProperties) {
        this.hubspotProperties = hubspotProperties;
    }

    public ResponseEntity<String> handleContactCreationWebhook(
            @RequestBody String rawBody,
            @RequestHeader("X-HubSpot-Signature") String signature) {

        try {

            if (!validateSignature(rawBody, signature)) {
                return ResponseEntity.status(401).body("Assinatura inválida");
            }

            JsonNode events = objectMapper.readTree(rawBody);
            if (!events.isArray()) {
                return ResponseEntity.badRequest().body("Formato inválido");
            }

            for (JsonNode event : events) {
                String subscriptionType = event.get("subscriptionType").asText();
                if ("contact.creation".equals(subscriptionType)) {
                    processContactCreation(event);
                }
            }

            return ResponseEntity.ok("Eventos de criação de contato processados com sucesso");

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao processar webhook: " + e.getMessage());
        }
    }

    public boolean validateSignature(String rawBody, String providedSignature) {

        try {

            String clientSecret = hubspotProperties.getClientSecret();

            String data = clientSecret + rawBody;

            Mac mac = Mac.getInstance("HmacSHA256");

            SecretKeySpec secretKeySpec = new SecretKeySpec(clientSecret.getBytes(StandardCharsets.UTF_8),
                    "HmacSHA256");
            mac.init(secretKeySpec);

            byte[] hash = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            String calculatedSignature = bytesToHex(hash);
            return calculatedSignature.equalsIgnoreCase(providedSignature);

        } catch (NoSuchAlgorithmException | InvalidKeyException ex) {
            logger.error("[ERRO] - Falha ao validar assinatura do webhook", ex);
            return false;
        }

    }

    private void processContactCreation(JsonNode event) {

        long objectId = event.get("objectId").asLong();
        long occurredAt = event.get("occurredAt").asLong();
        int portalId = event.get("portalId").asInt();
        String changeSource = event.get("changeSource").asText();
        int attemptNumber = event.get("attemptNumber").asInt();

        System.out.println("Novo contato criado:");
        System.out.println("Contact ID: " + objectId);
        System.out.println("Portal ID: " + portalId);
        System.out.println("Criado em: " + occurredAt);
        System.out.println("Origem: " + changeSource);
        System.out.println("Tentativa: " + attemptNumber);

    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}