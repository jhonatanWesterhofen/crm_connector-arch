package com.hubspot.integration.crm_connector.domain.repositories;

import com.hubspot.integration.crm_connector.domain.entities.bo.ContactBO;

public interface IContactRepository {

    ContactBO create(ContactBO contactBO);

    ContactBO findByPhone(String phone);

    ContactBO findById(String externalId);

}