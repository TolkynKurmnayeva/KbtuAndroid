package com.example.movieproject.MoviesList;

import com.example.movieproject.Movie;

import java.util.List;

public interface MainContract {
    interface View {
        void setMovies(List<Movie> movieList);
    }

    interface Presenter {
        void onLoad();
        void onClick(int position);
    }

    interface Repository {
        List<Movie>  loadMovies();
    }
}
