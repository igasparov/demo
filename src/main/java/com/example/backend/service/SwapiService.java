package com.example.backend.service;

import com.example.backend.model.PlanetPageSwapi;
import com.example.backend.model.PlanetSwapi;
import com.fasterxml.jackson.core.JsonProcessingException;
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


    public PlanetPageSwapi parseJson() {

        String content = String.valueOf(getPageFromSwapi(SWAPI + "/planets"));
        System.out.println(content);
        try {
            return objectMapper.readValue(content, PlanetPageSwapi.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
//        return content;
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

    private String getPageFromSwapi(String uri) {
        return webClient
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public List<PlanetSwapi> getPlanets() {
        return planets;
    }

    public PlanetSwapi getPlanet(String id) {
        return planetClient.findOne(id);
    }
}
