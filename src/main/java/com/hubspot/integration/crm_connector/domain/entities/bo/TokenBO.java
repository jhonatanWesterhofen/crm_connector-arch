package com.hubspot.integration.crm_connector.domain.entities.bo;

import java.time.LocalDateTime;

import com.hubspot.integration.crm_connector.domain.entities.enums.EnumScope;

import lombok.Getter;

/**
 *
 * @author Jhonatan
 */
@Getter
public class TokenBO {

    private String accessToken;
    private String refreshToken;
    private LocalDateTime expiresIn;
    private String tokenType;
    private EnumScope scope;

    public TokenBO(Builder builder) {
        this.accessToken = builder.accessToken;
        this.refreshToken = builder.refreshToken;
        this.expiresIn = builder.expiresIn;
        this.tokenType = builder.tokenType;
        this.scope = builder.scope;
    }

    public static class Builder {
        private String accessToken;
        private String refreshToken;
        private LocalDateTime expiresIn;
        private String tokenType;
        private EnumScope scope;

        public Builder setAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public Builder setExpiresIn(LocalDateTime expiresIn) {
            this.expiresIn = expiresIn;
            return this;
        }

        public Builder setTokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        public Builder setScope(EnumScope scope) {
            this.scope = scope;
            return this;
        }

        public TokenBO build() {
            return new TokenBO(this);
        }
    }
}