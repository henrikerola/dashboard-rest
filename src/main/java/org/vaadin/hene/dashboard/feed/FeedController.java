package org.vaadin.hene.dashboard.feed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vaadin.hene.dashboard.CacheNames;
import org.vaadin.hene.dashboard.ApplicationProperties;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Henri Kerola / Vaadin
 */
@Controller
@RequestMapping("/feed/")
public class FeedController implements Serializable {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationProperties applicationProperties;

    @RequestMapping(method= RequestMethod.GET)
    @Cacheable(cacheNames = CacheNames.RSS)
    public @ResponseBody  List<FeedEntry> getEntries(
            @RequestParam("name") String name,
            @RequestParam(value = "count", defaultValue = "10") int count) {

        Optional<String> urlOptional = applicationProperties.getUrlByName(name);
        return urlOptional.map(url -> {
            Map<String, FeedProvider> candidates = applicationContext.getBeansOfType(FeedProvider.class);
            FeedProvider provider = candidates.values().stream()
                    .filter(p -> p.supports(name))
                    .findFirst()
                    .orElse(applicationContext.getBean(DefaultFeedProvider.class));

            return provider.fetchEntries(url, count);
        }).orElseGet(() -> {
            // TODO log here
            return Collections.emptyList();
        });
    }
}
