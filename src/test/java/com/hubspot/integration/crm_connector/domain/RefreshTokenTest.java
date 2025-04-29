// package com.hubspot.integration.crm_connector.domain;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertNull;
// import static org.mockito.ArgumentMatchers.anyString;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;
// import
// com.hubspot.integration.crm_connector.domain.repositories.IOAuthRepository;
// import com.hubspot.integration.crm_connector.domain.usecase.RefreshToken;

// public class RefreshTokenTest {

// private IOAuthRepository authRepository;
// private RefreshToken refreshToken;

// @BeforeEach
// void setUp() {
// authRepository = mock(IOAuthRepository.class);
// refreshToken = new RefreshToken(authRepository);
// }

// @Test
// void testExecute_ReturnsTokenDTO() {
// String refreshTokenStr = "refresh_456";
// TokenDTO expectedToken = new TokenDTO();
// expectedToken.setAccessToken("newAccess123");

// when(authRepository.refreshAccessToken(refreshTokenStr)).thenReturn(expectedToken);

// TokenDTO result = refreshToken.execute(refreshTokenStr);

// assertNotNull(result);
// assertEquals("newAccess123", result.getAccessToken());
// verify(authRepository, times(1)).refreshAccessToken(refreshTokenStr);
// }

// @Test
// void testExecute_ReturnsNullOnInvalidToken() {
// when(authRepository.refreshAccessToken(anyString())).thenReturn(null);

// TokenDTO result = refreshToken.execute("invalid_token");

// assertNull(result);
// }
// }