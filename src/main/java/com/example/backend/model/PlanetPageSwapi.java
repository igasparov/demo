package com.example.backend.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.ArrayList;
import java.util.Objects;

public record PlanetPageSwapi(
        Integer count,
        String next,
        String previous,
        ArrayList<JsonNode> results
) implements SwapiEntity {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PlanetPageSwapi) obj;
        return Objects.equals(this.count, that.count) &&
                Objects.equals(this.next, that.next) &&
                Objects.equals(this.previous, that.previous) &&
                Objects.equals(this.results, that.results);
    }

    @Override
    public int hashCode() {
        return 0;
    }


    @Override
    public String toString() {
        return "PageSwapi[" +
                "count=" + count + ", " +
                "next=" + next + ", " +
                "previous=" + previous + ", " +
                "results=" + results + ']';
    }

}
