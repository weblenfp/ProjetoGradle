package com.udacity.gradle.builditbigger;

//import android.support.test.runner.AndroidJUnit4;
//import android.text.TextUtils;
//
//import java.util.concurrent.CountDownLatch;
//
//@RunWith(AndroidJUnit4.class)
//@LargeTest
//public class InstrumentedTestRobust {
//    private static final String ERROR_MESSAGE = "Error. Try again";
//
//    @Test
//    public void testDoInBackground() throws Exception {
//        final CountDownLatch signal = new CountDownLatch(1);
//        String               joke   = new RobustGetJokeAsyncTask(signal).execute().get();
//        signal.await();
//        assertFalse("Error: Fetched Joke = " + joke, TextUtils.equals(joke,ERROR_MESSAGE));
//    }
//}