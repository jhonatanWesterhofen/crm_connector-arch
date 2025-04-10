package com.hubspot.integration.crm_connector.domain.Utils.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseDTO {

    private String error;
    private String errorDate;
    private String errorCode;
    private String httpCodeMessage;

}