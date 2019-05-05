package com.udacity.gradle.builditbigger;

import android.test.suitebuilder.annotation.LargeTest;
import android.text.TextUtils;

import com.udacity.gradle.builditbigger.api.AsyncTask;
import com.udacity.gradle.builditbigger.api.AsyncTaskRobust;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertFalse;

@RunWith(JUnit4.class)
@LargeTest
public class InstrumentedTest {

    private static final String ERROR_MESSAGE = "Error. Try again";

    public InstrumentedTest(){
    }

    @Test
    public void testDoInBackground() throws Exception {
        String joke = new AsyncTask().execute().get();
        Thread.sleep(10000);
        assertFalse("Error: Fetched Joke = " + joke, TextUtils.equals(joke,ERROR_MESSAGE));
    }

    @Test
    public void testDoInBackgroundRobust() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);
        String               joke   = new AsyncTaskRobust(signal).execute().get();
        signal.await();
        assertFalse("Error: Fetched Joke = " + joke, TextUtils.equals(joke, ERROR_MESSAGE));
    }
}