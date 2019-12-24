package com.example.movieproject;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieList {
    @JsonProperty("items")
    public List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}
