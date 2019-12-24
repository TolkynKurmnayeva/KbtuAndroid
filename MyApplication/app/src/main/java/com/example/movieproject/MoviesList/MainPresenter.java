package com.example.movieproject.MoviesList;

import android.content.Context;

import com.example.movieproject.Movie;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private MainContract.Repository mRepository;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        this.mRepository = new MainRepository(this);
    }

    @Override
    public void onLoad (){
        mRepository.loadMovies();
    }
    @Override
    public void sendResponse(List<Movie> movieList){
        mView.setMovies(movieList);
    }
    @Override
    public int getMovieID (int position){
        return mRepository.getMovieID(position);
    }

}
