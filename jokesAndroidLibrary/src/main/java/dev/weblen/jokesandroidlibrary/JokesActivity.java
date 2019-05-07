package dev.weblen.jokesandroidlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {
    public static final String ARG_JOKE_RECEIVED = "joke_received";

    private String mJoke;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jokes);
        TextView jokeTV = findViewById(R.id.joke_tv);

        mJoke = getIntent().getExtras().getString(ARG_JOKE_RECEIVED, null);
        jokeTV.setText(mJoke);
    }
}
