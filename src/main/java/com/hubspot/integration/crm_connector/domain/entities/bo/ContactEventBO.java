package com.hubspot.integration.crm_connector.domain.entities.bo;

import java.time.LocalDateTime;

import com.hubspot.integration.crm_connector.domain.entities.enums.EnumEvent;

public class ContactEventBO {
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

    private ContactEventBO(Builder builder) {
        this.externalId = builder.externalId;
        this.propertyName = builder.propertyName;
        this.propertyValue = builder.propertyValue;
        this.changeSource = builder.changeSource;
        this.eventId = builder.eventId;
        this.subscriptionId = builder.subscriptionId;
        this.portalId = builder.portalId;
        this.appId = builder.appId;
        this.occurredAt = builder.occurredAt;
        this.eventType = builder.eventType;

    }

    public static class Builder {
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
        private ContactBO contact;

        public Builder setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public Builder setPropertyName(String propertyName) {
            this.propertyName = propertyName;
            return this;
        }

        public Builder setPropertyValue(String propertyValue) {
            this.propertyValue = propertyValue;
            return this;
        }

        public Builder setChangeSource(String changeSource) {
            this.changeSource = changeSource;
            return this;
        }

        public Builder setEventId(Long eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder setSubscriptionId(Long subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        public Builder setPortalId(Long portalId) {
            this.portalId = portalId;
            return this;
        }

        public Builder setAppId(Long appId) {
            this.appId = appId;
            return this;
        }

        public Builder setOccurredAt(LocalDateTime occurredAt) {
            this.occurredAt = occurredAt;
            return this;
        }

        public Builder setEventType(EnumEvent eventType) {
            this.eventType = eventType;
            return this;
        }

        public ContactEventBO build() {
            return new ContactEventBO(this);
        }
    }

    public String getExternalId() {
        return externalId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public String getChangeSource() {
        return changeSource;
    }

    public Long getEventId() {
        return eventId;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public Long getPortalId() {
        return portalId;
    }

    public Long getAppId() {
        return appId;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public EnumEvent getEventType() {
        return eventType;
    }

}
