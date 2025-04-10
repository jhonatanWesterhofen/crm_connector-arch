package com.hubspot.integration.crm_connector.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hubspot.integration.crm_connector.domain.Utils.Utils;
import com.hubspot.integration.crm_connector.domain.Utils.exception.ConnectorException;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.entities.enums.EnumErrorCode;
import com.hubspot.integration.crm_connector.domain.usecase.CreateContact;
import com.hubspot.integration.crm_connector.domain.usecase.CreateContactConnect;
import com.hubspot.integration.crm_connector.domain.usecase.FindByPhoneContact;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.repositories.ContactRepository;
import com.hubspot.integration.crm_connector.infra.hubspot.repositories.HbConnectRepository;

/**
 *
 * @author Jhonatan
 */
@Service
public class CrmService {

    private HbConnectRepository connectRepository;
    private ContactRepository contactRepository;

    public CrmService(HbConnectRepository connectRepository, ContactRepository contactRepository) {
        this.connectRepository = connectRepository;
        this.contactRepository = contactRepository;
    }

    public ResponseEntity<ContactDTO> createContact(ContactDTO contactDTO) {

        CreateContactConnect createContact = new CreateContactConnect(connectRepository);
        CreateContact createNewContact = new CreateContact(contactRepository);
        FindByPhoneContact findBy = new FindByPhoneContact(contactRepository);

        if (Utils.isNull(contactDTO.getPhone())) {
            throw new ConnectorException(EnumErrorCode.CAMPO_OBRIGATORIO, "phone");
        }

        try {

            ContactDTO contact = findBy.execute(contactDTO.getPhone());

            if (Utils.isNotNull(contact)) {
                return ResponseEntity.ok(contact);
            }

            ContactDTO response = createContact.execute(contactDTO);

            if (Utils.isNotNull(response)) {
                createNewContact.execute(response);
            }

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            throw new RuntimeException("Erro no momento da criação do contato", e);
        }
    }
}