package com.hubspot.integration.crm_connector.infra.hubspot.database.model.repositories;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hubspot.integration.crm_connector.domain.entities.bo.TokenBO;
import com.hubspot.integration.crm_connector.domain.entities.enums.EnumScope;
import com.hubspot.integration.crm_connector.domain.repositories.ITokenRepository;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.TokenRequest;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.mapper.TokenDbMapper;
import com.hubspot.integration.crm_connector.infra.hubspot.spring.SpringTokenRequestRepository;

/**
 *
 * @author Jhonatan
 */
@Repository
@Component
public class TokenRequestRepository implements ITokenRepository {

    private final SpringTokenRequestRepository jpaRepository;

    public TokenRequestRepository(SpringTokenRequestRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public TokenBO createToken(TokenBO tokenBO) {

        TokenRequest entity = TokenDbMapper.toEntity(tokenBO);

        TokenRequest savedEntity = jpaRepository.save(entity);

        return TokenDbMapper.toDomain(savedEntity);

    }

    @Override
    public TokenBO findLastByProvider(EnumScope scope) {

        Optional<TokenRequest> entityOpt = jpaRepository.findTopByScopeOrderByCreatedAtDesc(scope);

        return entityOpt.map(TokenDbMapper::toDomain).orElse(null);
    }
}