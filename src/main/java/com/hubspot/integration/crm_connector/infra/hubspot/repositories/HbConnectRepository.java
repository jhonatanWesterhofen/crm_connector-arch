package com.hubspot.integration.crm_connector.infra.hubspot.repositories;

import org.springframework.stereotype.Repository;

import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactResponseDTO;
import com.hubspot.integration.crm_connector.domain.entities.enums.EnumScope;
import com.hubspot.integration.crm_connector.domain.repositories.IConnect;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.mapper.ContactResponseMapper;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HbPropertiesContactDTO;
import com.hubspot.integration.crm_connector.infra.hubspot.dto.HubspotContactResponseDTO;
import com.hubspot.integration.crm_connector.infra.hubspot.mapper.ConnectResponseMapper;
import com.hubspot.integration.crm_connector.infra.hubspot.rest.CrmConnectRestClient;
import com.hubspot.integration.crm_connector.service.TokenService;

/**
 *
 * @author Jhonatan
 */
@Repository
public class HbConnectRepository implements IConnect {

    private CrmConnectRestClient connectRestClient;
    private TokenService tokenService;

    public HbConnectRepository(CrmConnectRestClient connectRestClient, TokenService tokenService) {
        this.connectRestClient = connectRestClient;
        this.tokenService = tokenService;
    }

    @Override
    public ContactDTO createContact(ContactDTO contactDTO) {

        String token = tokenService.getValidToken(EnumScope.SCOPE_CONTACTS);

        int maxRetries = 3;
        int retryCount = 0;
        long backoff = 2000;

        while (true) {
            try {
                HbPropertiesContactDTO payload = ConnectResponseMapper.toContactProperties(contactDTO);

                HubspotContactResponseDTO contact = connectRestClient.createContact(token, payload);
                ContactResponseDTO mapper = ContactResponseMapper.toContact(contact);

                return ConnectResponseMapper.toContactProperties(contactDTO, mapper);

            } catch (Exception e) {
                if (isRateLimitException(e)) {
                    retryCount++;
                    if (retryCount > maxRetries) {
                        throw new RuntimeException("Limite de tentativas excedido após erro 429", e);
                    }

                    try {
                        Thread.sleep(backoff);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Thread interrompida durante backoff", ie);
                    }

                    backoff *= 2;
                } else {
                    throw new RuntimeException("Erro ao criar contato", e);
                }
            }
        }
    }

    private boolean isRateLimitException(Exception e) {
        if (e instanceof feign.FeignException) {
            feign.FeignException fe = (feign.FeignException) e;
            return fe.status() == 429;
        }
        return false;
    }
}