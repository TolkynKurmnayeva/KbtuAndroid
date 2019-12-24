package com.example.movieproject.MovieDetails;

import androidx.annotation.NonNull;

import com.example.movieproject.Movie;
import com.example.movieproject.MovieList;
import com.example.movieproject.NetworkService;
import com.example.movieproject.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsRepository implements DetailsContract.Repository {
    private DetailsContract.Presenter mPresenter;
    public DetailsRepository(DetailsContract.Presenter mPresenter){
        this.mPresenter=mPresenter;
    }
    @Override
    public void getMovie (int movieID){
        NetworkService.getInstance()
                .getApi()
                .getMovieWithID(movieID,NetworkService.getApiKey())
                .enqueue(new Callback<Movie>() {
                    @Override
                    public void onResponse(@NonNull Call<Movie> call,@NonNull Response<Movie> response) {
                        Movie movie = response.body();
                        mPresenter.sendResponse(movie);
                    }
                    @Override
                    public void onFailure(@NonNull Call<Movie> call,@NonNull Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
