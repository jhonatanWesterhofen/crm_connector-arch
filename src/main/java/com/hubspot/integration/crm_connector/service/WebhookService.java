package com.hubspot.integration.crm_connector.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactEventDTO;
import com.hubspot.integration.crm_connector.domain.usecase.FindByIdContact;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.repositories.ContactRepository;
import com.hubspot.integration.crm_connector.presentation.dto.WebhookContactEventDTO;

@Service
public class WebhookService {

    private ContactRepository contactRepository;

    private static final Logger logger = LoggerFactory.getLogger(WebhookService.class);

    public WebhookService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ResponseEntity<String> handleContactCreationWebhook(List<WebhookContactEventDTO> events,
            @RequestHeader("X-HubSpot-Signature") String signature) {

        logger.info("[INFO] - Recebimento Webhook ");

        FindByIdContact findByIdContact = new FindByIdContact(contactRepository);

        ContactEventDTO event = new ContactEventDTO();

        List<ContactEventDTO> list = new ArrayList<>();

        events.forEach(element -> {

            String externalId = element.getExternalId().toString();

            ContactDTO dto = findByIdContact.execute(externalId);

            event.setChangeSource(element.getChangeSource());
            list.add(event);

            dto.setEvent(list);

        });

        logger.info("[INFO] - Webhook processado ");

        return ResponseEntity.ok("Eventos de criação de contato processados com sucesso");

    }
}