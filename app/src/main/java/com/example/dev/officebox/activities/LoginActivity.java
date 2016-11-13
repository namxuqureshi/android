package com.example.dev.officebox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dev.officebox.R;
import com.example.dev.officebox.helpers.ApiURI;
import com.example.dev.officebox.helpers.Http;
import com.example.dev.officebox.helpers.Session;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class

LoginActivity extends AppCompatActivity {

    private static final String TAG = "fb_login";
    CallbackManager mCallbackManager;
    final List<String> permissions = Arrays.asList("email", "user_birthday", "user_friends");
    EditText email = null;
    EditText password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
//        try {
//            Log.v("as", "asd");
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    "com.example.dev.officebox",
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.v("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
//            Log.v("KeyHash:", e.toString());
//        }
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.input_email);
        password = (EditText) findViewById(R.id.input_password);
        mCallbackManager = CallbackManager.Factory.create();

        final LoginButton loginButton = (LoginButton) findViewById(R.id.login_button1);
        loginButton.setReadPermissions(permissions);
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
////                            Log.v("object", object.toString());
///*                               Session.putPref("email",object.getString("email"),getApplicationContext());
//                            Session.putPref("name",object.getString("name"),getApplicationContext());
//*/
                                // Server Request To verify
                                Http.post(ApiURI.facbook_login, object.toString(), new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                        LoginActivity.this.runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(LoginActivity.this, "Internet Not Available", Toast.LENGTH_LONG).show();
                                            }
                                        });
                                    }

                                    @Override
                                    public void onResponse(Call call, final Response response) throws IOException {

                                        // ... check for failure using `isSuccessful` before proceeding
                                        // Read data on the worker thread
                                        final String responseData = response.body().string();
                                        Log.v("abc", responseData);
                                        Session.putPref("user", responseData, getApplicationContext());
                                        // Run view-related code back on the main thread
                                        LoginActivity.this.runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Intent intent = new Intent(LoginActivity.this, TagActivity.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                                finish();
                                            }
                                        });
                                    }
                                });
                            }
                        }
                );
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();

            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "User: Cancel ", Toast.LENGTH_LONG).show();
                Log.d(TAG, "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(LoginActivity.this, "User: Error ", Toast.LENGTH_LONG).show();
                Log.e(TAG, "facebook:onError", error);
                // ...
            }
        });

    }

    public void login(View view) {

        JSONObject request_data = new JSONObject();
        try {
            request_data.put("email", email.getText().toString());
            request_data.put("password", password.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Http.post(ApiURI.login, request_data.toString(), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LoginActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginActivity.this, "Internet Not Available", Toast.LENGTH_LONG).show();
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
                    JSONObject a = jObj.getJSONObject("login");
                    if (a.getBoolean("if")) {
                        JSONObject user = jObj.getJSONObject("user");
                        Session.putPref("user", user.toString(), getApplicationContext());
                        // Run view-related code back on the main thread
                        LoginActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(LoginActivity.this, TagActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        });
                    } else {
                        LoginActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginActivity.this, "Incorrect Credential", Toast.LENGTH_LONG).show();
                            }

                        });
                    }
                } catch (JSONException e) {
                    Log.v("login", e.toString());
                }

            }
        });
    }

    public void getSignUp(View view) {

        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);

    }

    public void temp(View view) {

        Intent i = new Intent(this, TagActivity.class);
        startActivity(i);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode,
                resultCode, data);
    }
}
