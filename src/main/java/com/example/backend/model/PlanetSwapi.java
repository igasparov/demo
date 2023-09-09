package com.example.backend.model;


import java.util.ArrayList;


public record PlanetSwapi  (
        String name,
        String rotation_period,
        String orbital_period,
        String diameter,
        String climate,
        String gravity,
        String terrain,
        String surface_water,
        String population,
        ArrayList<String> residents,
        ArrayList<String> films,
//        String created,
//        String edited,
        String url
        ) implements SwapiEntity {

}
