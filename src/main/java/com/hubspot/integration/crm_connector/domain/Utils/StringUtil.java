package com.hubspot.integration.crm_connector.domain.Utils;

import java.text.MessageFormat;

/**
 *
 * @author Jhonatan
 */
public class StringUtil {

    public static String bearerToken(String token) {
        return "Bearer " + token;
    }

    public static String stringPatternFormat(String pattern, Object... arguments) {
        return MessageFormat.format(pattern, arguments);
    }
}