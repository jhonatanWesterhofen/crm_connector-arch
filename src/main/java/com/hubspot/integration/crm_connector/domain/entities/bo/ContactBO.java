package com.hubspot.integration.crm_connector.domain.entities.bo;

import java.util.List;

import lombok.Getter;

/**
 *
 * @author Jhonatan
 */
@Getter
public class ContactBO {

    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private String company;
    private String website;
    private String lifecyclestage;
    private boolean archived;
    private String externalId;
    private List<ContactEventBO> event;

    private ContactBO(Builder builder) {
        this.email = builder.email;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.phone = builder.phone;
        this.company = builder.company;
        this.website = builder.website;
        this.lifecyclestage = builder.lifecyclestage;
        this.archived = builder.archived;
        this.externalId = builder.externalId;
        this.event = builder.event;
    }

    public static class Builder {
        private String email;
        private String firstname;
        private String lastname;
        private String phone;
        private String company;
        private String website;
        private String lifecyclestage;
        private boolean archived;
        private String externalId;
        private List<ContactEventBO> event;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setEvent(List<ContactEventBO> event) {
            this.event = event;
            return this;
        }

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder setLifecyclestage(String lifecyclestage) {
            this.lifecyclestage = lifecyclestage;
            return this;
        }

        public Builder setArchived(boolean archived) {
            this.archived = archived;
            return this;
        }

        public Builder setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public ContactBO build() {
            return new ContactBO(this);
        }
    }
}