package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.repositories.IOAuth;

/**
 *
 * @author Jhonatan
 */
public class CreateOAuthUrl {

    private IOAuth authRepository;

    public CreateOAuthUrl(IOAuth authRepository) {
        this.authRepository = authRepository;
    }

    public String execute() {
        return authRepository.createAuthorizationUrl();
    }
}