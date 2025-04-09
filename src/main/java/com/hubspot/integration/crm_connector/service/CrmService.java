package com.hubspot.integration.crm_connector.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.usecase.CreateContact;
import com.hubspot.integration.crm_connector.infra.hubspot.repositories.HbConnectRepository;

/**
 *
 * @author Jhonatan
 */
@Service
public class CrmService {

    private HbConnectRepository connectRepository;

    public CrmService(HbConnectRepository connectRepository) {
        this.connectRepository = connectRepository;
    }

    public ResponseEntity<ContactDTO> createContact(ContactDTO contactDTO) {

        try {

            CreateContact createContact = new CreateContact(connectRepository);

            ContactDTO response = createContact.execute(contactDTO);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            throw new RuntimeException("Erro no momento da criação do contato", e);
        }
    }
}