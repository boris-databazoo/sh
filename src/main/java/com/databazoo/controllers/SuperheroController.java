package com.databazoo.controllers;

import com.databazoo.bo.Superhero;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * A simple CRUD for {@link Superhero} entities.
 */
@RestController
public class SuperheroController {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SuperheroController.class);

    /**
     * List all
     *
     * @return superhero list
     */
    @GetMapping("/superhero")
    public List<Superhero> getList() {

        // TODO

        List<Superhero> list = Arrays.asList(new Superhero("t1"), new Superhero("t2"));
        LOG.info("Listing all " + list.size() + " elements");
        return list;
    }

    /**
     * Selecting by ID, maybe some other key will be used in future.
     *
     * @param id UUID
     * @return one superhero
     * @throws IllegalArgumentException in case ID is invalid or entity was not found
     */
    @GetMapping("/superhero/{id}")
    public Superhero getById(@PathVariable UUID id) {

        // TODO

        return new Superhero("t1");
    }

    /**
     * Create a new entity
     */
    @PostMapping("/superhero")
    public void create() {
        // TODO
    }

    /**
     * Re-save
     */
    @PutMapping("/superhero/{id}")
    public void save(@PathVariable UUID id) {
        // TODO
    }

    /**
     * Delete an entity - was not required, but still...
     */
    @DeleteMapping("/superhero/{id}")
    public void delete(@PathVariable UUID id) {
        // TODO
    }
}
