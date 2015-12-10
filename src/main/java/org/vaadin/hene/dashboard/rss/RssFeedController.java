package org.vaadin.hene.dashboard.rss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vaadin.hene.dashboard.CacheNames;

import java.io.Serializable;
import java.util.List;

/**
 * @author Henri Kerola / Vaadin
 */
@Controller
@RequestMapping("/rss/")
public class RssFeedController implements Serializable {

    @Autowired
    private RssFeedProvider questionsProvider;

    @RequestMapping(method= RequestMethod.GET)
    @Cacheable(cacheNames = CacheNames.RSS)
    public @ResponseBody  List<RssFeedEntry> getNewestEntries(
            @RequestParam("url") String url,
            @RequestParam(value = "count", defaultValue = "10") int count) {
        return questionsProvider.fetchQuestions(url, count);
    }
}
