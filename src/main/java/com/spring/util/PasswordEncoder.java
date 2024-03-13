package com.spring.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class PasswordEncoder {

    private PasswordEncoder() {
        throw new IllegalArgumentException("Utility Class");
    }

    /**
     * This method hashes the given password using the SHA-256 algorithm.
     * Integer.toHexString(0xff & b); for password masking
     * @param password the password to be hashed
     * @return the hexadecimal hashed password using the SHA-256 algorithm
     */

    public static String hashPassword(String password) {

        byte[] passwordHash = messageDigest().digest(password.getBytes());
        StringBuilder hashedPasswordBuilder = new StringBuilder();

        for (byte b : passwordHash) {
            String maskedPasswordByte = Integer.toHexString(0xff & b);
            if (maskedPasswordByte.length() == 1) {
                hashedPasswordBuilder.append('0');
            }
            hashedPasswordBuilder.append(maskedPasswordByte);
        }

        return hashedPasswordBuilder.toString();
    }

    private static MessageDigest messageDigest() {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        return digest;
    }

}
