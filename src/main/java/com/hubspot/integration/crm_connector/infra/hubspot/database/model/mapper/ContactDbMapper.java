package com.hubspot.integration.crm_connector.infra.hubspot.database.model.mapper;

import com.hubspot.integration.crm_connector.domain.Utils.Utils;
import com.hubspot.integration.crm_connector.domain.entities.bo.ContactBO;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.Contact;

/**
 *
 * @author Jhonatan
 */
public class ContactDbMapper {

    public static Contact toEntity(ContactBO bo) {
        if (Utils.isNull(bo)) {
            return null;
        }

        Contact entity = new Contact();
        entity.setEmail(bo.getEmail());
        entity.setFirstname(bo.getFirstname());
        entity.setLastname(bo.getLastname());
        entity.setPhone(bo.getPhone());
        entity.setCompany(bo.getCompany());
        entity.setWebsite(bo.getWebsite());
        entity.setLifecyclestage(bo.getLifecyclestage());
        entity.setArchived(bo.isArchived());
        entity.setExternalId(bo.getExternalId());

        return entity;
    }

    public static ContactBO toDomain(Contact entity) {
        if (Utils.isNull(entity)) {
            return null;
        }

        return new ContactBO.Builder()
                .setEmail(entity.getEmail())
                .setFirstname(entity.getFirstname())
                .setLastname(entity.getLastname())
                .setPhone(entity.getPhone())
                .setCompany(entity.getCompany())
                .setWebsite(entity.getWebsite())
                .setLifecyclestage(entity.getLifecyclestage())
                .setArchived(entity.isArchived())
                .setExternalId(entity.getExternalId())
                .build();
    }
}