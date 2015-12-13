package org.vaadin.hene.dashboard.rss;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Henri Kerola / Vaadin
 */
@Service
public class DefaultFeedProvider implements FeedProvider {

    @Override
    public List<FeedEntry> fetchEntries(String url, int count) {
        url = url.replaceAll(" ", "%20");

        // http://vaadin.com/old-forum/-/message_boards/rss?p_l_id=2890834&_19_mbCategoryId=&_19_groupId=10187&_19_topLink=recent-posts
        SyndFeedInput input = new SyndFeedInput();
        try {
            SyndFeed feed = input.build(new XmlReader(new URL(url)));
            List<FeedEntry> questions = feed.getEntries().stream()
                    .map(entry -> new FeedEntry(entry.getLink(), entry.getTitle()))
                    .limit(count)
                    .collect(Collectors.toList());
            return questions;
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public boolean supports(String name) {
        return false;
    }
}
