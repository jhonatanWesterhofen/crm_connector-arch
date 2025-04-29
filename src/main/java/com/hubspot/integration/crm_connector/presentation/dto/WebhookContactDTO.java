package com.hubspot.integration.crm_connector.presentation.dto;

import java.util.List;

public class WebhookContactDTO {

    private List<WebhookContactEventDTO> events;

    public List<WebhookContactEventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<WebhookContactEventDTO> events) {
        this.events = events;
    }

}