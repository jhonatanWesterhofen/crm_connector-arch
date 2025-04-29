package com.hubspot.integration.crm_connector.infra.hubspot.dto;

/**
 *
 * @author Jhonatan
 */

public class RestClientHbErrorDTO {

    private String status;
    private String message;
    private String correlationId;
    private String category;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}