package com.lv.shortlink.message;

public class ShortLinkMessage {
    public static final String welcomeMessage = "Hi! Please, add url <http://mysite.com> or <https://mysite.com> and/or keyword.\nThe keyword should be alphanumeric and contain 5 symbols:";
    public static final String argumentValid = "The arguments should be 1 or 2";
    public static final String urlValid = "The url is not valid. Please, add valid url like http://mysite.com";
    public static final String keywordValid = "The keyword is not valid. It should be alphanumeric and contain 5 symbols";
    public static final String shorLinkExists1 = "The keyword ";
    public static final String shorLinkExists2 = " exists. Please, add unique keyword";

    static public String show(MessageTypes type) {
        switch (type) {
            case WELCOME_MESSAGE:
                return welcomeMessage;
            case ARGUMENTS_VALID:
                return argumentValid;
            case URL_VALID:
                return urlValid;
            case KEYWORD_VALID:
                return keywordValid;
            default:
                return "";
        }
    }

    static public String show(MessageTypes type, String keyword) {
        if (type.equals(MessageTypes.SHORT_LINK_EXISTS)) {
            return shorLinkExists1 + keyword + shorLinkExists2;
        }
        return "";
    }
}
