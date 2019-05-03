package com.udacity.gradle.builditbigger.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.utils.SourcePrefs;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem menuItemJavaLibrary = menu.findItem(R.id.action_java_library);
        MenuItem menuItemAndroidLibrary = menu.findItem(R.id.action_android_library);
        MenuItem menuItemGoogleAppEngine = menu.findItem(R.id.action_google_app_engine);

        menuItemJavaLibrary.setChecked(false);
        menuItemAndroidLibrary.setChecked(false);
        menuItemGoogleAppEngine.setChecked(false);

        switch (SourcePrefs.getJokeFetchType(this)) {
            case SourcePrefs.JAVA_LIBRARY_SOURCE:
                menuItemJavaLibrary.setChecked(true);
                break;
            case SourcePrefs.ANDROID_LIBRARY_SOURCE:
                menuItemAndroidLibrary.setChecked(true);
                break;
            case SourcePrefs.GAE_SOURCE:
                menuItemGoogleAppEngine.setChecked(true);
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        item.setChecked(true);
        switch (itemId) {
            case R.id.action_java_library:
                SourcePrefs.saveJokeFetchType(this, SourcePrefs.JAVA_LIBRARY_SOURCE);
                break;
            case R.id.action_android_library:
                SourcePrefs.saveJokeFetchType(this, SourcePrefs.ANDROID_LIBRARY_SOURCE);
                break;
            case R.id.action_google_app_engine:
                SourcePrefs.saveJokeFetchType(this, SourcePrefs.GAE_SOURCE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}