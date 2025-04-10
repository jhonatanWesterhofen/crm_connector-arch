package com.hubspot.integration.crm_connector.infra.hubspot.spring;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hubspot.integration.crm_connector.infra.hubspot.database.model.Contact;

@Repository
public interface SpringContactRepository extends JpaRepository<Contact, Integer> {

    Optional<Contact> findByPhone(String phone);

    Optional<Contact> findByExternalId(String externalId);

}