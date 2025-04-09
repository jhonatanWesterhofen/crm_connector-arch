package com.hubspot.integration.crm_connector.domain.usecase;

import com.hubspot.integration.crm_connector.domain.entities.bo.TokenBO;
import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;
import com.hubspot.integration.crm_connector.domain.entities.enums.EnumScope;
import com.hubspot.integration.crm_connector.domain.entities.mapper.TokenMapper;
import com.hubspot.integration.crm_connector.domain.repositories.ITokenRepository;

/**
 *
 * @author Jhonatan
 */
public class FindValidTokenByScope {

    private ITokenRepository iTokenRepository;

    public FindValidTokenByScope(ITokenRepository iTokenRepository) {
        this.iTokenRepository = iTokenRepository;
    }

    public TokenDTO execute(EnumScope scope) {

        TokenBO tokenBO = iTokenRepository.findLastByProvider(scope);

        return TokenMapper.toDTO(tokenBO);

    }
}