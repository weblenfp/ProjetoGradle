package dev.weblen.jokesandroidlibrary;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {
    public static final String ARG_JOKE_RECEIVED = "joke_received";
    public static final String ARG_JOKE = "joke";

    private String mJoke;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jokes);
        TextView jokeTV = findViewById(R.id.joke_tv);

        mJoke = getIntent().getExtras().getString(ARG_JOKE_RECEIVED, null);
        jokeTV.setText(mJoke);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.android_library_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_close) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent result = new Intent();
        result.putExtra(ARG_JOKE, mJoke);
        setResult(Activity.RESULT_OK, result);
        super.onBackPressed();
    }
}
