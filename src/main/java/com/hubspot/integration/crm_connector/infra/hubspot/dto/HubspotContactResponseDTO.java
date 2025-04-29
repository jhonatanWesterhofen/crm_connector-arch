package com.hubspot.integration.crm_connector.infra.hubspot.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Jhonatan
 */

public class HubspotContactResponseDTO {

    @JsonProperty("id")
    private String externalId;

    @JsonProperty("properties")
    private HubspotContactPropsResponseDTO props;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;

    @JsonProperty("archived")
    private boolean archived;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public HubspotContactPropsResponseDTO getProps() {
        return props;
    }

    public void setProps(HubspotContactPropsResponseDTO props) {
        this.props = props;
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
