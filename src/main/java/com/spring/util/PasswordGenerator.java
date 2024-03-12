package com.spring.util;

import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;

@Configuration
public class PasswordGenerator {

    private static final int PASSWORD_LENGTH = 8;
    private static final int ASCII_MIN = 48;
    private static final int ASCII_MAX = 122;

    public static String generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            char randomChar = (char) (random.nextInt(ASCII_MAX - ASCII_MIN + 1) + ASCII_MIN);
            password.append(randomChar);
        }

        return password.toString();
    }
}
