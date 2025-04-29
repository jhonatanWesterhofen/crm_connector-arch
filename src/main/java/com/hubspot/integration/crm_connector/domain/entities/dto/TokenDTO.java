package com.hubspot.integration.crm_connector.domain.entities.dto;

import com.hubspot.integration.crm_connector.domain.entities.enums.EnumScope;

/**
 *
 * @author Jhonatan
 */
public class TokenDTO {

    private String accessToken;
    private String refreshToken;
    private String expiresIn;
    private String tokenType;
    private EnumScope scope;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public EnumScope getScope() {
        return scope;
    }

    public void setScope(EnumScope scope) {
        this.scope = scope;
    }

}