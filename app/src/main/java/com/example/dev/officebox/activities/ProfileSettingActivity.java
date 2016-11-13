package com.example.dev.officebox.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.dev.officebox.R;

public class ProfileSettingActivity extends NavigationActivity implements OnClickListener {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return super.onNavigationItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_setting);
        super.nav();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_cancel:
                finish();
                break;

            case R.id.profile_go:
                break;
            case R.id.profile_img:
                break;


        }
    }
}
