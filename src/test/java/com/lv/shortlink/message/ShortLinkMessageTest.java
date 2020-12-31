package com.lv.shortlink.message;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ShortLinkMessageTest {

    @Test
    void showTest() {
        Assertions.assertEquals("\nHi! Please, add url <http://mysite.com> or <https://mysite.com> and/or keyword.\nThe keyword should be alphanumeric and contain 5 symbols:\n", ShortLinkMessage.show(MessageTypes.WELCOME_MESSAGE));
    }
}