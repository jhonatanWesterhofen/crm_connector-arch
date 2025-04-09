package com.hubspot.integration.crm_connector.domain.entities.dto;

import com.hubspot.integration.crm_connector.domain.entities.enums.EnumScope;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Getter
@Setter
public class TokenDTO {

    private String accessToken;
    private String refreshToken;
    private String expiresIn;
    private String tokenType;
    private EnumScope scope;

}