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
        Assertions.assertEquals(ShortLinkMessage.welcomeMessage, ShortLinkMessage.show(MessageTypes.WELCOME_MESSAGE));
    }
}