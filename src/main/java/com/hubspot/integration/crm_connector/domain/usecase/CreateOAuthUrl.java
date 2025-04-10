package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.repositories.IOAuthRepository;

/**
 *
 * @author Jhonatan
 */
public class CreateOAuthUrl {

    private IOAuthRepository authRepository;

    public CreateOAuthUrl(IOAuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public String execute() {
        return authRepository.createAuthorizationUrl();
    }
}