package com.hubspot.integration.crm_connector.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hubspot.integration.crm_connector.domain.entities.bo.ContactBO;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.repositories.IContactRepository;
import com.hubspot.integration.crm_connector.domain.usecase.CreateContact;

public class CreateContactTest {

    private IContactRepository contactRepository;
    private CreateContact createContact;

    @BeforeEach
    void setup() {
        contactRepository = mock(IContactRepository.class);
        createContact = new CreateContact(contactRepository);
    }

    @Test
    void testExecute_ShouldCreateAndReturnContactDTO() {
        // Arrange
        ContactDTO inputDTO = new ContactDTO();
        inputDTO.setEmail("test@example.com");
        inputDTO.setFirstname("Henrique");

        ContactBO expectedBO = new ContactBO.Builder()
                .setEmail("test@example.com")
                .setFirstname("Henrique")
                .build();

        when(contactRepository.create(any(ContactBO.class))).thenReturn(expectedBO);

        ContactDTO result = createContact.execute(inputDTO);

        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        assertEquals("Henrique", result.getFirstname());

        verify(contactRepository, times(1)).create(any(ContactBO.class));
    }

}
