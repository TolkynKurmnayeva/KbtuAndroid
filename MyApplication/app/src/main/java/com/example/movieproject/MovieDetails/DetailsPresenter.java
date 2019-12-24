package com.example.movieproject.MovieDetails;

import android.content.Intent;

import com.example.movieproject.Movie;

public class DetailsPresenter implements DetailsContract.Presenter {
    private DetailsContract.View mView;
    private DetailsContract.Repository mRepository;

    private Movie movie;
    public DetailsPresenter(DetailsContract.View mView) {
        this.mView = mView;
        this.mRepository = new DetailsRepository(this);
    }

    @Override
    public void onLoad (int movieID){
        mRepository.getMovie(movieID);
    }

    @Override
    public void sendResponse(Movie movie){
        this.movie = movie;
        mView.setContent(movie);
    }

    @Override
    public Intent shareMovie(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String movieText = "Title: " + movie.getTitle() + "\nGenre: " + movie.getGenre() + "\nYear: " + movie.getYear() + "\nDescription: " + movie.getDescription();
        sendIntent.putExtra(Intent.EXTRA_TEXT, movieText);
        sendIntent.setType("text/plain");
        return sendIntent;
    }

}
