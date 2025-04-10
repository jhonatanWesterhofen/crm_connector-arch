package com.hubspot.integration.crm_connector.infra.hubspot.repositories;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;
import com.hubspot.integration.crm_connector.domain.entities.enums.EnumScope;
import com.hubspot.integration.crm_connector.domain.repositories.IOAuthRepository;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HbProperties;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HbTokenResponseDTO;
import com.hubspot.integration.crm_connector.infra.hubspot.mapper.TokenResponseMapper;
import com.hubspot.integration.crm_connector.infra.hubspot.rest.OauthHubSpotRestClient;

/**
 *
 * @author Jhonatan
 */
@Repository
@Component
public class HbOAuthRepository implements IOAuthRepository {

    protected HbProperties hubspotProperties;
    protected OauthHubSpotRestClient hubSpotRestClient;

    public HbOAuthRepository(HbProperties hubspotProperties, OauthHubSpotRestClient hubSpotRestClient) {
        this.hubspotProperties = hubspotProperties;
        this.hubSpotRestClient = hubSpotRestClient;
    }

    @Override
    public String createAuthorizationUrl() {

        try {
            String url = hubspotProperties.getAuth()
                    + "?client_id=" + URLEncoder.encode(hubspotProperties.getClientId(), StandardCharsets.UTF_8)
                    + "&redirect_uri=" + URLEncoder.encode(hubspotProperties.getRedirectUri(), StandardCharsets.UTF_8)
                    + "&scope=" + URLEncoder.encode(EnumScope.SCOPE_CONTACTS.getValue(), StandardCharsets.UTF_8);

            return url;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao construir URL de autorização", e);
        }
    }

    @Override
    public TokenDTO getToken(String code) {

        try {

            HbTokenResponseDTO tokenResponse = hubSpotRestClient.getToken(
                    "authorization_code",
                    hubspotProperties.getClientId(),
                    hubspotProperties.getClientSecret(),
                    hubspotProperties.getRedirectUri(),
                    code);

            TokenDTO tokenDTO = TokenResponseMapper.toTokenDTO(tokenResponse);

            return resolveScope(tokenDTO, EnumScope.SCOPE_CONTACTS);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao construir URL de autorização", e);
        }
    }

    @Override
    public TokenDTO refreshAccessToken(String refreshToken) {
        try {
            HbTokenResponseDTO tokenResponse = hubSpotRestClient.refreshToken(
                    "refresh_token",
                    hubspotProperties.getClientId(),
                    hubspotProperties.getClientSecret(),
                    hubspotProperties.getRedirectUri(),
                    refreshToken);

            TokenDTO tokenDTO = TokenResponseMapper.toTokenDTO(tokenResponse);
            return resolveScope(tokenDTO, EnumScope.SCOPE_CONTACTS);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao fazer refresh do token", e);
        }
    }

    public TokenDTO resolveScope(TokenDTO tokenDTO, EnumScope scope) {
        tokenDTO.setScope(scope);
        return tokenDTO;

    }
}