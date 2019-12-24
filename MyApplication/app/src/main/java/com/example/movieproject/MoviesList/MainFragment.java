package com.example.movieproject.MoviesList;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movieproject.Movie;
import com.example.movieproject.MovieAdapter;
import com.example.movieproject.R;
import com.example.movieproject.RecyclerTouchListener;

import java.util.List;


public class MainFragment extends Fragment implements MainContract.View {


    private OnFragmentInteractionListerner mListener;

    private RecyclerView recyclerView;
    private MovieAdapter mAdapter;
    private MainContract.Presenter mPresenter;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenter(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        loadMovies();
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                mListener.onMovieSelected(mPresenter.getMovieID(position));
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        return view;
    }

    public void loadMovies(){
        mPresenter.onLoad();
    }

    @Override
    public void setMovies (List<Movie> movieList){
        mAdapter = new MovieAdapter(getContext(),movieList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListerner) {
            mListener = (OnFragmentInteractionListerner) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public MovieAdapter getmAdapter() {
        return mAdapter;
    }
}
