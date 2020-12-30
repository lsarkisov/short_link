package com.lv.shortlink.controller;

import com.lv.shortlink.message.MessageTypes;
import com.lv.shortlink.message.ShortLinkMessage;
import com.lv.shortlink.model.ShortLinkModel;
import com.lv.shortlink.service.ShortLinkService;

import java.util.Scanner;

public class ShortLinkController {
    final Scanner scanner;
    final ShortLinkModel shortLinkModel;

    public ShortLinkController() {
        this.scanner = new Scanner(System.in);
        this.shortLinkModel = new ShortLinkModel();

        ShortLinkMessage.show(MessageTypes.WELCOME_MESSAGE);

        while (scanner.hasNextLine()) {
            final String[] params = scanner.nextLine().split(" ");
            switch (params.length) {
                case 1:
                    getShortLinkWithNoKeyword(params[0]);
                    break;
                case 2:
                    getShortLinkWithKeyword(params[0], params[1]);
                    break;
                default:
                    ShortLinkMessage.show(MessageTypes.ARGUMENTS_VALID);
            }
        }
    }

    private void getShortLinkWithNoKeyword(String url) {
        if (url.equals("q")) {
            System.exit(1);
        }

        final String keyword = ShortLinkService.generateKeyword();

        if (validateIfShortLinkExists(keyword)) {
            getShortLinkWithNoKeyword(url);
        }

        if (validateAll(url)) {
            final String shortLink = ShortLinkService.genShortLink(keyword);
            shortLinkModel.setShortLink(url, shortLink);
            System.out.println(shortLink);
        }
    }

    private void getShortLinkWithKeyword(String url, String keyword) {
        if (validateAll(url, keyword)) {
            final String shortLink = ShortLinkService.genShortLink(keyword);
            shortLinkModel.setShortLink(url, shortLink);
            System.out.println(shortLink);
        }
    }

    private boolean validateAll(String url) {
        return validateUrl(url);
    }

    private boolean validateAll(String url, String keyword) {
        return validateUrl(url)
                && validateKeyword(keyword)
                && !validateIfShortLinkExists(keyword);
    }

    private boolean validateUrl(String url) {
        if (!ShortLinkService.isUrlValid(url)) {
            ShortLinkMessage.show(MessageTypes.URL_VALID);
            return false;
        }
        return true;
    }

    private boolean validateKeyword(String keyword) {
        if (!ShortLinkService.isKeywordValid(keyword)) {
            ShortLinkMessage.show(MessageTypes.KEYWORD_VALID);
            return false;
        }
        return true;
    }

    private boolean validateIfShortLinkExists(String keyword) {
        if (shortLinkModel.isShortLinkExists(keyword)) {
            ShortLinkMessage.show(MessageTypes.SHORT_LINK_EXISTS, keyword);
            return true;
        }
        return false;
    }
}
