package com.hubspot.integration.crm_connector.infra.hubspot.mapper;

import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactResponseDTO;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HbContactDTO;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HbPropertiesContactDTO;

/**
 *
 * @author Jhonatan
 */
public class ConnectResponseMapper {

    public static HbPropertiesContactDTO toContactProperties(ContactDTO dto) {

        HbPropertiesContactDTO contactProperties = new HbPropertiesContactDTO();
        HbContactDTO contactDTO = new HbContactDTO();

        contactDTO.setFirstname(dto.getFirstname());
        contactDTO.setLastname(dto.getLastname());
        contactDTO.setCompany(dto.getCompany());
        contactDTO.setEmail(dto.getEmail());
        contactDTO.setLifecyclestage(dto.getLifecyclestage());
        contactDTO.setPhone(dto.getPhone());
        contactDTO.setWebsite(dto.getWebsite());

        contactProperties.setProperties(contactDTO);

        return contactProperties;
    }

    public static ContactDTO toContactProperties(ContactDTO cDtoto, ContactResponseDTO dto) {

        cDtoto.setArchived(dto.isArchived());
        cDtoto.setExternalId(dto.getExternalId());

        return cDtoto;
    }
}