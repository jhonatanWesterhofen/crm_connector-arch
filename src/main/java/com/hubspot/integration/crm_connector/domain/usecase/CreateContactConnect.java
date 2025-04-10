package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.repositories.IConnectRepository;

/**
 *
 * @author Jhonatan
 */
public class CreateContactConnect {

    private IConnectRepository connect;

    public CreateContactConnect(IConnectRepository connect) {
        this.connect = connect;
    }

    public ContactDTO execute(ContactDTO dto) {

        ContactDTO contactDTO = connect.createContact(dto);

        return contactDTO;
    }
}