package com.hubspot.integration.crm_connector.infra.hubspot.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Getter
@Setter
public class HbContactDTO {

    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private String company;
    private String website;
    private String lifecyclestage;

}
