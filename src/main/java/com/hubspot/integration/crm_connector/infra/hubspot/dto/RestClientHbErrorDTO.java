package com.hubspot.integration.crm_connector.infra.hubspot.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Getter
@Setter
public class RestClientHbErrorDTO {

    private String status;
    private String message;
    private String correlationId;
    private String category;

}