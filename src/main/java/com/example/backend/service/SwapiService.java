package com.example.backend.service;

import com.example.backend.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class SwapiService {
    public static final String SWAPI= "https://swapi.dev/api";

    private final List<PlanetSwapi> planets = new ArrayList<>();
    private final WebClient webClient = WebClient.builder().build();
    private final PlanetClient planetClient;

    private final ObjectMapper objectMapper;

    public SwapiService(PlanetClient planetClient, ObjectMapper objectMapper) {
        this.planetClient = planetClient;
        this.objectMapper = objectMapper;
    }


//    public String parseJson() {
//        String s = getPageFromSwapi(SWAPI + "/planets", PlanetPageSwapi.class).results().get(1);
//        System.out.println(
//                s
//        );
//        return s;
//    }

    public boolean planetUpdate() {
        return update("/planets", PlanetPageSwapi.class);
    }

    public <T extends Page> boolean update(String entity, Class<T> elementClass) {
        T page = getPageFromSwapi(SWAPI + entity, elementClass);
        planets.addAll(page.results());
        while (page.next() != null) {
            page =getPageFromSwapi(page.next(), elementClass);
            planets.addAll(page.results());
        }
        return true;
    }

    private <T> T getPageFromSwapi(String uri, Class<T> elementClass) {
        return webClient
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(elementClass)
                .block();
    }

    public List<PlanetSwapi> getPlanets() {
        return planets;
    }

    public PlanetSwapi getPlanet(String id) {
        return planetClient.findOne(id);
    }
}
