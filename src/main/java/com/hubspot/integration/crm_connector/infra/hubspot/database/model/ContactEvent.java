package com.hubspot.integration.crm_connector.infra.hubspot.database.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.hubspot.integration.crm_connector.domain.entities.enums.EnumEvent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "HB_CONTACT_EVENT")
public class ContactEvent {

    @Id
    @SequenceGenerator(name = "ID_CONTACT_EVENT", sequenceName = "GEN_CONTACT_EVENT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CONTACT_EVENT")
    private Long id;

    @Column(name = "EXTERNAL_ID", nullable = false)
    private Long externalId;

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    @Column(name = "PROPERTY_VALUE")
    private String propertyValue;

    @Column(name = "CHANGE_SOURCE")
    private String changeSource;

    @Column(name = "EVENT_ID", nullable = false)
    private Long eventId;

    @Column(name = "SUBSCRIPTION_ID")
    private Long subscriptionId;

    @Column(name = "PORTAL_ID")
    private Long portalId;

    @Column(name = "APP_ID")
    private Long appId;

    @Column(name = "OCCURRED_AT")
    private LocalDateTime occurredAt;

    @Column(name = "EVENT_TYPE")
    @Enumerated(EnumType.STRING)
    private EnumEvent eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACT_ID", nullable = false)
    private Contact contact;

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAt;

}