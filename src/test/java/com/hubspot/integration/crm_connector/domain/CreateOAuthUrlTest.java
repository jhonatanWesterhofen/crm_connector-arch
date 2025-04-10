package com.hubspot.integration.crm_connector.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hubspot.integration.crm_connector.domain.repositories.IOAuthRepository;
import com.hubspot.integration.crm_connector.domain.usecase.CreateOAuthUrl;

public class CreateOAuthUrlTest {

    private IOAuthRepository authRepository;
    private CreateOAuthUrl createOAuthUrl;

    @BeforeEach
    void setup() {
        authRepository = mock(IOAuthRepository.class);
        createOAuthUrl = new CreateOAuthUrl(authRepository);
    }

    @Test
    void testExecute_ReturnsUrl() {
        String expectedUrl = "https://oauth.connector.com";
        when(authRepository.createAuthorizationUrl()).thenReturn(expectedUrl);

        String result = createOAuthUrl.execute();

        assertEquals(expectedUrl, result);
        verify(authRepository, times(1)).createAuthorizationUrl();
    }

}
