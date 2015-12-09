package org.vaadin.hene.dashboard.addons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vaadin.hene.dashboard.CacheNames;

import java.io.Serializable;
import java.util.List;

/**
 * @author Henri Kerola / Vaadin
 */
@Controller
@RequestMapping("/latest-vaadin-addons/")
public class AddonsController implements Serializable {

    @Autowired
    private AddonsProvider vaadinAddonsProvider;

    @RequestMapping(method= RequestMethod.GET)
    @Cacheable(CacheNames.ADDONS)
    public @ResponseBody List<Addon> getLatestVaadinAddons(@RequestParam(value = "count", defaultValue = "10") int count) {
        return vaadinAddonsProvider.getLatestVaadinAddons(count);
    }


}
