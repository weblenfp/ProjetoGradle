package com.udacity.gradle.builditbigger.paid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.utils.SourcePrefs;
import com.udacity.gradle.builditbigger.api.AsyncTask;

import dev.weblen.jokesandroidlibrary.JokesActivity;
import dev.weblen.jokesjavalibrary.Jokes;

import java.util.concurrent.ExecutionException;

public class MainActivityFragment extends Fragment {
    private static final String ARG_JOKE_TEXT = "JOKE_TEXT";
    private static final int ACTIVITY_REQUEST_CODE = 123;

    public static MainActivityFragment newInstance() {
        Bundle args = new Bundle();
        MainActivityFragment fragment = new MainActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);
        ((TextView) rootView.findViewById(R.id.joke_tv)).setText(Jokes.getJoke());
        rootView.findViewById(R.id.button_load_joke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (SourcePrefs.getJokeFetchType(MainActivityFragment.this.getActivity())) {
                    case SourcePrefs.JAVA_LIBRARY_SOURCE:
                        ((TextView) MainActivityFragment.this.getActivity().findViewById(R.id.joke_tv)).setText(Jokes.getJoke());
                        break;
                    case SourcePrefs.ANDROID_LIBRARY_SOURCE:
                        Intent intentStartJokeLibActivity = new Intent(MainActivityFragment.this.getActivity(), JokesActivity.class);
                        intentStartJokeLibActivity.putExtra(JokesActivity.ARG_JOKE_RECEIVED, Jokes.getJoke());
                        MainActivityFragment.this.getActivity().startActivityForResult(intentStartJokeLibActivity, ACTIVITY_REQUEST_CODE);
                        break;
                    case SourcePrefs.GAE_SOURCE:
                        AsyncTask task = new AsyncTask();
                        try {
                            String GAEjoke = task.execute().get();
                            ((TextView) MainActivityFragment.this.getActivity().findViewById(R.id.joke_tv)).setText(GAEjoke);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        Activity activity = this.getActivity();

        if (savedInstanceState != null) {
            String currJoke = savedInstanceState.getString(ARG_JOKE_TEXT);
            ((TextView) activity.findViewById(R.id.joke_tv)).setText(currJoke);
        } else {
            ((TextView) activity.findViewById(R.id.joke_tv)).setText(Jokes.getJoke());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String currJoke = ((TextView) getActivity().findViewById(R.id.joke_tv)).getText().toString();
        outState.putString(ARG_JOKE_TEXT, currJoke);
    }
}