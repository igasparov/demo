package com.example.backend.model;

import java.util.ArrayList;
import java.util.Objects;

public record PageSwapi(Integer count, String next, String previous, ArrayList<PlanetSwapi> results) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PageSwapi) obj;
        return Objects.equals(this.count, that.count) &&
                Objects.equals(this.next, that.next) &&
                Objects.equals(this.previous, that.previous) &&
                Objects.equals(this.results, that.results);
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
