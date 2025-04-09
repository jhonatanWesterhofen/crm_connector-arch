package com.hubspot.integration.crm_connector.infra.hubspot.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Component
@ConfigurationProperties(prefix = "hubspot")
@Getter
@Setter
public class HbProperties {

    private String auth;
    private String token;
    private String clientId;
    private String redirectUri;
    private String scope;
    private String clientSecret;
    private String secret;

}