package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.Utils.Utils;
import com.hubspot.integration.crm_connector.domain.entities.bo.ContactBO;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.entities.mapper.ContactMapper;
import com.hubspot.integration.crm_connector.domain.repositories.IContactRepository;

public class FindByPhoneContact {

    private IContactRepository contactRepository;

    public FindByPhoneContact(IContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactDTO execute(String phone) {

        ContactBO contactBO = contactRepository.findByPhone(phone);

        if (Utils.isNull(contactBO)) {
            return null;
        }

        return ContactMapper.toDTO(contactBO);

    }
}