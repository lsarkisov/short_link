package com.lv.shortlink.message;

public class ShortLinkMessage {
    static public String show(MessageTypes type) {
        switch (type) {
            case WELCOME_MESSAGE:
                return "\nHi! Please, add url <http://mysite.com> or <https://mysite.com> and/or keyword.\nThe keyword should be alphanumeric and contain 5 symbols:\n";
            case ARGUMENTS_VALID:
                return "The arguments should be 1 or 2";
            case URL_VALID:
                return "The url is not valid. Please, add valid url like http://mysite.com";
            case KEYWORD_VALID:
                return "The keyword is not valid. It should be alphanumeric and contain 5 symbols";
            default:
                return "";
        }
    }

    static public String show(MessageTypes type, String keyword) {
        if (type.equals(MessageTypes.SHORT_LINK_EXISTS)) {
            return "The keyword " + keyword + " exists. Please, add unique keyword";
        }
        return "";
    }
}
