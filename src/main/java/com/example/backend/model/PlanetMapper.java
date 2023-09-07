package com.example.backend.model;

public class PlanetMapper {
    public static Planet getPlanet(PlanetSwapi planet) {
        return new Planet(
                planet.name(),
                planet.rotation_period(),
                planet.orbital_period(),
                planet.diameter(),
                planet.climate(),
                planet.gravity(),
                planet.terrain(),
                planet.surface_water(),
                planet.population()
        );
    }
}
