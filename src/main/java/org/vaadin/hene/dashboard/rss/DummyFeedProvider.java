package org.vaadin.hene.dashboard.rss;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Henri Kerola / Vaadin
 */
@Service
@Profile("dummy")
@Primary
public class DummyFeedProvider implements FeedProvider {

    @Override
    public List<FeedEntry> fetchEntries(String url, int count) {
        List<FeedEntry> questions = new ArrayList<>();

        questions.add(new FeedEntry("DUMMY"));
        questions.add(new FeedEntry("Lots of new Vaadin + Liferay material available"));
        questions.add(new FeedEntry("Vaadin Certification week coming up!"));
        questions.add(new FeedEntry("Building a comprehensive UI from scratch with Vaadin Designer"));
        questions.add(new FeedEntry("Using Polymer Elements in GWT development"));
        questions.add(new FeedEntry("Vaadin Debug Window"));
        questions.add(new FeedEntry("Using templates in Vaadin Designer"));
        questions.add(new FeedEntry("Vaadin Designer 1.0 has arrived"));
        questions.add(new FeedEntry("10+1 things to know about Vaadin for job seekers"));
        questions.add(new FeedEntry("Building a mobile-first app with Polymer and Vaadin Elements"));

        return questions;
    }

    @Override
    public boolean supports(String name) {
        return false;
    }
}
