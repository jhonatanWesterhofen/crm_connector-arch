package com.hubspot.integration.crm_connector.domain.entities.enums;

import com.hubspot.integration.crm_connector.domain.Utils.EnumUtil;
import com.hubspot.integration.crm_connector.domain.repositories.IEnum;

/**
 *
 * @author Jhonatan
 */
public enum EnumEvent implements IEnum {

    CREATE_CONTACT("contact.creation", "Criação de um novo contato");

    private final String key, value;

    private EnumEvent(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean containsInEnum(String key) {
        return parseByKey(key) != null;
    }

    public static EnumEvent parseByKey(String key) {
        return (EnumEvent) EnumUtil.parseByKey(EnumEvent.class, key);
    }

}
