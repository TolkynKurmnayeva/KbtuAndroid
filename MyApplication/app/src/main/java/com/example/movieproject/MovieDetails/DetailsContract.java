package com.example.movieproject.MovieDetails;

import android.content.Intent;

import com.example.movieproject.Movie;

import java.util.List;

public interface DetailsContract {
    interface View {
        void setContent(Movie movie);
    }

    interface Presenter {
        void onLoad(int position);
        Intent shareMovie(int position);
    }

    interface Repository {
        Movie  getMovie(int position);
    }
}
