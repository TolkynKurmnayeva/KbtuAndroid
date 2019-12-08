package com.example.movieproject.MoviesList;

import com.example.movieproject.Movie;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private MainContract.Repository mRepository;

    List<Movie> movieList;
    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        this.mRepository = new MainRepository();
    }

    @Override
    public void onLoad (){
        movieList = mRepository.loadMovies();
        mView.setMovies(movieList);
    }

    @Override
    public void onClick (int position){
        Movie movie = movieList.get(position);

    }

}
