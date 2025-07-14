package com.smartpass.password_manager.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class PasswordGeneratorUtil {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private static final SecureRandom random = new SecureRandom();

    public String generate(int length, boolean useSymbols) {
        String allChars = UPPER + LOWER + DIGITS + (useSymbols ? SYMBOLS : "");
        return IntStream.range(0, length)
                .mapToObj(i -> allChars.charAt(random.nextInt(allChars.length())))
                .collect(Collectors.collectingAndThen(Collectors.toList(), chars -> {
                    java.util.Collections.shuffle(chars);
                    return chars.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining());
                }));
    }
}
