package com.example.backend.service;

import com.example.backend.model.PageSwapi;
import com.example.backend.model.PlanetSwapi;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class SwapiService {
    public static final String SWAPI= "https://swapi.dev/api";

    private final List<PlanetSwapi> planets = new ArrayList<>();
    private final WebClient webClient = WebClient.builder().baseUrl(SWAPI).build();
    private final PlanetClient planetClient;

    public SwapiService(PlanetClient planetClient) {
        this.planetClient = planetClient;
    }

    public void update() {
        PageSwapi page = planetClient.findAll();
        planets.addAll(page.results());
        while (page != null && page.next() != null) {
            int nextPage = Integer.parseInt(page.next().substring(getNextPage(page.next())));
            page = webClient
                    .get()
                    .uri(SWAPI + "/planets/?page={page}", nextPage)
                    .retrieve()
                    .bodyToMono(PageSwapi.class)
                    .block();
            if (page != null) {
                planets.addAll(page.results());
            }
        }
    }


    private int getNextPage(String next) {
        return next.lastIndexOf("page=") + 5;
    }

    public List<PlanetSwapi> getPlanets() {
        return planets;
    }

    public PlanetSwapi getPlanet(String id) {
        return planetClient.findOne(id);
    }
}
