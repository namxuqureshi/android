package com.example.dev.officebox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected String[] web = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_navigation);

//        nav();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent n = new Intent(this, TagActivity.class);
            startActivity(n);
            finish();
        } else if (id == R.id.nav_profile) {
            Intent n = new Intent(this, ProfileTagActivity.class);
            startActivity(n);
        } else if (id == R.id.nav_search) {
            //TODO
        } else if (id == R.id.nav_scan) {
            //TODO
        } else if (id == R.id.nav_message) {
            Intent n = new Intent(this, NewMessageActivity.class);
            startActivity(n);

        } else if (id == R.id.nav_friend_list) {
            Intent n = new Intent(this, FriendListActivity.class);
            startActivity(n);

        } else if (id == R.id.nav_groups) {
            Intent n = new Intent(this, GroupsActivity.class);
            startActivity(n);
        } else if (id == R.id.nav_requests) {
            Intent n = new Intent(this, RequestsActivity.class);
            startActivity(n);
        } else if (id == R.id.nav_requests_friends) {
            //TODO
        } else if (id == R.id.nav_logout) {
            //TODO

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void nav() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        assert drawer != null;
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);


    }
}
