package com.hubspot.integration.crm_connector.infra.hubspot.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Jhonatan
 */

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLifecycleStage() {
        return lifecycleStage;
    }

    public void setLifecycleStage(String lifecycleStage) {
        this.lifecycleStage = lifecycleStage;
    }

    public String getFullNameOrEmail() {
        return fullNameOrEmail;
    }

    public void setFullNameOrEmail(String fullNameOrEmail) {
        this.fullNameOrEmail = fullNameOrEmail;
    }

    public String getEmailDomain() {
        return emailDomain;
    }

    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }

    public String getPipeline() {
        return pipeline;
    }

    public void setPipeline(String pipeline) {
        this.pipeline = pipeline;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceLabel() {
        return sourceLabel;
    }

    public void setSourceLabel(String sourceLabel) {
        this.sourceLabel = sourceLabel;
    }

    public String getIsContact() {
        return isContact;
    }

    public void setIsContact(String isContact) {
        this.isContact = isContact;
    }

    public String getIsUnworked() {
        return isUnworked;
    }

    public void setIsUnworked(String isUnworked) {
        this.isUnworked = isUnworked;
    }

    public String getMarketableStatus() {
        return marketableStatus;
    }

    public void setMarketableStatus(String marketableStatus) {
        this.marketableStatus = marketableStatus;
    }

    public String getMarketableUntilRenewal() {
        return marketableUntilRenewal;
    }

    public void setMarketableUntilRenewal(String marketableUntilRenewal) {
        this.marketableUntilRenewal = marketableUntilRenewal;
    }

    public String getAccessedPrivateContent() {
        return accessedPrivateContent;
    }

    public void setAccessedPrivateContent(String accessedPrivateContent) {
        this.accessedPrivateContent = accessedPrivateContent;
    }

    public String getInProspectingAgent() {
        return inProspectingAgent;
    }

    public void setInProspectingAgent(String inProspectingAgent) {
        this.inProspectingAgent = inProspectingAgent;
    }

    public String getProspectingCount() {
        return prospectingCount;
    }

    public void setProspectingCount(String prospectingCount) {
        this.prospectingCount = prospectingCount;
    }

    public String getSequencesCount() {
        return sequencesCount;
    }

    public void setSequencesCount(String sequencesCount) {
        this.sequencesCount = sequencesCount;
    }

    public String getRegisteredMember() {
        return registeredMember;
    }

    public void setRegisteredMember(String registeredMember) {
        this.registeredMember = registeredMember;
    }

    public String getAssociatedTargetAccounts() {
        return associatedTargetAccounts;
    }

    public void setAssociatedTargetAccounts(String associatedTargetAccounts) {
        this.associatedTargetAccounts = associatedTargetAccounts;
    }

    public String getSearchablePhone() {
        return searchablePhone;
    }

    public void setSearchablePhone(String searchablePhone) {
        this.searchablePhone = searchablePhone;
    }

    public LocalDateTime getMqlDate() {
        return mqlDate;
    }

    public void setMqlDate(LocalDateTime mqlDate) {
        this.mqlDate = mqlDate;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getNumNotes() {
        return numNotes;
    }

    public void setNumNotes(String numNotes) {
        this.numNotes = numNotes;
    }

}