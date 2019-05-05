package com.udacity.gradle.builditbigger.utils;

import android.content.Context;

public class SourcePrefs {
    public static final int     JAVA_LIBRARY_SOURCE    = 1;
    public static final int     ANDROID_LIBRARY_SOURCE = 2;
    public static final int     GCE_SOURCE             = 3;
    private static final String ERROR_MESSAGE          = "Wrong input type";
    private static final String ARG_JOKE_FETCH_TYPE    = "joke_type";

    public static int getJokeFetchType(Context context) {
        return new Preferences(context).getInt(ARG_JOKE_FETCH_TYPE, JAVA_LIBRARY_SOURCE);
    }

    public static void saveJokeFetchType(Context context, int type) {
        if(type!= JAVA_LIBRARY_SOURCE &&
                type != ANDROID_LIBRARY_SOURCE &&
                type != GCE_SOURCE) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        new Preferences(context).saveInt(ARG_JOKE_FETCH_TYPE, type);
    }
}
