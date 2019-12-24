package com.example.movieproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private List<Movie> moviesList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView poster;
        public LinearLayout movieCard;
        public ImageButton listShareButton;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            poster = (ImageView) view.findViewById(R.id.poster);
            movieCard = (LinearLayout) view.findViewById(R.id.movieCard);
        }
    }
    public MovieAdapter(){
        super();
    }

    public MovieAdapter(Context mContext, List<Movie> moviesList) {
        this.mContext=mContext;
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
//        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        Glide.with(mContext).load("https://image.tmdb.org/t/p/w500/"+movie.getPosterPath()).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}
