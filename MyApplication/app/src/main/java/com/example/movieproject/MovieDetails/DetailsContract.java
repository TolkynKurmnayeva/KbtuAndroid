package com.example.movieproject.MovieDetails;

import android.content.Intent;

import com.example.movieproject.Movie;

import java.util.List;

public interface DetailsContract {
    interface View {
        void setContent(Movie movie);
    }

    interface Presenter {
        void onLoad(int movieID);
        void sendResponse(Movie movie);
        Intent shareMovie();
    }

    interface Repository {
        void  getMovie(int position);
    }
}
