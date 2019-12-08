package com.example.movieproject;

public class Movie {
    private String title, genre, year, description;
    public int poster;

    public Movie() {
    }

    public Movie(String title, String genre, String year, int poster,String description) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.poster = poster;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPoster() {
        return poster;
    }
}
