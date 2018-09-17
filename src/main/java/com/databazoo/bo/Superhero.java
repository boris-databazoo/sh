package com.databazoo.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * Superhero business object.
 */
@Setter
@Getter
public class Superhero {

    private String name;

    public Superhero() {
    }

    public Superhero(String name) {
        this.name = name;
    }
}
