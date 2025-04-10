package com.hubspot.integration.crm_connector.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebhookContactEventDTO {

    @JsonProperty("objectId")
    private Long externalId;

    @JsonProperty("propertyName")
    private String changedProperty;

    @JsonProperty("propertyValue")
    private String newValue;

    @JsonProperty("changeSource")
    private String changeSource;

    @JsonProperty("eventId")
    private Long externalEventId;

    @JsonProperty("subscriptionId")
    private Long subscriptionId;

    @JsonProperty("portalId")
    private Long portalId;

    @JsonProperty("appId")
    private Long appId;

    @JsonProperty("occurredAt")
    private Long occurredAtTimestamp;

    @JsonProperty("eventType")
    private String eventType;

    @JsonProperty("attemptNumber")
    private Integer attemptNumber;

}