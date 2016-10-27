package com.example.dev.officebox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

    }


    public void getSignUp(final View view) {

        Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i);
//        finish();

    }

    public void temp(final View view) {

        Intent i = new Intent(getApplicationContext(), TagActivity.class);
        startActivity(i);
        finish();

    }


    public void FB(final View view) {
        Toast.makeText(this, "HOLA FB!", Toast.LENGTH_SHORT).show();
    }

}
