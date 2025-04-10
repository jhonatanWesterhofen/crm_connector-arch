package com.hubspot.integration.crm_connector.presentation.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebhookContactDTO {

    private List<WebhookContactEventDTO> events;

}