package com.hubspot.integration.crm_connector.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hubspot.integration.crm_connector.domain.entities.dto.ContactDTO;

/**
 *
 * @author Jhonatan
 */
@RestController
@RequestMapping("/crm")
public class CrmController {

    @PostMapping("/contacts")
    public ResponseEntity<Void> createContact(@RequestBody ContactDTO dto) {

        return ResponseEntity.ok().build();
    }

}
