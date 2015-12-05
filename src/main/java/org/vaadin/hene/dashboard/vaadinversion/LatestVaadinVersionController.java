package org.vaadin.hene.dashboard.vaadinversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vaadin.hene.dashboard.CacheNames;

import java.io.Serializable;

/**
 * @author Henri Kerola / Vaadin
 */
@Controller
@RequestMapping("/latest-vaadin-version/")
public class LatestVaadinVersionController implements Serializable {

    @Autowired
    private LatestVaadinVersionProvider latestVaadinVersionProvider;

    @RequestMapping(method= RequestMethod.GET)
    @Cacheable(CacheNames.VAADIN_VERSION)
    public @ResponseBody String getLatestVaadinVersion() {
        return latestVaadinVersionProvider.getLatestVaadinVersion();
    }
}
