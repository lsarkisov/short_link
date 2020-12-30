package com.lv.shortlink.message;

public class ShortLinkMessage {
    static public void show(MessageTypes type) {
        switch (type) {
            case WELCOME_MESSAGE:
                System.out.println("\nHi! Please, add url <http://mysite.com> or <https://mysite.com> and/or keyword.\nThe keyword should be alphanumeric and contain 5 symbols:\n");
                break;
            case ARGUMENTS_VALID:
                System.out.println("The arguments should be 1 or 2");
                break;
            case URL_VALID:
                System.out.println("The url is not valid. Please, add valid url like http://mysite.com");
                break;
            case KEYWORD_VALID:
                System.out.println("The keyword is not valid. It should be alphanumeric and contain 5 symbols");
                break;
            default:
        }
    }

    static public void show(MessageTypes type, String keyword) {
        if (type.equals(MessageTypes.SHORT_LINK_EXISTS)) {
            System.out.println("The keyword " + keyword + " exists. Please, add unique keyword");
        }
    }
}
