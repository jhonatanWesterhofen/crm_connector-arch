package com.hubspot.integration.crm_connector.domain.entities.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Getter
@Setter
public class ContactPropsResponseDTO {

    private String company;
    private LocalDateTime createdDate;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String website;
    private String lifecycleStage;
    private String fullNameOrEmail;
    private String emailDomain;
    private String pipeline;
    private String objectId;
    private String source;
    private String sourceId;
    private String sourceLabel;
    private String isContact;
    private String isUnworked;
    private String marketableStatus;
    private String marketableUntilRenewal;
    private String accessedPrivateContent;
    private String enrolledInProspectingAgent;
    private String prospectingEnrollmentCount;
    private String sequencesEnrollmentCount;
    private String registeredMember;
    private String associatedTargetAccounts;
    private String searchablePhone;
    private LocalDateTime mqlDate;
    private LocalDateTime lastModifiedDate;
    private String notesCount;

}