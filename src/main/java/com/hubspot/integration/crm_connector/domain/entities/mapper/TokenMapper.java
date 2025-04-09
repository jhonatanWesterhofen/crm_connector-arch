package com.hubspot.integration.crm_connector.domain.entities.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.hubspot.integration.crm_connector.domain.Utils.Utils;
import com.hubspot.integration.crm_connector.domain.entities.bo.TokenBO;
import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;

/**
 *
 * @author Jhonatan
 */
public class TokenMapper {

    public static TokenDTO toDTO(TokenBO tokenBO) {

        if (Utils.isNull(tokenBO)) {
            return null;
        }

        TokenDTO tokenDTO = new TokenDTO();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        tokenDTO.setAccessToken(tokenBO.getAccessToken());
        tokenDTO.setRefreshToken(tokenBO.getRefreshToken());
        tokenDTO.setExpiresIn(tokenBO.getExpiresIn().format(formatter));
        tokenDTO.setTokenType(tokenBO.getTokenType());
        tokenDTO.setScope(tokenBO.getScope());

        return tokenDTO;

    }

    public static TokenBO toBO(TokenDTO tokenDTO) {

        if (Utils.isNull(tokenDTO)) {
            return null;
        }

        LocalDateTime expirationDate = LocalDateTime.parse(tokenDTO.getExpiresIn());

        return new TokenBO.Builder()
                .setAccessToken(tokenDTO.getAccessToken())
                .setRefreshToken(tokenDTO.getRefreshToken())
                .setExpiresIn(expirationDate)
                .setTokenType(tokenDTO.getTokenType())
                .setScope(tokenDTO.getScope())
                .build();
    }
}