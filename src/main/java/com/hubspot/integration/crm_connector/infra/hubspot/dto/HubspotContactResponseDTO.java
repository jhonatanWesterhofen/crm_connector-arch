package com.hubspot.integration.crm_connector.infra.hubspot.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Getter
@Setter
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

}
