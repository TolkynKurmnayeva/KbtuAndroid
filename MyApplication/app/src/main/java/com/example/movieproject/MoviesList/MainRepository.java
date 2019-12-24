package com.example.movieproject.MoviesList;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.movieproject.Movie;
import com.example.movieproject.MovieList;
import com.example.movieproject.NetworkService;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.Callback;

public class MainRepository implements MainContract.Repository {
    private MainContract.Presenter mPresenter;
    final List<Movie> movieList = new ArrayList<>();

    public MainRepository(MainContract.Presenter mPresenter){
        this.mPresenter=mPresenter;
    }
    @Override
    public void loadMovies (){
        NetworkService.getInstance()
                        .getApi()
                        .getMovieListWithID(1,NetworkService.getApiKey())
                        .enqueue(new Callback<MovieList>() {
                            @Override
                            public void onResponse(@NonNull Call<MovieList> call, @NonNull retrofit2.Response<MovieList> response) {
                                List<Movie> tempMovieList = new ArrayList<>();
                                try {
                                     tempMovieList = response.body().getMovies();
                                }
                                catch (NullPointerException e){
                                    e.printStackTrace();
                                }
                                movieList.clear();
                                movieList.addAll(tempMovieList);
                                mPresenter.sendResponse(movieList);
                            }
                            @Override
                            public void onFailure(@NonNull Call<MovieList> call,@NonNull Throwable t) {
                                t.printStackTrace();
                            }
                        });
    }

    @Override
    public int getMovieID(int position){
        return movieList.get(position).getId();
    }
}
