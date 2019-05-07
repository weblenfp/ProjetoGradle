package com.udacity.gradle.builditbigger.api;

import android.content.res.Resources;

import java.io.IOException;

import static com.udacity.gradle.builditbigger.api.APIConnector.getJokeFromApi;

public class JokesAsyncTask extends android.os.AsyncTask<Void, Void, String> {
    protected String doInBackground(Void... voids) {
        String ERROR_MESSAGE = Resources.getSystem().getString(android.R.string.httpErrorBadUrl);
        try {
            return getJokeFromApi();
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR_MESSAGE;
        }
    }
}
