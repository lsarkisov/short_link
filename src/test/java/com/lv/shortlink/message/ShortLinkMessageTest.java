package com.lv.shortlink.message;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ShortLinkMessageTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void init() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void clean() {
        System.setOut(standardOut);
    }

    @Test
    void showTest() {
        ShortLinkMessage.show(MessageTypes.WELCOME_MESSAGE);
        Assertions.assertEquals("\nHi! Please, add url <http://mysite.com> or <https://mysite.com> and/or keyword.\nThe keyword should be alphanumeric and contain 5 symbols:\n\n", outputStreamCaptor.toString());
    }
}