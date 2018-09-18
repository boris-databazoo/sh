package com.databazoo.service;

import com.databazoo.bo.Superhero;
import com.databazoo.dao.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
