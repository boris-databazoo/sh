package com.databazoo.service;

import com.databazoo.bo.Superhero;

import java.util.List;
import java.util.UUID;

public interface SuperheroService {
    List<Superhero> listAll();

    Superhero getById(UUID id);

    Superhero create(Superhero entity);

    Superhero update(Superhero entity);

    void delete(Superhero entity);

}
