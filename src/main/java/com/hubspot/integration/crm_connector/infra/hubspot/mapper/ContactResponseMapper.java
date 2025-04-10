package com.hubspot.integration.crm_connector.infra.hubspot.mapper;

import com.hubspot.integration.crm_connector.domain.Utils.Utils;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactPropsResponseDTO;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactResponseDTO;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HubspotContactPropsResponseDTO;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HubspotContactResponseDTO;

/**
 *
 * @author Jhonatan
 */
public class ContactResponseMapper {

    public static ContactResponseDTO toContact(HubspotContactResponseDTO hubspot) {
        if (Utils.isNull(hubspot)) {
            return null;
        }

        ContactResponseDTO dto = new ContactResponseDTO();
        dto.setExternalId(hubspot.getExternalId());
        dto.setProperties(toPropsDTO(hubspot.getProps()));
        dto.setCreatedAt(hubspot.getCreatedAt());
        dto.setUpdatedAt(hubspot.getUpdatedAt());
        dto.setArchived(hubspot.isArchived());

        return dto;
    }

    public static ContactPropsResponseDTO toPropsDTO(HubspotContactPropsResponseDTO hubspot) {
        if (Utils.isNull(hubspot)) {
            return null;
        }
        ContactPropsResponseDTO dto = new ContactPropsResponseDTO();

        dto.setCompany(hubspot.getCompany());
        dto.setCreatedDate(hubspot.getCreatedDate());
        dto.setEmail(hubspot.getEmail());
        dto.setFirstName(hubspot.getFirstName());
        dto.setLastName(hubspot.getLastName());
        dto.setPhone(hubspot.getPhone());
        dto.setWebsite(hubspot.getWebsite());
        dto.setLifecycleStage(hubspot.getLifecycleStage());
        dto.setFullNameOrEmail(hubspot.getFullNameOrEmail());
        dto.setEmailDomain(hubspot.getEmailDomain());
        dto.setPipeline(hubspot.getPipeline());
        dto.setObjectId(hubspot.getObjectId());
        dto.setSource(hubspot.getSource());
        dto.setSourceId(hubspot.getSourceId());
        dto.setSourceLabel(hubspot.getSourceLabel());
        dto.setIsContact(hubspot.getIsContact());
        dto.setIsUnworked(hubspot.getIsUnworked());
        dto.setMarketableStatus(hubspot.getMarketableStatus());
        dto.setMarketableUntilRenewal(hubspot.getMarketableUntilRenewal());
        dto.setAccessedPrivateContent(hubspot.getAccessedPrivateContent());
        dto.setEnrolledInProspectingAgent(hubspot.getInProspectingAgent());
        dto.setProspectingEnrollmentCount(hubspot.getProspectingCount());
        dto.setSequencesEnrollmentCount(hubspot.getSequencesCount());
        dto.setRegisteredMember(hubspot.getRegisteredMember());
        dto.setAssociatedTargetAccounts(hubspot.getAssociatedTargetAccounts());
        dto.setSearchablePhone(hubspot.getSearchablePhone());
        dto.setMqlDate(hubspot.getMqlDate());
        dto.setLastModifiedDate(hubspot.getLastModified());
        dto.setNotesCount(hubspot.getNumNotes());

        return dto;
    }
}