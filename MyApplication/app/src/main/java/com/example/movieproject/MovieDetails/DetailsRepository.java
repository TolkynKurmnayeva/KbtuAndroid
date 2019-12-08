package com.example.movieproject.MovieDetails;

import com.example.movieproject.Movie;
import com.example.movieproject.R;

import java.util.ArrayList;
import java.util.List;

public class DetailsRepository implements DetailsContract.Repository {
    @Override
    public Movie getMovie (int position){
        List<Movie> movieList = new ArrayList<>();
        int[] covers = new int[]{
                R.drawable.m1,
                R.drawable.m2,
                R.drawable.m3,
                R.drawable.m4,
                R.drawable.m5,
                R.drawable.m6,
                R.drawable.m7,
                R.drawable.m8,
                R.drawable.m9,
                R.drawable.m10,
                R.drawable.m11,
                R.drawable.m12,
                R.drawable.m13,
                R.drawable.m14,
                R.drawable.m15,
                R.drawable.m16,
                R.drawable.m17,
                R.drawable.m18,
                R.drawable.m19,
                R.drawable.m20,
        };
        String desc = "Set within a year after the events of Batman Begins (2005), Batman, Lieutenant James Gordon, and new District Attorney Harvey Dent successfully begin to round up the criminals that plague Gotham City, until a mysterious and sadistic criminal mastermind known only as \"The Joker\" appears in Gotham, creating a new wave of chaos. Batman's struggle against The Joker becomes deeply personal, forcing him to \"confront everything he believes\" and improve his technology to stop him. A love triangle develops between Bruce Wayne, Dent, and Rachel Dawes. Written by Leon Lombardi\n" +
                "\n Director: Christopher Nolan\n" +
                "Writers: Jonathan Nolan (screenplay), Christopher Nolan (screenplay) | 3 more credits »\n" +
                "Stars: Christian Bale, Heath Ledger, Aaron Eckhart | See full cast & crew »\n";
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015", covers[1],desc);

        for (int i = 0; i<100; i++){
            if (i%4==0)
                movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2014", covers[i%20], desc);
            else if (i%4==1)
                movie = new Movie("Inside Out", "Animation, Kids & Family", "2015",covers[i%20], desc);
            else if (i%4==2)
                movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2004", covers[i%20], desc);
            else
                movie = new Movie("Shaun the Sheep", "Animation", "1996", covers[i%20], desc);
            movieList.add(movie);
        }
        return movieList.get(position);
    }
}
