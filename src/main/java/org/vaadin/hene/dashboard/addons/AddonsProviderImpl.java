package org.vaadin.hene.dashboard.addons;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Henri Kerola / Vaadin
 */
@Service
public class AddonsProviderImpl implements AddonsProvider {

    @Override
    public List<Addon> getLatestVaadinAddons() {
        RestTemplate restTemplate = new RestTemplate();
        Addons addons = restTemplate.getForObject("https://vaadin.com/Directory/resource/addon/all", Addons.class);

        return addons.getAddon().stream()
                .limit(10)
                .collect(Collectors.toList());
    }
}
