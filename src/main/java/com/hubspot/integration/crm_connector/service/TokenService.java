package com.hubspot.integration.crm_connector.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.hubspot.integration.crm_connector.domain.Utils.StringUtil;
import com.hubspot.integration.crm_connector.domain.Utils.Utils;
import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;
import com.hubspot.integration.crm_connector.domain.entities.enums.EnumScope;
import com.hubspot.integration.crm_connector.domain.usecase.FindValidTokenByScope;
import com.hubspot.integration.crm_connector.domain.usecase.RefreshToken;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.repositories.TokenRequestRepository;
import com.hubspot.integration.crm_connector.infra.hubspot.repositories.HbOAuthRepository;

/**
 *
 * @author Jhonatan
 */
@Service
public class TokenService {

    private final TokenRequestRepository requestRepository;
    private final HbOAuthRepository connectRepository;

    public TokenService(TokenRequestRepository requestRepository, HbOAuthRepository connectRepository) {
        this.requestRepository = requestRepository;
        this.connectRepository = connectRepository;
    }

    public String getValidToken(EnumScope scope) {

        FindValidTokenByScope findToken = new FindValidTokenByScope(requestRepository);
        RefreshToken refreshToken = new RefreshToken(connectRepository);
        TokenDTO token = findToken.execute(scope);
        LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

        if (Utils.isNull(token) || localDateTime.isAfter(toLocalDateTime(token.getExpiresIn()))) {

            String newToken = refreshToken.execute(token.getRefreshToken()).getAccessToken();

            return StringUtil.bearerToken(newToken);
        }

        return StringUtil.bearerToken(token.getAccessToken());
    }

    public LocalDateTime toLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(date, formatter);
    }
}