package com.hubspot.integration.crm_connector.presentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubspot.integration.crm_connector.presentation.dto.WebhookContactEventDTO;
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
    public ResponseEntity<String> handleContactCreationWebhook(@RequestBody List<WebhookContactEventDTO> events,
            @RequestHeader("X-HubSpot-Signature") String signature) {

        webhookService.handleContactCreationWebhook(events, signature);
        return null;
    }
}