package com.example.movieproject.MoviesList;

import android.content.Context;

import com.example.movieproject.Movie;

import java.util.List;

public interface MainContract {
    interface View {
        void setMovies(List<Movie> movieList);
    }

    interface Presenter {
        void onLoad();
        void sendResponse(List<Movie> movieList);
        int getMovieID(int position);
    }

    interface Repository {
        void  loadMovies();
        int getMovieID (int position);
    }
}
