package com.hubspot.integration.crm_connector.domain.entities.dto;

import java.time.LocalDateTime;

import com.hubspot.integration.crm_connector.domain.entities.enums.EnumEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactEventDTO {

    private String externalId;
    private String propertyName;
    private String propertyValue;
    private String changeSource;
    private Long eventId;
    private Long subscriptionId;
    private Long portalId;
    private Long appId;
    private LocalDateTime occurredAt;
    private EnumEvent eventType;

}