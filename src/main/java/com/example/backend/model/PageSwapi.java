package com.example.backend.model;

import java.util.ArrayList;

public record Page(
        Integer count,
        String next,
        String previous,
        ArrayList<Planet> results
) {
}
