package org.vaadin.hene.dashboard.addons;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Henri Kerola / Vaadin
 */
@Service
@Profile("dummy")
@Primary
public class AddonsProviderDummy implements AddonsProvider {

    @Override
    public List<Addon> getLatestVaadinAddons() {
        List<Addon> dummyList = new ArrayList<>();

        dummyList.add(new Addon("DUMMY"));
        dummyList.add(new Addon("Waypoints Add-on"));
        dummyList.add(new Addon("OpenLayers 3 Wrapper for Vaadin"));
        dummyList.add(new Addon("OpenLayers 3 Wrapper for GWT"));
        dummyList.add(new Addon("LazyTooltip Add-on"));
        dummyList.add(new Addon("GridUtil"));
        dummyList.add(new Addon("SliderPanel"));
        dummyList.add(new Addon("ExpandingTextArea"));
        dummyList.add(new Addon("LocationTextField"));
        dummyList.add(new Addon("GridStack Add-on"));

        return dummyList;
    }
}
