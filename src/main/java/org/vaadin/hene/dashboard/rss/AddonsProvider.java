package org.vaadin.hene.dashboard.rss;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Henri Kerola / Vaadin
 */
@Component
public class AddonsProvider implements FeedProvider {

    @Override
    public List<FeedEntry> fetchEntries(String url, int count) {
        RestTemplate restTemplate = new RestTemplate();
        Addons addons = restTemplate.getForObject("https://vaadin.com/Directory/resource/addon/all", Addons.class);

        return addons.getAddon().stream()
                .limit(count)
                .map(addon -> new FeedEntry(addon.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean supports(String name) {
        return "vaadin-addons".equals(name);
    }

    private static class Addons implements Serializable {

        private List<Addon> addon;

        public List<Addon> getAddon() {
            return addon;
        }

        public void setAddon(List<Addon> addon) {
            this.addon = addon;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Addon implements Serializable {

        private String name;

        public Addon() {
        }

        public Addon(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
