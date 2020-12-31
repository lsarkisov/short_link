package com.lv.shortlink.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShortLinkServiceTest {
    static String url;
    static String wrongUrl;

    @BeforeAll
    public static void init() {
        url = "https://mysite.com";
        wrongUrl = "wrong url";
    }

    @Test
    void generateKeywordTest() {
        final String keyword = ShortLinkService.generateKeyword();
        Assertions.assertEquals(keyword.length(), 5);
    }

    @Test
    void genShortLinkTest() {
        final String shortLink = ShortLinkService.host + ShortLinkService.generateKeyword();
        Assertions.assertTrue(ShortLinkService.isUrlValid(shortLink));
    }

    @Test
    void isUrlValidTest() {
        Assertions.assertEquals(ShortLinkService.isUrlValid(wrongUrl), false);
        Assertions.assertTrue(ShortLinkService.isUrlValid(url));
    }

    @Test
    void isKeywordValidTest() {
        Assertions.assertTrue(!ShortLinkService.isKeywordValid("     "));
        Assertions.assertTrue(!ShortLinkService.isKeywordValid("~0000"));
        Assertions.assertTrue(ShortLinkService.isKeywordValid("aCd20"));
    }
}