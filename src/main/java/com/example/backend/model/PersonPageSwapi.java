package com.example.backend.model;

import java.util.ArrayList;
import java.util.List;

public record PersonPageSwapi (String next, String previous, ArrayList<String> results) {

}
