package com.example.movieproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDBApi {
    @GET("/3/list/{id}")
    Call<MovieList> getMovieListWithID(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("/3/movie/{movie_id}")
    Call<Movie> getMovieWithID(@Path("movie_id") int movie_id, @Query("api_key") String apiKey);

}
