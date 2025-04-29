// package com.hubspot.integration.crm_connector.domain;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import com.hubspot.integration.crm_connector.domain.entities.bo.TokenBO;
// import com.hubspot.integration.crm_connector.domain.entities.dto.TokenDTO;
// import
// com.hubspot.integration.crm_connector.domain.repositories.ITokenRepository;
// import com.hubspot.integration.crm_connector.domain.usecase.CreateToken;

// public class CreateTokenTest {

// private ITokenRepository tokenRepository;
// private CreateToken createToken;

// @BeforeEach
// void setup() {
// tokenRepository = mock(ITokenRepository.class);
// createToken = new CreateToken(tokenRepository);
// }

// @Test
// void testExecute_ShouldReturnTokenDTO() {
// TokenDTO input = new TokenDTO();
// input.setAccessToken("abc123");

// TokenBO tokenBO = new TokenBO.Builder().setAccessToken("abc123").build();

// when(tokenRepository.createToken(any(TokenBO.class))).thenReturn(tokenBO);

// TokenDTO result = createToken.execute(input);

// assertNotNull(result);
// assertEquals("abc123", result.getAccessToken());
// verify(tokenRepository, times(1)).createToken(any(TokenBO.class));
// }
// }