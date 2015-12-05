package org.vaadin.hene.dashboard.addons;

import java.io.Serializable;
import java.util.List;

/**
 * @author Henri Kerola / Vaadin
 */
public interface AddonsProvider extends Serializable {

    List<Addon> getLatestVaadinAddons();
}
