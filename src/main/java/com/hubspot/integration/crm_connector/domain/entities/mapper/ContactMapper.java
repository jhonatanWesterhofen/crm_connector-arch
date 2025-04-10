package com.hubspot.integration.crm_connector.domain.entities.mapper;

import com.hubspot.integration.crm_connector.domain.Utils.Utils;
import com.hubspot.integration.crm_connector.domain.entities.bo.ContactBO;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;

/**
 *
 * @author Jhonatan
 */
public class ContactMapper {

    public static ContactDTO toDTO(ContactBO bo) {
        if (Utils.isNull(bo)) {
            return null;
        }

        ContactDTO dto = new ContactDTO();
        dto.setEmail(bo.getEmail());
        dto.setFirstname(bo.getFirstname());
        dto.setLastname(bo.getLastname());
        dto.setPhone(bo.getPhone());
        dto.setCompany(bo.getCompany());
        dto.setWebsite(bo.getWebsite());
        dto.setLifecyclestage(bo.getLifecyclestage());
        dto.setArchived(bo.isArchived());
        dto.setExternalId(bo.getExternalId());

        return dto;
    }

    public static ContactBO toBO(ContactDTO dto) {
        if (Utils.isNull(dto)) {
            return null;
        }

        return new ContactBO.Builder()
                .setEmail(dto.getEmail())
                .setFirstname(dto.getFirstname())
                .setLastname(dto.getLastname())
                .setPhone(dto.getPhone())
                .setCompany(dto.getCompany())
                .setWebsite(dto.getWebsite())
                .setLifecyclestage(dto.getLifecyclestage())
                .setArchived(dto.isArchived())
                .setExternalId(dto.getExternalId())
                .build();
    }
}