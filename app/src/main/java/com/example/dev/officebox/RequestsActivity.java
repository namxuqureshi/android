package com.example.dev.officebox;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dev.officebox.Adapters.RequestListAdapter;

public class RequestsActivity extends NavigationActivity {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return super.onNavigationItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nav_requests);

        nav();
        RequestListAdapter adapter = new
                RequestListAdapter(RequestsActivity.this, web);
        ListView listview = (ListView) findViewById(R.id.requests_list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Snackbar.make(view, "You Clicked at " + web[+position], Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        TextView title=(TextView )findViewById(R.id.titleInBar);
        title.setText("Requests");
    }
}
