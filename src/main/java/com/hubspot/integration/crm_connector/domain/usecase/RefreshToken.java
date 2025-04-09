package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;
import com.hubspot.integration.crm_connector.domain.repositories.IOAuth;

/**
 *
 * @author Jhonatan
 */
public class RefreshToken {

    private IOAuth authRepository;

    public RefreshToken(IOAuth authRepository) {
        this.authRepository = authRepository;
    }

    public TokenDTO execute(String refreshToken) {
        return authRepository.refreshAccessToken(refreshToken);
    }
}