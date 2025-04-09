package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.entities.bo.TokenBO;
import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;
import com.hubspot.integration.crm_connector.domain.entities.mapper.TokenMapper;
import com.hubspot.integration.crm_connector.domain.repositories.ITokenRepository;

/**
 *
 * @author Jhonatan
 */
public class CreateToken {

    private ITokenRepository tokenRequestRepository;

    public CreateToken(ITokenRepository tokenRequestRepository) {
        this.tokenRequestRepository = tokenRequestRepository;
    }

    public TokenDTO execute(TokenDTO tokenDTO) {

        TokenBO tokenBO = TokenMapper.toBO(tokenDTO);

        TokenBO bo = tokenRequestRepository.createToken(tokenBO);

        return TokenMapper.toDTO(bo);
    }
}