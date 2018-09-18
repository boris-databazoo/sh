package com.databazoo.dao;

import com.databazoo.bo.Superhero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SuperheroRepository extends CrudRepository<Superhero, UUID> {
}
