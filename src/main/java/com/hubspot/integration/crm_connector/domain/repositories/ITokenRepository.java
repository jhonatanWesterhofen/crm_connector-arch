package com.hubspot.integration.crm_connector.domain.repositories;

import com.hubspot.integration.crm_connector.domain.entities.bo.TokenBO;
import com.hubspot.integration.crm_connector.domain.entities.enums.EnumScope;

/**
 *
 * @author Jhonatan
 */
public interface ITokenRepository {

    TokenBO createToken(TokenBO tokenBO);

    TokenBO findLastByProvider(EnumScope scope);

}