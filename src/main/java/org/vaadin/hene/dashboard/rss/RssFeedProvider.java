package org.vaadin.hene.dashboard.rss;

import java.util.List;

/**
 * @author Henri Kerola / Vaadin
 */
public interface RssFeedProvider {

    List<RssFeedEntry> fetchQuestions(String url, int count);
}
