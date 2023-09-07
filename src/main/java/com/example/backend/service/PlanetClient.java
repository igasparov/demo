package com.example.backend.service;

import com.example.backend.model.PlanetPageSwapi;
import com.example.backend.model.PlanetSwapi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface PlanetClient {

    @GetExchange("/planets")
    PlanetPageSwapi findAll();


    @GetExchange("/planets/{id}")
    PlanetSwapi findOne(@PathVariable String id);

}

