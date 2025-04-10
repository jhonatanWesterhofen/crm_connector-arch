package com.hubspot.integration.crm_connector.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.repositories.IConnectRepository;
import com.hubspot.integration.crm_connector.domain.usecase.CreateContactConnect;

public class CreateContactConnectTest {

    private IConnectRepository connectRepository;
    private CreateContactConnect createContactConnect;

    @BeforeEach
    void setup() {
        connectRepository = mock(IConnectRepository.class);
        createContactConnect = new CreateContactConnect(connectRepository);
    }

    @Test
    void testExecute_ShouldCallRepositoryAndReturnDTO() {

        ContactDTO inputDTO = new ContactDTO();
        inputDTO.setEmail("teste@connect.com");
        inputDTO.setFirstname("João");

        when(connectRepository.createContact(inputDTO)).thenReturn(inputDTO);

        ContactDTO result = createContactConnect.execute(inputDTO);

        assertNotNull(result);
        assertEquals("teste@connect.com", result.getEmail());
        assertEquals("João", result.getFirstname());

        verify(connectRepository, times(1)).createContact(inputDTO);
    }

}
