package org.vaadin.hene.dashboard.addons;

import java.io.Serializable;
import java.util.List;

/**
 * @author Henri Kerola / Vaadin
 */
public class Addons implements Serializable {

    private List<Addon> addon;

    public List<Addon> getAddon() {
        return addon;
    }

    public void setAddon(List<Addon> addon) {
        this.addon = addon;
    }
}
