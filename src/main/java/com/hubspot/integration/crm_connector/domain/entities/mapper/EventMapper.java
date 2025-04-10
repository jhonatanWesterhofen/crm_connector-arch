package com.hubspot.integration.crm_connector.domain.entities.mapper;

import com.hubspot.integration.crm_connector.domain.entities.bo.ContactEventBO;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactEventDTO;

public class EventMapper {

    public static ContactEventBO toBO(ContactEventDTO dto) {
        return new ContactEventBO.Builder()
                .setExternalId(dto.getExternalId())
                .setPropertyName(dto.getPropertyName())
                .setPropertyValue(dto.getPropertyValue())
                .setChangeSource(dto.getChangeSource())
                .setEventId(dto.getEventId())
                .setSubscriptionId(dto.getSubscriptionId())
                .setPortalId(dto.getPortalId())
                .setAppId(dto.getAppId())
                .setOccurredAt(dto.getOccurredAt())
                .setEventType(dto.getEventType())
                .build();
    }

    public static ContactEventDTO toDTO(ContactEventBO bo) {
        ContactEventDTO dto = new ContactEventDTO();
        dto.setExternalId(bo.getExternalId());
        dto.setPropertyName(bo.getPropertyName());
        dto.setPropertyValue(bo.getPropertyValue());
        dto.setChangeSource(bo.getChangeSource());
        dto.setEventId(bo.getEventId());
        dto.setSubscriptionId(bo.getSubscriptionId());
        dto.setPortalId(bo.getPortalId());
        dto.setAppId(bo.getAppId());
        dto.setOccurredAt(bo.getOccurredAt());
        dto.setEventType(bo.getEventType());
        return dto;
    }
}