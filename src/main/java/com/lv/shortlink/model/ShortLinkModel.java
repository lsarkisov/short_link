package com.lv.shortlink.model;

import java.util.HashMap;
import java.util.Map;

public class ShortLinkModel {
    Map<String, String > shortLink;

    public ShortLinkModel() {
        this.shortLink = new HashMap<>();
    }

    /**
     * Get all stored short links
     *
     * @return the all stored links
     *         in Map<The user link, Short link>
     */
    public Map<String, String> getShortLinks() {
        return shortLink;
    }

    /**
     * Save the link provided by user and short link in store
     *
     * @param newLink       the link provided for conversion
     * @param newShortLink  the new generated short link
     * @return boolean      is short link saved
     */
    public boolean setShortLink(String newLink, String newShortLink) {
        if (!isShortLinkExists(newLink)) {
            this.shortLink.put(newLink, newShortLink);
            return true;
        }
        return false;
    }

    /**
     * Checks if the link for conversion exists
     *
     * @param newLink   the link provided for conversion
     * @return boolean  is short link exists
     */
    public boolean isShortLinkExists(String newLink) {
        return shortLink.containsValue(newLink);
    }

    /**
     * Return user link if short link exists in store
     *
     * @param url String short link
     * @return String user link or empty string
     */
    public String getUserLink(String url) {
        for (var s : shortLink.entrySet()) {
            if (s.getValue().equals(url)) {
                return s.getKey();
            }
        }
        return "";
    }
}
