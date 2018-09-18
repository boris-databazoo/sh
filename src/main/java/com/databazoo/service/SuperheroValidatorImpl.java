package com.databazoo.service;

import com.databazoo.bo.Superhero;
import org.springframework.stereotype.Service;

@Service
public class SuperheroValidatorImpl implements SuperheroValidator {
    @Override
    public void checkCreate(Superhero entity) {
        if (entity.getName() == null || entity.getId() != null || entity.getPublisher() == null) {
            throw new IllegalArgumentException("Validation failed");
        }
    }

    @Override
    public void checkUpdate(Superhero entity) {

    }
}
