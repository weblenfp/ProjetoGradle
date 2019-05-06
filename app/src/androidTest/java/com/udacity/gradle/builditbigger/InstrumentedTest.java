package com.udacity.gradle.builditbigger;

import android.text.TextUtils;

import com.udacity.gradle.builditbigger.api.JokesAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertFalse;

@RunWith(JUnit4.class)
public class InstrumentedTest {

    private static final String ERROR_MESSAGE = "Error. Try again";

    public InstrumentedTest() {
    }

    @Test
    public void testFetchJokesFromLibrary() throws Exception {
        String joke = new JokesAsyncTask().execute().get();
        assertFalse("Error: Fetched Joke = " + joke, TextUtils.equals(joke, ERROR_MESSAGE));
    }
}