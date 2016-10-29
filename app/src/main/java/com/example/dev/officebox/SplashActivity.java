package com.example.dev.officebox;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.dev.officebox.helpers.Session;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        int SPLASH_TIME_OUT = 1000;
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Class app = LoginActivity.class;
                if (Session.has("user", getApplicationContext())) {
                    app = TagActivity.class;
                }
                Intent i = new Intent(SplashActivity.this, app);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
