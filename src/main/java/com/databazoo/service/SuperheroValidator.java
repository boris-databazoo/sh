package com.databazoo.service;

import com.databazoo.bo.Superhero;

public interface SuperheroValidator {
    void checkCreate(Superhero entity);

    void checkUpdate(Superhero entity);
}
