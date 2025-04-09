package com.hubspot.integration.crm_connector.domain.entities.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Getter
@Setter
public class ContactResponseDTO {

    private String externalId;
    private ContactPropsResponseDTO properties;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean archived;

}