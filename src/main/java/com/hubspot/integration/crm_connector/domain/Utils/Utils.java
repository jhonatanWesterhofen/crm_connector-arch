package com.hubspot.integration.crm_connector.domain.Utils;

/**
 *
 * @author Jhonatan
 */
public class Utils {

    public static <T> boolean isNull(T value) {
        return value == null ? true : false;
    }

    public static <T> boolean isNotNull(T value) {
        return value == null ? false : true;
    }
}