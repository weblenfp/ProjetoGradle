package com.udacity.gradle.builditbigger.api;

import java.io.IOException;

import static com.udacity.gradle.builditbigger.api.APIConnector.getJokeFromApi;

public class JokesAsyncTask extends android.os.AsyncTask<Void, Void, String> {
    private static final String ERROR_MESSAGE = "Error. Try again";

    protected String doInBackground(Void... voids) {
        try {
            return getJokeFromApi();
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR_MESSAGE;
        }
    }
}
