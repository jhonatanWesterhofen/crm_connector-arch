package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.entities.bo.ContactBO;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.entities.mapper.ContactMapper;
import com.hubspot.integration.crm_connector.domain.repositories.IContactRepository;

/**
 *
 * @author Jhonatan
 */
public class CreateContact {

    private IContactRepository contactRepository;

    public CreateContact(IContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactDTO execute(ContactDTO contactDTO) {

        ContactBO contactBO = ContactMapper.toBO(contactDTO);

        ContactBO contact = contactRepository.create(contactBO);

        return ContactMapper.toDTO(contact);

    }
}