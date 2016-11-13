package com.example.dev.officebox.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev.officebox.R;
import com.example.dev.officebox.adapters.TagAdapter;

public class TagActivity extends NavigationActivity {
    private TagAdapter adapter;

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        return super.onNavigationItemSelected(item);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_navigation);
        nav();
        adapter = new
                TagAdapter(TagActivity.this, web);
        final ListView lv = (ListView) findViewById(R.id.list_tag);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(final AdapterView<?> parent, final View view,
                                    final int position, final long id) {

                final Intent i = new Intent(TagActivity.this, TagMainActivity.class);
                startActivity(i);
            }
        });

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final Intent i = new Intent(TagActivity.this, NFCActivity.class);
                startActivity(i);
            }
        });
        final TextView title = (TextView) findViewById(R.id.titleInBar);
        title.setText("TAGS");
        registerForContextMenu(lv);

    }


    @Override
    public void onCreateContextMenu(final ContextMenu menu, final View v,
                                    final ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        final AdapterView.AdapterContextMenuInfo aInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Options for " + adapter.getItem(aInfo.position));
        menu.add(1, 1, 1, "Edit");
        menu.add(1, 2, 2, "Delete");
    }

    @Override
    public boolean onContextItemSelected(final MenuItem item) {
        final AdapterView.AdapterContextMenuInfo Info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case 1:
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.activity_dialogue_box);
//                dialog.setTitle("HELOO");

                // set the custom dialog components - text, image and button
                final TextView text = (TextView) dialog.findViewById(R.id.name);
                text.setText(adapter.getItem(Info.position));

                final Button dialogButtonOK = (Button) dialog.findViewById(R.id.dialogButtonOK);
                dialogButtonOK.setText("OK");
//                Button dialogButtonCANCEL = (Button) dialog.findViewById(R.id.dialogButtonCANCEL);
//                dialogButtonCANCEL.setText("Cancel");
                // if button is clicked, close the custom dialog
                dialogButtonOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Toast.makeText(TagActivity.this, "Edit Successfully", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
//                dialogButtonCANCEL.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(TagActivity.this, "CANCEL EDIT", Toast.LENGTH_SHORT).show();
//                        dialog.dismiss();
//                    }
//                });

                dialog.show();


                break;
            case 2:
                Toast.makeText(this, "Delete Selected", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onContextItemSelected(item);
    }


}
