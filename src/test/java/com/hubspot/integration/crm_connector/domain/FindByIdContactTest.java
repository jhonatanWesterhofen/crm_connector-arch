package com.hubspot.integration.crm_connector.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hubspot.integration.crm_connector.domain.entities.bo.ContactBO;
import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.domain.repositories.IContactRepository;
import com.hubspot.integration.crm_connector.domain.usecase.FindByIdContact;

public class FindByIdContactTest {

    private IContactRepository contactRepository;
    private FindByIdContact findByIdContact;

    @BeforeEach
    void setup() {
        contactRepository = mock(IContactRepository.class);
        findByIdContact = new FindByIdContact(contactRepository);
    }

    @Test
    void testExecute_ReturnsContactDTO() {
        ContactBO bo = new ContactBO.Builder().setEmail("jhon@example.com").build();
        when(contactRepository.findById("123")).thenReturn(bo);

        ContactDTO result = findByIdContact.execute("123");

        assertNotNull(result);
        assertEquals("jhon@example.com", result.getEmail());
        verify(contactRepository).findById("123");
    }

    @Test
    void testExecute_ReturnsNullWhenNotFound() {
        when(contactRepository.findById("999")).thenReturn(null);

        ContactDTO result = findByIdContact.execute("999");

        assertNull(result);
    }
}