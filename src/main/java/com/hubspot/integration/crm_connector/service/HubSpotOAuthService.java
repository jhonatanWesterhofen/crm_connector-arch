package com.hubspot.integration.crm_connector.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hubspot.integration.crm_connector.domain.Utils.EncryptUtil;
import com.hubspot.integration.crm_connector.domain.Utils.Utils;
import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;
import com.hubspot.integration.crm_connector.domain.usecase.CreateOAuthUrl;
import com.hubspot.integration.crm_connector.domain.usecase.CreateToken;
import com.hubspot.integration.crm_connector.domain.usecase.HandleOAuthCallback;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.repositories.TokenRequestRepository;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HbProperties;
import com.hubspot.integration.crm_connector.infra.hubspot.repositories.HbOAuthRepository;
import com.hubspot.integration.crm_connector.presentation.OAuthController;

import jakarta.transaction.Transactional;

/**
 *
 * @author Jhonatan
 */
@Service
public class HubSpotOAuthService {

    private final HbOAuthRepository connectRepository;
    private final TokenRequestRepository requestRepository;
    private final HbProperties hubspotProperties;

    private static final Logger logger = LoggerFactory.getLogger(OAuthController.class);

    public HubSpotOAuthService(HbOAuthRepository connectRepository, TokenRequestRepository requestRepository,
            HbProperties hubspotProperties) {
        this.connectRepository = connectRepository;
        this.requestRepository = requestRepository;
        this.hubspotProperties = hubspotProperties;
    }

    public ResponseEntity<String> createAuthorizationUrl() {

        try {
            CreateOAuthUrl createAuthorizationUrl = new CreateOAuthUrl(connectRepository);
            String authUrl = createAuthorizationUrl.execute();

            return ResponseEntity.ok(authUrl);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao realizar processo de callback", e);
        }

    }

    @Transactional
    public ResponseEntity<TokenDTO> callback(String code) {

        String encriptCde = EncryptUtil.textEncrypt(code, hubspotProperties.getSecret());

        logger.error("[INFO] - Recebimento do código callback " + encriptCde);

        if (Utils.isNull(code)) {
            return ResponseEntity.ok().build();
        }

        try {

            HandleOAuthCallback handleTokenCallback = new HandleOAuthCallback(connectRepository);
            CreateToken createToken = new CreateToken(requestRepository);

            TokenDTO token = handleTokenCallback.execute(code);

            if (Utils.isNotNull(token)) {
                createToken.execute(token);

            }

            logger.error("[INFO] - Processo de callback realizado com sucesso ");

            return ResponseEntity.ok(token);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao realizar processo de callback", e);
        }
    }
}