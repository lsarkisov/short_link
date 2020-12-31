package com.lv.shortlink.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ShortLinkModelTest {
    static String url;
    static String keyword;

    @BeforeAll
    public static void init() {
        url = "https://mysite.com";
        keyword = "abC12";
    }

    @Test
    void setShortLinkTest() {
        final ShortLinkModel shortLinkModel = new ShortLinkModel();
        boolean result = shortLinkModel.setShortLink(url, keyword);

        Assertions.assertTrue(result);

        final String s = shortLinkModel.getShortLinks().get(url);
        Assertions.assertEquals(s, keyword);

        Assertions.assertTrue(shortLinkModel.isShortLinkExists(url));
    }

}