package com.lv.shortlink.service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Random;
import java.util.regex.Pattern;

public class ShortLinkService {
    static public final String host = "https://short.en/";
    static public final int leftLimit = 48;
    static public final int rightLimit = 122;
    static public final int targetStringLength = 5;
    static public final Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]*$");
    static private Random random = new Random();

    /**
     * Generates short link with alphanumeric path if
     * keyword was not provided
     *
     * @return  String generated short link
     */
    public static String generateKeyword() {
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    /**
     * Generates short link with alphanumeric path
     *
     * @param keyword   String provided by user
     * @return          String generated short link
     */
    public static String genShortLink(String keyword) {
        return host + keyword;
    }

    /**
     * Validates if argument is valid url
     *
     * @param url   String url provided by user
     * @return boolean
     */
    public static boolean isUrlValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    /**
     * Validates if keyword is alphanumeric and it's length is equal to 5
     *
     * @param keyword   String keyword provided by user which will be
     *                  added as a path of short link
     * @return boolean
     */
    public static boolean isKeywordValid(String keyword) {
        if (pattern.matcher(keyword).find() && keyword.length() == 5) {
            return true;
        }
        return false;
    }
}
