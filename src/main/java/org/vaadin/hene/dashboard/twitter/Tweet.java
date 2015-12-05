package org.vaadin.hene.dashboard.twitter;

/**
 * @author Henri Kerola / Vaadin
 */
public class Tweet {

    private final String id;

    public Tweet(long id) {
        this.id = String.valueOf(id);
    }

    public String getId() {
        return id;
    }
}
