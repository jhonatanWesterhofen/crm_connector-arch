package com.hubspot.integration.crm_connector.domain.entities.dto;

import java.time.LocalDateTime;

/**
 *
 * @author Jhonatan
 */
public class ContactResponseDTO {

    private String externalId;
    private ContactPropsResponseDTO properties;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean archived;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public ContactPropsResponseDTO getProperties() {
        return properties;
    }

    public void setProperties(ContactPropsResponseDTO properties) {
        this.properties = properties;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

}