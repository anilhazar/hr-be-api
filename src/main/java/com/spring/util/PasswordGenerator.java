package com.spring.util;

import java.security.SecureRandom;


public final class PasswordGenerator {

    private static final int PASSWORD_LENGTH = 8;
    private static final int ASCII_MIN = 48;
    private static final int ASCII_MAX = 122;

    private static final SecureRandom random = new SecureRandom();

    private PasswordGenerator() {
        throw new IllegalArgumentException("Utility Class");
    }

    public static String generate() {

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            char randomChar = (char) (random.nextInt(ASCII_MAX - ASCII_MIN + 1) + ASCII_MIN);
            password.append(randomChar);
        }

        return password.toString();
    }
}
