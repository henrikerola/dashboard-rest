package org.vaadin.hene.dashboard;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Henri Kerola / Vaadin
 */
@Component
@ConfigurationProperties
public class ApplicationProperties {

    public Map<String, String> feed = new HashMap<>();

    /**
     * This is here for Spring, don't call this method.
     */
    @Deprecated
    public Map<String, String> getFeed() {
        return feed;
    }

    public Optional<String> getFeedUrlByName(String name) {
        return Optional.ofNullable(feed.get(name));
    }
}
