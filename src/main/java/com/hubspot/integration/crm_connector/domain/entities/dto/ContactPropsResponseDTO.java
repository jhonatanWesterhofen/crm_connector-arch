package com.hubspot.integration.crm_connector.domain.entities.dto;

import java.time.LocalDateTime;

/**
 *
 * @author Jhonatan
 */
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

    public String getEnrolledInProspectingAgent() {
        return enrolledInProspectingAgent;
    }

    public void setEnrolledInProspectingAgent(String enrolledInProspectingAgent) {
        this.enrolledInProspectingAgent = enrolledInProspectingAgent;
    }

    public String getProspectingEnrollmentCount() {
        return prospectingEnrollmentCount;
    }

    public void setProspectingEnrollmentCount(String prospectingEnrollmentCount) {
        this.prospectingEnrollmentCount = prospectingEnrollmentCount;
    }

    public String getSequencesEnrollmentCount() {
        return sequencesEnrollmentCount;
    }

    public void setSequencesEnrollmentCount(String sequencesEnrollmentCount) {
        this.sequencesEnrollmentCount = sequencesEnrollmentCount;
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

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getNotesCount() {
        return notesCount;
    }

    public void setNotesCount(String notesCount) {
        this.notesCount = notesCount;
    }
}