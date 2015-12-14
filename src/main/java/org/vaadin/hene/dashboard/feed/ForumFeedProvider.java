package org.vaadin.hene.dashboard.feed;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Henri Kerola / Vaadin
 */
@Component
public class ForumFeedProvider implements FeedProvider {

    @Override
    public List<FeedEntry> fetchEntries(String url, int count) {
        SyndFeedInput input = new SyndFeedInput();
        try {
            SyndFeed feed = input.build(new XmlReader(new URL(url)));
            List<FeedEntry> entries = feed.getEntries().stream()
                    .map(entry -> new FeedEntry(entry.getLink(), trimTitle(entry.getTitle())))
                    .filter(distinctByKey(e -> e.getTitle()))
                    .limit(count)
                    .collect(Collectors.toList());
            return entries;
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    protected String trimTitle(String title) {
        return title.replaceAll("^RE: ", "");
    }

    // http://stackoverflow.com/questions/23699371/java-8-distinct-by-property
    protected static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @Override
    public boolean supports(String name) {
        return "vaadin-forums".equals(name);
    }
}
