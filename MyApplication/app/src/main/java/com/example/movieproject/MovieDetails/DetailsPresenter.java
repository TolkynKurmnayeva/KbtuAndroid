package com.example.movieproject.MovieDetails;

import android.content.Intent;

import com.example.movieproject.Movie;

public class DetailsPresenter implements DetailsContract.Presenter {
    private DetailsContract.View mView;
    private DetailsContract.Repository mRepository;

    Movie movie;
    public DetailsPresenter(DetailsContract.View mView) {
        this.mView = mView;
        this.mRepository = new DetailsRepository();
    }

    @Override
    public void onLoad (int position){
        movie = mRepository.getMovie(position);
        mView.setContent(movie);
    }

    @Override
    public Intent shareMovie(int position){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String movieText = "Title: " + movie.getTitle() + "\nGenre: " + movie.getGenre() + "\nYear: " + movie.getYear() + "\nDescription: " + movie.getDescription();
        sendIntent.putExtra(Intent.EXTRA_TEXT, movieText);
        sendIntent.setType("text/plain");
        return sendIntent;
    }

//    @Override
//    public void onClick (int position){
//        Movie movie = movieList.get(position);
//        Intent intent = new Intent((Activity)mView, DetailsActivity.class);
//        intent.putExtra("movie_title", movie.getTitle());
//        intent.putExtra("movie_genre", movie.getGenre());
//        intent.putExtra("movie_year", movie.getYear());
//        intent.putExtra("movie_poster", movie.poster);
//        intent.putExtra("movie_description", movie.getDescription());
//        ((Activity)(mView)).startActivity(intent);
//    }

}
