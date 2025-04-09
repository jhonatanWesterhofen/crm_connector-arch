package com.hubspot.integration.crm_connector.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubspot.integration.crm_connector.service.WebhookService;

/**
 *
 * @author Jhonatan
 */
@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private final WebhookService webhookService;

    public WebhookController(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @PostMapping("/hubspot/contact/creation")
    public ResponseEntity<String> handleContactCreationWebhook(@RequestBody String rawBody,
            @RequestHeader("X-HubSpot-Signature") String signature) {

        webhookService.validateSignature(rawBody, signature);
        return null;
    }
}