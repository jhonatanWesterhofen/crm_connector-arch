package com.hubspot.integration.crm_connector.domain.repositories;

/**
 *
 * @author Jhonatan
 */
public interface IEnum {

    public String getKey();

    public boolean containsInEnum(String key);

}