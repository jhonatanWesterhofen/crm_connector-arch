package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;
import com.hubspot.integration.crm_connector.domain.repositories.IOAuthRepository;

/**
 *
 * @author Jhonatan
 */
public class RefreshToken {

    private IOAuthRepository authRepository;

    public RefreshToken(IOAuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public TokenDTO execute(String refreshToken) {
        return authRepository.refreshAccessToken(refreshToken);
    }
}