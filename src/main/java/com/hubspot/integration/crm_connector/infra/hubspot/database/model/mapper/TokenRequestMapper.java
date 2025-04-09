package com.hubspot.integration.crm_connector.infra.hubspot.database.model.mapper;

import com.hubspot.integration.crm_connector.domain.Utils.Utils;
import com.hubspot.integration.crm_connector.domain.entities.bo.TokenBO;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.TokenRequest;

/**
 *
 * @author Jhonatan
 */
public class TokenRequestMapper {

    public static TokenRequest toEntity(TokenBO tokenBO) {

        if (Utils.isNull(tokenBO)) {
            return null;
        }

        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setAccessToken(tokenBO.getAccessToken());
        tokenRequest.setRefreshToken(tokenBO.getRefreshToken());
        tokenRequest.setExpiresIn(tokenBO.getExpiresIn());
        tokenRequest.setTokenType(tokenBO.getTokenType());
        tokenRequest.setScope(tokenBO.getScope());

        return tokenRequest;

    }

    public static TokenBO toDomain(TokenRequest tokenRequest) {

        if (Utils.isNull(tokenRequest)) {
            return null;
        }
        return new TokenBO.Builder()
                .setAccessToken(tokenRequest.getAccessToken())
                .setRefreshToken(tokenRequest.getRefreshToken())
                .setExpiresIn(tokenRequest.getExpiresIn())
                .setTokenType(tokenRequest.getTokenType())
                .setScope(tokenRequest.getScope())
                .build();
    }
}