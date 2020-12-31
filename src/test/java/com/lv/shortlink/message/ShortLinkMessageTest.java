package com.lv.shortlink.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShortLinkMessageTest {

    @Test
    void showTest() {
        Assertions.assertEquals(ShortLinkMessage.welcomeMessage, ShortLinkMessage.show(MessageTypes.WELCOME_MESSAGE));
        Assertions.assertEquals(ShortLinkMessage.argumentValid, ShortLinkMessage.show(MessageTypes.ARGUMENTS_VALID));
        Assertions.assertEquals(ShortLinkMessage.urlValid, ShortLinkMessage.show(MessageTypes.URL_VALID));
        Assertions.assertEquals(ShortLinkMessage.keywordValid, ShortLinkMessage.show(MessageTypes.KEYWORD_VALID));
        Assertions.assertEquals(
                String.format("%stest%s", ShortLinkMessage.shorLinkExists1, ShortLinkMessage.shorLinkExists2), ShortLinkMessage.show(MessageTypes.SHORT_LINK_EXISTS, "test"));
    }
}