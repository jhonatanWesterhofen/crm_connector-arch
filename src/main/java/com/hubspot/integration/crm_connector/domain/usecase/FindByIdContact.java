package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.Utils.Utils;
import com.hubspot.integration.crm_connector.domain.entities.bo.ContactBO;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.entities.mapper.ContactMapper;
import com.hubspot.integration.crm_connector.domain.repositories.IContactRepository;

public class FindByIdContact {

    private IContactRepository connectRepository;

    public FindByIdContact(IContactRepository connectRepository) {
        this.connectRepository = connectRepository;
    }

    public ContactDTO execute(String externalId) {

        ContactBO bo = connectRepository.findById(externalId);

        if (Utils.isNull(bo)) {
            return null;
        }

        return ContactMapper.toDTO(bo);

    }
}