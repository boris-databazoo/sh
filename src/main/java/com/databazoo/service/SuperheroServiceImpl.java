package com.databazoo.service;

import com.databazoo.bo.Superhero;
import com.databazoo.dao.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SuperheroServiceImpl implements SuperheroService {

    @Autowired
    private SuperheroRepository dao;

    @Override
    public List<Superhero> listAll() {
        List<Superhero> target = new ArrayList<>();
        dao.findAll().forEach(target::add);
        return target;
    }

    @Override
    public Superhero getById(UUID id) {
        return dao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Superhero with ID " + id + " not found"));
    }

    @Override
    public Superhero create(Superhero entity) {
        dao.save(entity);
        return getById(entity.getId());
    }

    @Override
    public Superhero update(Superhero entity) {
        Superhero superhero = getById(entity.getId());

        superhero.setName(entity.getName());
        superhero.setPseudonym(entity.getPseudonym());

        dao.save(superhero);
        return superhero;
    }

    @Override
    public void delete(Superhero entity) {
        dao.delete(entity);
    }
}
