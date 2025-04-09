package com.hubspot.integration.crm_connector.infra.hubspot.spring;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hubspot.integration.crm_connector.domain.entities.enums.EnumScope;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.TokenRequest;

/**
 *
 * @author Jhonatan
 */
@Repository
public interface SpringTokenRequestRepository extends JpaRepository<TokenRequest, Integer> {

    Optional<TokenRequest> findTopByScopeOrderByCreatedAtDesc(EnumScope scope);

}