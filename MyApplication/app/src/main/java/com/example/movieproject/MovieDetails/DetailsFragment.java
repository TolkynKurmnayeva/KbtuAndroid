package com.example.movieproject.MovieDetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieproject.Movie;
import com.example.movieproject.R;


public class DetailsFragment extends Fragment implements DetailsContract.View {

    private TextView title, descriptionView;
    private ImageView moviePosterView;
    private ImageButton shareButton;
    private DetailsPresenter mPresenter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String MOVIE_ID = "param1";

    // TODO: Rename and change types of parameters
    private int movieID;

//    private OnFragmentInteractionListener mListener;

    public DetailsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(int position) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt(MOVIE_ID, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movieID = getArguments().getInt(MOVIE_ID,0);
        }
        mPresenter = new DetailsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        title = view.findViewById(R.id.movie_title);
        descriptionView = view.findViewById(R.id.description);
        moviePosterView = view.findViewById(R.id.poster);
        shareButton = view.findViewById(R.id.shareButton);
        mPresenter.onLoad(movieID);



        return view;
    }

    public void setContent (Movie movie){
        String text = movie.getTitle() + " (" + movie.getYear() + ")";
        title.setText(text);
        descriptionView.setText(movie.getDescription());
        Glide.with(getContext()).load("https://image.tmdb.org/t/p/w500/"+movie.getPosterPath()).into(moviePosterView);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = mPresenter.shareMovie();
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }

}
