package com.hubspot.integration.crm_connector.domain.Utils;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtil {

    public static String textEncrypt(final String plainText, final String key) {
        try {

            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] keyBytes = sha.digest(key.getBytes("UTF-8"));
            SecretKeySpec secretKey = new SecretKeySpec(Arrays.copyOf(keyBytes, 16), "AES");

            byte[] iv = new byte[16];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

            byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));

            byte[] encryptedWithIv = new byte[iv.length + encrypted.length];
            System.arraycopy(iv, 0, encryptedWithIv, 0, iv.length);
            System.arraycopy(encrypted, 0, encryptedWithIv, iv.length, encrypted.length);

            return Base64.getEncoder().encodeToString(encryptedWithIv);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String textDecrypt(final String cipherText, final String key) {

        try {
            var aesKey = new SecretKeySpec(key.getBytes(), "AES");
            var cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.DECRYPT_MODE, aesKey);

            var decordedValue = java.util.Base64.getDecoder().decode(cipherText);
            var decValue = cipher.doFinal(decordedValue);

            return new String(decValue);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
