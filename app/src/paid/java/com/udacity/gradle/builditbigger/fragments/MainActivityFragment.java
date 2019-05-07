package com.udacity.gradle.builditbigger.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.api.JokesAsyncTask;

import java.util.concurrent.ExecutionException;

import dev.weblen.jokesandroidlibrary.JokesActivity;

public class MainActivityFragment extends Fragment {
    private static final int ACTIVITY_REQUEST_CODE = 123;

    public static MainActivityFragment newInstance() {
        Bundle               args     = new Bundle();
        MainActivityFragment fragment = new MainActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);
        rootView.findViewById(R.id.button_load_joke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JokesAsyncTask task = new JokesAsyncTask();
                try {
                    String GCEjoke = task.execute().get();

                    Intent intentStartJokeLibActivity = new Intent(MainActivityFragment.this.getActivity(), JokesActivity.class);
                    intentStartJokeLibActivity.putExtra(JokesActivity.ARG_JOKE_RECEIVED, GCEjoke);
                    MainActivityFragment.this.getActivity().startActivityForResult(intentStartJokeLibActivity, ACTIVITY_REQUEST_CODE);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
        return rootView;
    }
}
