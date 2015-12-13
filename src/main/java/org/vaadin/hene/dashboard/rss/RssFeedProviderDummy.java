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
public class RssFeedProviderDummy implements RssFeedProvider {

    @Override
    public List<RssFeedEntry> fetchQuestions(String url, int count) {
        List<RssFeedEntry> questions = new ArrayList<>();

        questions.add(new RssFeedEntry("DUMMY"));
        questions.add(new RssFeedEntry("Lots of new Vaadin + Liferay material available"));
        questions.add(new RssFeedEntry("Vaadin Certification week coming up!"));
        questions.add(new RssFeedEntry("Building a comprehensive UI from scratch with Vaadin Designer"));
        questions.add(new RssFeedEntry("Using Polymer Elements in GWT development"));
        questions.add(new RssFeedEntry("Vaadin Debug Window"));
        questions.add(new RssFeedEntry("Using templates in Vaadin Designer"));
        questions.add(new RssFeedEntry("Vaadin Designer 1.0 has arrived"));
        questions.add(new RssFeedEntry("10+1 things to know about Vaadin for job seekers"));
        questions.add(new RssFeedEntry("Building a mobile-first app with Polymer and Vaadin Elements"));

        return questions;
    }

    @Override
    public boolean supports(String name) {
        return false;
    }
}
