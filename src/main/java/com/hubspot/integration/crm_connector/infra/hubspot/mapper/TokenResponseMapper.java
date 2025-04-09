package com.hubspot.integration.crm_connector.infra.hubspot.mapper;

import java.time.LocalDateTime;

import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HbTokenResponseDTO;

/**
 *
 * @author Jhonatan
 */
public class TokenResponseMapper {

    public static TokenDTO toTokenDTO(HbTokenResponseDTO dto) {

        TokenDTO tokenDTO = new TokenDTO();

        LocalDateTime expirationDate = LocalDateTime.now().plusSeconds(dto.getExpiresIn());

        tokenDTO.setExpiresIn(expirationDate.toString());
        tokenDTO.setAccessToken(dto.getAccessToken());
        tokenDTO.setTokenType(dto.getTokenType());
        tokenDTO.setRefreshToken(dto.getRefreshToken());

        return tokenDTO;
    }
}