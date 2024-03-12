package com.spring.util;

import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Configuration
public class PasswordEncoder {

    public PasswordEncoder() {
    }

    /**
     * This method hashes the given password using the SHA-256 algorithm.
     *
     * @param password the password to be hashed
     * @return the hexadecimal hashed password using the SHA-256 algorithm
     */

    public static String hashPassword(String password) {

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = digest.digest(password.getBytes());

        // Create a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        // Convert the byte value to its hexadecimal representation by using masking method
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b); // masking
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

}
