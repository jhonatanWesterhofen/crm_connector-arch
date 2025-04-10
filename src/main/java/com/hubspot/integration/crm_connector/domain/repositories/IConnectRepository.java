package com.hubspot.integration.crm_connector.domain.repositories;

import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;

/**
 *
 * @author Jhonatan
 */
public interface IConnectRepository {

    ContactDTO createContact(ContactDTO contactDTO);

}