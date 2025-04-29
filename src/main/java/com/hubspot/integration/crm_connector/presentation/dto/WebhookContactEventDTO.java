package com.hubspot.integration.crm_connector.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public String getChangedProperty() {
        return changedProperty;
    }

    public void setChangedProperty(String changedProperty) {
        this.changedProperty = changedProperty;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getChangeSource() {
        return changeSource;
    }

    public void setChangeSource(String changeSource) {
        this.changeSource = changeSource;
    }

    public Long getExternalEventId() {
        return externalEventId;
    }

    public void setExternalEventId(Long externalEventId) {
        this.externalEventId = externalEventId;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Long getPortalId() {
        return portalId;
    }

    public void setPortalId(Long portalId) {
        this.portalId = portalId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getOccurredAtTimestamp() {
        return occurredAtTimestamp;
    }

    public void setOccurredAtTimestamp(Long occurredAtTimestamp) {
        this.occurredAtTimestamp = occurredAtTimestamp;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Integer getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(Integer attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

}