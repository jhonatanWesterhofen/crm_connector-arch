package com.hubspot.integration.crm_connector.domain.Utils.exception;

import com.hubspot.integration.crm_connector.domain.Utils.StringUtil;
import com.hubspot.integration.crm_connector.domain.entities.enums.EnumErrorCode;

/**
 *
 * @author Jhonatan
 */
public class ConnectorException extends RuntimeException {

    private String errorCode = "-1";

    public ConnectorException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ConnectorException(EnumErrorCode error) {
        super(error.getValue());
        this.errorCode = error.getKey();
    }

    public ConnectorException(EnumErrorCode error, Object... args) {
        super(StringUtil.stringPatternFormat(error.getValue(), args));
        this.errorCode = error.getKey();
    }

    public String getErrorCode() {
        return errorCode;
    }
}