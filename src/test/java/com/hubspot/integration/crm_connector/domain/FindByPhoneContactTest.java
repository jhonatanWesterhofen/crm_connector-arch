// package com.hubspot.integration.crm_connector.domain;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertNull;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import com.hubspot.integration.crm_connector.domain.entities.bo.ContactBO;
// import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
// import
// com.hubspot.integration.crm_connector.domain.repositories.IContactRepository;
// import
// com.hubspot.integration.crm_connector.domain.usecase.FindByPhoneContact;

// public class FindByPhoneContactTest {

// private IContactRepository contactRepository;
// private FindByPhoneContact findByPhoneContact;

// @BeforeEach
// void setup() {
// contactRepository = mock(IContactRepository.class);
// findByPhoneContact = new FindByPhoneContact(contactRepository);
// }

// @Test
// void testExecute_ReturnsDTO() {
// ContactBO bo = new ContactBO.Builder().setPhone("11999998888").build();
// when(contactRepository.findByPhone("11999998888")).thenReturn(bo);

// ContactDTO result = findByPhoneContact.execute("11999998888");

// assertNotNull(result);
// assertEquals("11999998888", result.getPhone());
// }

// @Test
// void testExecute_ReturnsNullIfNotFound() {
// when(contactRepository.findByPhone("000")).thenReturn(null);

// ContactDTO result = findByPhoneContact.execute("000");

// assertNull(result);
// }
// }