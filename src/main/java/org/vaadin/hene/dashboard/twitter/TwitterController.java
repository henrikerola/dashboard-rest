package org.vaadin.hene.dashboard.twitter;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vaadin.hene.dashboard.CacheNames;
import twitter4j.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Henri Kerola / Vaadin
 */
@Controller
@RequestMapping("/vaadin-tweets/")
public class TwitterController implements Serializable {

    @RequestMapping(method= RequestMethod.GET)
    @Cacheable(CacheNames.TWITTER)
    public @ResponseBody List<Tweet> getLatestVaadinTweets() {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("#vaadin");
        try {
            List<Tweet> tweets = new ArrayList<>();
            QueryResult result = twitter.search(query);
            tweets.addAll(result.getTweets().stream()
                    .limit(5)
                    .map(status -> new Tweet(status.getId()))
                    .collect(Collectors.toList()));
            return tweets;
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
