package org.vaadin.hene.dashboard.addons;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Henri Kerola / Vaadin
 */
@Service
@Profile("dummy")
@Primary
public class AddonsProviderDummy implements AddonsProvider {

    @Override
    public List<Addon> getLatestVaadinAddons(int count) {
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
        dummyList.add(new Addon("VaadStrap"));
        dummyList.add(new Addon("Sticky"));
        dummyList.add(new Addon("Html2Canvas Screenshot"));
        dummyList.add(new Addon("SignatureField"));
        dummyList.add(new Addon("custommenubar"));
        dummyList.add(new Addon("V-Leaflet-Heat"));
        dummyList.add(new Addon("V-Leaflet"));
        dummyList.add(new Addon("g-leaflet"));
        dummyList.add(new Addon("Bean DataSource Spring Add-on"));
        dummyList.add(new Addon("Bean DataSource Add-on"));

        return dummyList.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
