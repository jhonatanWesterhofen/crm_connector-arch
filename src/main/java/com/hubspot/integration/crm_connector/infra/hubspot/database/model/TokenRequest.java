package com.hubspot.integration.crm_connector.infra.hubspot.database.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.hubspot.integration.crm_connector.domain.entities.enums.EnumScope;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "HB_TOKEN_REQUEST")
public class TokenRequest {

    @Id
    @SequenceGenerator(name = "ID_TOKEN_REQUEST", sequenceName = "GEN_TOKEN_REQUEST", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_TOKEN_REQUEST")
    private Integer id;

    @Column(name = "TOKEN_TYPE")
    private String tokenType;

    @Column(name = "ACCESS_TOKEN", nullable = false, length = 4000)
    private String accessToken;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @Column(name = "EXPIRES_IN")
    private LocalDateTime expiresIn;

    @Column(name = "SCOPE")
    @Enumerated(EnumType.STRING)
    private EnumScope scope;

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAt;

}