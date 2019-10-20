package com.example.movieproject;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView title, descriptionView;
    private ImageView moviePosterView;
    private ImageButton shareButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title = findViewById(R.id.movie_title);
        descriptionView = findViewById(R.id.description);
        moviePosterView = findViewById(R.id.poster);
        shareButton = findViewById(R.id.shareButton);
        final String movieTitle = getIntent().getStringExtra("movie_title");
        final String genre = getIntent().getStringExtra("movie_genre");
        final String year = getIntent().getStringExtra("movie_year");
        int poster = getIntent().getIntExtra("movie_poster", 0);
        final String description = getIntent().getStringExtra("movie_description");

        String text = movieTitle + " (" + year + ")";
        title.setText(text);
        descriptionView.setText(description);
        Glide.with(this).load(poster).into(moviePosterView);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                String movieText = "Title: " + movieTitle + "\nGenre: " + genre + "\nYear: " + year + "\nDescription: " + description;
                sendIntent.putExtra(Intent.EXTRA_TEXT, movieText);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

    }

}
