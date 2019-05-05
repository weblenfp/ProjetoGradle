package com.udacity.gradle.builditbigger.api;

import android.os.AsyncTask;

import java.util.concurrent.CountDownLatch;

import static com.udacity.gradle.builditbigger.api.GCPConnector.getJokeFromApi;

public class AsyncTaskRobust extends AsyncTask<Void, Void, String> {
    private static final String         ERROR_MESSAGE = "Error. Try again";
    private              CountDownLatch countDownLatch;

    public AsyncTaskRobust(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    protected String doInBackground(Void... voids) {
        try {
            return getJokeFromApi();
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR_MESSAGE;
        }
        finally {
            countDownLatch.countDown();
        }
    }
}