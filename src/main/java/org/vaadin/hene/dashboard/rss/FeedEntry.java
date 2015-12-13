package org.vaadin.hene.dashboard.rss;

import java.io.Serializable;

/**
 * @author Henri Kerola / Vaadin
 */
public class FeedEntry implements Serializable {

    private final String url;
    private final String title;

    public FeedEntry(String title) {
        this.url = null;
        this.title = title;
    }

    public FeedEntry(String url, String title) {
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
