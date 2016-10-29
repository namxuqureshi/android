package com.example.dev.officebox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dev.officebox.helpers.ApiURI;
import com.example.dev.officebox.helpers.Http;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText email = null;
    EditText password = null;
    EditText name = null;
    EditText phone = null;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        email = (EditText) findViewById(R.id.input_reg_email);
        password = (EditText) findViewById(R.id.input_reg_password);
        phone = (EditText) findViewById(R.id.input_phone);
        name = (EditText) findViewById(R.id.input_name);
    }

    public void goBack(final View view) {
        super.onBackPressed();
    }
    public void register(View view){

        JSONObject request_data = new JSONObject();
        try {
            request_data.put("email",email.getText().toString());
            request_data.put("password",password.getText().toString());
            request_data.put("phone",phone.getText().toString());
            request_data.put("name",name.getText().toString());
        }catch (JSONException e){
            e.printStackTrace();
        }
        Http.post(ApiURI.register, request_data.toString(), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                RegisterActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RegisterActivity.this, "Internet not Available", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                // ... check for failure using `isSuccessful` before proceeding
                // Read data on the worker thread
                final String responseData = response.body().string();
                try {
                    JSONObject jObj = new JSONObject(responseData);
                    final JSONObject a = jObj.getJSONObject("error");
                    if(!a.getBoolean("if")){
                        RegisterActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this, "User Created", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }else{
                        RegisterActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Toast.makeText(RegisterActivity.this, a.getString("status"), Toast.LENGTH_LONG).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (JSONException e) {
                    RegisterActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegisterActivity.this, "Somethings Missing", Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }
        });
    }
}