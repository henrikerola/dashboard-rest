package org.vaadin.hene.dashboard.rss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vaadin.hene.dashboard.CacheNames;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Henri Kerola / Vaadin
 */
@Controller
@RequestMapping("/rss/")
public class RssFeedController implements Serializable {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(method= RequestMethod.GET)
    @Cacheable(cacheNames = CacheNames.RSS)
    public @ResponseBody  List<RssFeedEntry> getNewestEntries(
            @RequestParam("url") String url,
            @RequestParam(value = "count", defaultValue = "10") int count) {

        Map<String, RssFeedProvider> candidates = applicationContext.getBeansOfType(RssFeedProvider.class);
        RssFeedProvider provider = candidates.values().stream()
                .filter(p -> p.supports(url))
                .findFirst()
                .orElse(applicationContext.getBean(DefaultRssFeedProvider.class));

        return provider.fetchQuestions(url, count);
    }
}
