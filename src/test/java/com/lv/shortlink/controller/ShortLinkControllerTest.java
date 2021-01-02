package com.lv.shortlink.controller;

import com.lv.shortlink.message.ShortLinkMessage;
import com.lv.shortlink.service.ShortLinkService;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class ShortLinkControllerTest {
    private static String url;
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeAll
    public static void all() {
        url = "https://mysite.com";
    }

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    void welcomeMessageTest() {
        provideInput("");
        new ShortLinkController();
        Assertions.assertTrue(getOutput().indexOf(ShortLinkMessage.welcomeMessage) > -1);
    }

    @Test
    void argumentValidTest() {
        provideInput("too many arguments");
        new ShortLinkController();
        Assertions.assertTrue(getOutput().indexOf(ShortLinkMessage.argumentValid) > -1);
    }

    @Test
    void urlValidWithWrongURLTest() {
        provideInput("wrong_url");
        new ShortLinkController();
        Assertions.assertTrue(getOutput().indexOf(ShortLinkMessage.urlValid) > -1);
    }

    @Test
    void urlValidWithCorrectURLTest() {
        provideInput(url);
        new ShortLinkController();
        Assertions.assertTrue(getOutput().indexOf(ShortLinkService.host) > -1);
    }

    @Test
    void keywordValidWithForbiddenSymbolsTest() {
        provideInput(url + " ~+000");
        new ShortLinkController();
        Assertions.assertTrue(getOutput().indexOf(ShortLinkMessage.keywordValid) > -1);
    }
    @Test
    void keywordValidWithWrongNumberOfArgumentsTest() {
        provideInput(url + " 1");
        new ShortLinkController();
        Assertions.assertTrue(getOutput().indexOf(ShortLinkMessage.keywordValid) > -1);
    }

    @Test
    void keywordValidWithCorrectKeywordTest() {
        provideInput(url + " abc12");
        new ShortLinkController();
        Assertions.assertTrue(getOutput().indexOf(ShortLinkService.host) > -1);
    }

}