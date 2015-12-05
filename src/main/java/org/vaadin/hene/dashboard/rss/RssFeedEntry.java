package org.vaadin.hene.dashboard.rss;

import java.io.Serializable;

/**
 * @author Henri Kerola / Vaadin
 */
public class RssFeedEntry implements Serializable {

    private final String url;
    private final String title;

    public RssFeedEntry(String title) {
        this.url = null;
        this.title = title;
    }

    public RssFeedEntry(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
