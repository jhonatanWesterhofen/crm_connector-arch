package com.hubspot.integration.crm_connector.infra.hubspot.database.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 *
 * @author Jhonatan
 */
@Entity
@Table(name = "HB_CONTACT")
public class Contact {

    @Id
    @SequenceGenerator(name = "ID_CONTACT", sequenceName = "GEN_CONTACT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CONTACT")
    private Integer id;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "FIRST_NAME")
    private String firstname;

    @Column(name = "LAST_NAME")
    private String lastname;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "LIFECYCLE_STAGE")
    private String lifecyclestage;

    @Column(name = "ARCHIVED")
    private boolean archived;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @CreationTimestamp
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "SENT_TO_HUBSPOT")
    private boolean sentToHubspot = false;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactEvent> events = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLifecyclestage() {
        return lifecyclestage;
    }

    public void setLifecyclestage(String lifecyclestage) {
        this.lifecyclestage = lifecyclestage;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isSentToHubspot() {
        return sentToHubspot;
    }

    public void setSentToHubspot(boolean sentToHubspot) {
        this.sentToHubspot = sentToHubspot;
    }

    public List<ContactEvent> getEvents() {
        return events;
    }

    public void setEvents(List<ContactEvent> events) {
        this.events = events;
    }

}