package com.hubspot.integration.crm_connector.infra.hubspot.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.hubspot.integration.crm_connector.infra.hubspot.dto.HbPropertiesContactDTO;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HubspotContactResponseDTO;

/**
 *
 * @author Jhonatan
 */
@FeignClient(name = "hubspotCrmClient", url = "${hubspot.base-uri}")
public interface CrmConnectRestClient {

    @PostMapping(value = "/crm/v3/objects/contacts", consumes = MediaType.APPLICATION_JSON_VALUE)
    HubspotContactResponseDTO createContact(@RequestHeader("Authorization") String token,
            @RequestBody HbPropertiesContactDTO properties);

}
