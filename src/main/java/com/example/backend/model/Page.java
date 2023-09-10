package com.example.backend.model;

import java.util.ArrayList;

public interface Page {
    String next();
    String previous();
    ArrayList<SwapiEntity> results();
}
