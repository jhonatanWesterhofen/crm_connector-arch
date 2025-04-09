package com.hubspot.integration.crm_connector.infra.hubspot.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hubspot.integration.crm_connector.infra.hubspot.dto.HbTokenResponseDTO;

/**
 *
 * @author Jhonatan
 */
@FeignClient(name = "hubspotClient", url = "${hubspot.token}")
public interface OauthHubSpotRestClient {

    @PostMapping(value = "/oauth/v1/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    HbTokenResponseDTO getToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("client_secret") String clientSecret,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code") String code);

    @PostMapping(value = "/oauth/v1/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    HbTokenResponseDTO refreshToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("client_secret") String clientSecret,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("refresh_token") String refreshToken);
}
