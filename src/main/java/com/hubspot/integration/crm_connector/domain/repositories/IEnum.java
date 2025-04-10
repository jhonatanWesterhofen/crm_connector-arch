package com.hubspot.integration.crm_connector.domain.repositories;

/**
 *
 * @author Jhonatan
 */
public interface IEnum {

    public String getKey();

    public String getValue();

    public boolean containsInEnum(String key);

}