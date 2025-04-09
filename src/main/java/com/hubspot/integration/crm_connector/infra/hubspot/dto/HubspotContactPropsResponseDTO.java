package com.hubspot.integration.crm_connector.infra.hubspot.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Getter
@Setter
public class HubspotContactPropsResponseDTO {

    @JsonProperty("company")
    private String company;

    @JsonProperty("createdate")
    private LocalDateTime createdDate;

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("website")
    private String website;

    @JsonProperty("lifecyclestage")
    private String lifecycleStage;

    @JsonProperty("hs_full_name_or_email")
    private String fullNameOrEmail;

    @JsonProperty("hs_email_domain")
    private String emailDomain;

    @JsonProperty("hs_pipeline")
    private String pipeline;

    @JsonProperty("hs_object_id")
    private String objectId;

    @JsonProperty("hs_object_source")
    private String source;

    @JsonProperty("hs_object_source_id")
    private String sourceId;

    @JsonProperty("hs_object_source_label")
    private String sourceLabel;

    @JsonProperty("hs_is_contact")
    private String isContact;

    @JsonProperty("hs_is_unworked")
    private String isUnworked;

    @JsonProperty("hs_marketable_status")
    private String marketableStatus;

    @JsonProperty("hs_marketable_until_renewal")
    private String marketableUntilRenewal;

    @JsonProperty("hs_membership_has_accessed_private_content")
    private String accessedPrivateContent;

    @JsonProperty("hs_currently_enrolled_in_prospecting_agent")
    private String inProspectingAgent;

    @JsonProperty("hs_prospecting_agent_actively_enrolled_count")
    private String prospectingCount;

    @JsonProperty("hs_sequences_actively_enrolled_count")
    private String sequencesCount;

    @JsonProperty("hs_registered_member")
    private String registeredMember;

    @JsonProperty("hs_associated_target_accounts")
    private String associatedTargetAccounts;

    @JsonProperty("hs_searchable_calculated_phone_number")
    private String searchablePhone;

    @JsonProperty("hs_lifecyclestage_marketingqualifiedlead_date")
    private LocalDateTime mqlDate;

    @JsonProperty("lastmodifieddate")
    private LocalDateTime lastModified;

    @JsonProperty("num_notes")
    private String numNotes;
}