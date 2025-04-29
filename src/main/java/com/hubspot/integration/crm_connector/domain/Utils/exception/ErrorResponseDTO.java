package com.hubspot.integration.crm_connector.domain.Utils.exception;

/**
 *
 * @author Jhonatan
 */

public class ErrorResponseDTO {

    private String error;
    private String errorDate;
    private String errorCode;
    private String httpCodeMessage;

    public ErrorResponseDTO(String error, String errorDate, String errorCode, String httpCodeMessage) {
        this.error = error;
        this.errorDate = errorDate;
        this.errorCode = errorCode;
        this.httpCodeMessage = httpCodeMessage;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(String errorDate) {
        this.errorDate = errorDate;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public void setHttpCodeMessage(String httpCodeMessage) {
        this.httpCodeMessage = httpCodeMessage;
    }

}