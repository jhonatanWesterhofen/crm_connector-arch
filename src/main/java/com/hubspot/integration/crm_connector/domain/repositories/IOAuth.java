package com.hubspot.integration.crm_connector.domain.repositories;

import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;

/**
 *
 * @author Jhonatan
 */
public interface IOAuth {

    String createAuthorizationUrl();

    TokenDTO getToken(String code);

    TokenDTO refreshAccessToken(String refreshToken);

}