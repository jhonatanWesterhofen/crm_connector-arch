package com.hubspot.integration.crm_connector.infra.hubspot.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Getter
@Setter
public class TokenHubSpotResponseDTO {

    private String access_token;
    private String refresh_token;
    private String expires_in;

}