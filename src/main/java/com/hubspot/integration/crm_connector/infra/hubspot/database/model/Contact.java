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
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jhonatan
 */
@Entity
@Getter
@Setter
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
}