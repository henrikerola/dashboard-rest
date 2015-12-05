package org.vaadin.hene.dashboard.vaadinversion;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Henri Kerola / Vaadin
 */
@Service
@Profile("dummy")
@Primary
public class LatestVaadinVersionProviderDummy implements LatestVaadinVersionProvider {

    @Override
    public String getLatestVaadinVersion() {
        return "9.9.9";
    }
}
