package com.example.backend.controller;

import com.example.backend.model.PlanetPageSwapi;
import com.example.backend.service.SwapiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final SwapiService swapiService;

    public MainController(SwapiService swapiService) {
        this.swapiService = swapiService;
    }

    @GetMapping
    public String index() {
        return "Main page";
    }

    @GetMapping("/planets")
    public String planets() {
        return swapiService.getPlanets().toString();
    }

    @GetMapping("/planets/update")
    public String updatePlanets() {
        swapiService.planetUpdate();
        return swapiService.getPlanets().toString();
//        return "planets";
    }
}
