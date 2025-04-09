package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.repositories.IConnect;

public class CreateContact {

    private IConnect connect;

    public CreateContact(IConnect connect) {
        this.connect = connect;
    }

    public ContactDTO execute(ContactDTO dto) {

        ContactDTO contactDTO = connect.createContact(dto);

        return contactDTO;
    }
}