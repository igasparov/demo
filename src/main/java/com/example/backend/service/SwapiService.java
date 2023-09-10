package com.example.backend.service;

import com.example.backend.model.PlanetPageSwapi;
import com.example.backend.model.PlanetSwapi;
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


    public String parseJson() {

        return (getPageFromSwapi(SWAPI + "/planets")).toString();

//        try {
//            return objectMapper.readValue(content, PlanetPageSwapi.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
    }

//    public boolean planetUpdate() {
//        return update("/planets", Page.class);
//    }

//    public <T extends Page> boolean update(String entity, Class<T> elementClass) {
//        T page = getPageFromSwapi(SWAPI + entity, elementClass);
////        planets.addAll(page.results());
//        while (page.next() != null) {
//            page =getPageFromSwapi(page.next(), elementClass);
////            planets.addAll(page.results());
//        }
//        return true;
//    }

    private PlanetPageSwapi getPageFromSwapi(String uri) {
        return webClient
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(PlanetPageSwapi.class)
                .block();
    }

    public List<PlanetSwapi> getPlanets() {
        return planets;
    }

    public PlanetSwapi getPlanet(String id) {
        return planetClient.findOne(id);
    }
}
