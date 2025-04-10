package com.hubspot.integration.crm_connector.infra.hubspot.database.model.repositories;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hubspot.integration.crm_connector.domain.entities.bo.ContactBO;
import com.hubspot.integration.crm_connector.domain.repositories.IContactRepository;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.Contact;
import com.hubspot.integration.crm_connector.infra.hubspot.database.model.mapper.ContactDbMapper;
import com.hubspot.integration.crm_connector.infra.hubspot.spring.SpringContactRepository;

/**
 *
 * @author Jhonatan
 */
@Repository
@Component
public class ContactRepository implements IContactRepository {

    private final SpringContactRepository jpaRepository;

    public ContactRepository(SpringContactRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ContactBO create(ContactBO contactBO) {

        Contact entity = ContactDbMapper.toEntity(contactBO);

        Contact savedEntity = jpaRepository.save(entity);

        return ContactDbMapper.toDomain(savedEntity);
    }

    @Override
    public ContactBO findByPhone(String phone) {
        Optional<Contact> entityOpt = jpaRepository.findByPhone(phone);

        return entityOpt.map(ContactDbMapper::toDomain).orElse(null);
    }

    @Override
    public ContactBO findById(String externalId) {
        Optional<Contact> entityOpt = jpaRepository.findByExternalId(externalId);

        return entityOpt.map(ContactDbMapper::toDomain).orElse(null);
    }
}