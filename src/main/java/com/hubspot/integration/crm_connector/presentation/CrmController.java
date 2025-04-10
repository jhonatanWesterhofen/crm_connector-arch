package com.hubspot.integration.crm_connector.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;
import com.hubspot.integration.crm_connector.service.CrmService;

/**
 *
 * @author Jhonatan
 */
@RestController
@RequestMapping("/crm")
public class CrmController {

    private final CrmService crmService;

    public CrmController(CrmService crmService) {
        this.crmService = crmService;
    }

    @PostMapping("/contacts")
    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO dto) {
        return crmService.createContact(dto);
    }
}