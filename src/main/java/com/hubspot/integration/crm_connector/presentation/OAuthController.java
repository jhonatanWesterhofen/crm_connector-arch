package com.hubspot.integration.crm_connector.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hubspot.integration.crm_connector.service.HubSpotOAuthService;

/**
 *
 * @author Jhonatan
 */
@RestController
@RequestMapping("/oauth")
public class OAuthController {

    private final HubSpotOAuthService hubSpotOAuthService;

    public OAuthController(HubSpotOAuthService hubSpotOAuthService) {
        this.hubSpotOAuthService = hubSpotOAuthService;
    }

    @GetMapping("/callback")
    public ResponseEntity<String> handleHubspotCallback(@RequestParam("code") String code) {

        hubSpotOAuthService.callback(code);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/url")
    public ResponseEntity<String> generateUrlAuthorization() {
        return hubSpotOAuthService.createAuthorizationUrl();
    }
}