package org.vaadin.hene.dashboard.addons;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;

/**
 * @author Henri Kerola / Vaadin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Addon implements Serializable {

    private String name;

    public Addon() {
    }

    public Addon(String name) {
        this.name = name;
    }

    @JsonGetter("title")
    public String getName() {
        return name;
    }

    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }
}
