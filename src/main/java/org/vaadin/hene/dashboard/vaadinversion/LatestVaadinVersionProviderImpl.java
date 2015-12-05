package org.vaadin.hene.dashboard.vaadinversion;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Henri Kerola / Vaadin
 */
@Service
public class LatestVaadinVersionProviderImpl implements LatestVaadinVersionProvider {

    @Override
    public String getLatestVaadinVersion() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://vaadin.com/download/LATEST7", String.class);
        String version = result.split("\n")[0];

        return version;
    }
}
