package com.example.backend.repository;


import com.example.backend.model.Planet;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepo extends CrudRepository<Planet, Integer> {

}
