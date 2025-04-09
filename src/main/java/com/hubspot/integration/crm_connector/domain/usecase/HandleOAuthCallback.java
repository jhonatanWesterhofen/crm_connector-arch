package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;
import com.hubspot.integration.crm_connector.infra.hubspot.repositories.HbOAuthRepository;

/**
 *
 * @author Jhonatan
 */
public class HandleOAuthCallback {

    private HbOAuthRepository hpConnectRepository;

    public HandleOAuthCallback(HbOAuthRepository hpConnectRepository) {
        this.hpConnectRepository = hpConnectRepository;
    }

    public TokenDTO execute(String code) {

        TokenDTO tokenCallBack = hpConnectRepository.getToken(code);

        return tokenCallBack;
    }
}