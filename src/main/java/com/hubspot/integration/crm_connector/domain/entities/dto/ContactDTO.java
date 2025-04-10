package com.hubspot.integration.crm_connector.domain.entities.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Getter
@Setter
public class ContactDTO {

    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private String company;
    private String website;
    private String lifecyclestage;
    private boolean archived;
    private String externalId;
    private List<ContactEventDTO> event;

}