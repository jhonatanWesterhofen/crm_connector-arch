package com.hubspot.integration.crm_connector.domain.entities.enums;

import com.hubspot.integration.crm_connector.domain.Utils.EnumUtil;
import com.hubspot.integration.crm_connector.domain.repositories.IEnum;

/**
 *
 * @author Jhonatan
 */
public enum EnumScope implements IEnum {

    SCOPE_CONTACTS("contacts", "crm.objects.contacts.write crm.schemas.contacts.write");

    private final String key, value;

    private EnumScope(String key, String value) {
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

    public static EnumScope parseByKey(String key) {
        return (EnumScope) EnumUtil.parseByKey(EnumScope.class, key);
    }
}