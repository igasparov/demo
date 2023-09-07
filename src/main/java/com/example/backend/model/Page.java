package com.example.backend.model;

import java.util.Collection;

public interface Page {
    String next();
    Collection<? extends PlanetSwapi> results();
}
