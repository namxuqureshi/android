package com.example.dev.officebox.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dev.officebox.R;

public class NewMessageActivity extends NavigationActivity {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return super.onNavigationItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nav_new_message);
        nav();
        TextView textView = (TextView) findViewById(R.id.addPermission);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(NewMessageActivity.this);
                dialog.setContentView(R.layout.activity_new_message_permission);
                dialog.setTitle("HELOO");

                Button btn = (Button) dialog.findViewById(R.id.cancelBtn);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();


            }
        });
        TextView title = (TextView) findViewById(R.id.titleInBar);
        title.setText("New Message");

    }


}
