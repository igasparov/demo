package com.example.backend.service;

import com.example.backend.model.PageSwapi;
import com.example.backend.model.PlanetSwapi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface PlanetClient {

    @GetExchange("/planets")
    PageSwapi findAll();


    @GetExchange("/planets/{id}")
    PlanetSwapi findOne(@PathVariable String id);
}

