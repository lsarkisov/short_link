package com.lv.shortlink.controller;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ShortLinkControllerTest {
    private static String url;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private ByteArrayInputStream testIn;

    @BeforeAll
    public static void all() {
        url = "https://mysite.com";
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @BeforeEach
    public void init() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void clean() {
        System.setOut(standardOut);
    }

    @Test
    void getShortLinkWithNoKeywordTest() {
        provideInput(url);
        final ShortLinkController shortLinkController = new ShortLinkController();
        shortLinkController.getShortLinkWithNoKeyword(url);
    }

}