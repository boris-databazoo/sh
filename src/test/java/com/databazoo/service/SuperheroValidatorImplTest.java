package com.databazoo.service;

import com.databazoo.bo.Publisher;
import com.databazoo.bo.Superhero;
import org.junit.Test;

import java.util.UUID;

public class SuperheroValidatorImplTest {
    private SuperheroValidator validator = new SuperheroValidatorImpl();

    @Test
    public void checkCreateValid() {
        Superhero entity = new Superhero();
        entity.setName("Tester");
        entity.setPublisher(new Publisher());
        validator.checkCreate(entity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCreateInvalid() {
        Superhero entity = new Superhero();
        validator.checkCreate(entity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCreateInvalid2() {
        Superhero entity = new Superhero();
        entity.setId(UUID.randomUUID());
        validator.checkCreate(entity);
    }

    @Test
    public void checkUpdate() {
        Superhero entity = new Superhero();
        validator.checkUpdate(entity);
    }
}