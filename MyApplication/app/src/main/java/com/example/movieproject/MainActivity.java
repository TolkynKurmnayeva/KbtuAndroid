package com.example.movieproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.example.movieproject.MovieDetails.DetailsFragment;
import com.example.movieproject.MoviesList.MainFragment;
import com.example.movieproject.MoviesList.OnFragmentInteractionListerner;


public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListerner {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        MainFragment mainFragment = new MainFragment();
        ft.replace(R.id.fragment_container, mainFragment);
        ft.commit();
    }

    @Override
    public void onMovieSelected(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DetailsFragment detailsFragment = DetailsFragment.newInstance(position);
        ft.replace(R.id.fragment_container, detailsFragment).addToBackStack( "tag" ).commit();
    }
}
