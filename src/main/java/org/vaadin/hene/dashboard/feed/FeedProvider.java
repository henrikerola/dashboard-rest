package org.vaadin.hene.dashboard.feed;

import java.util.List;

/**
 * @author Henri Kerola / Vaadin
 */
public interface FeedProvider {

    List<FeedEntry> fetchEntries(String url, int count);

    boolean supports(String name);
}
