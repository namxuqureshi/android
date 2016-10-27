package com.example.dev.officebox;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev.officebox.Adapters.ReplyAdapter;

public class MessageMainActivity extends AppCompatActivity {

    private String[] web = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    };
    ReplyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_message_main);
        adapter = new
                ReplyAdapter(MessageMainActivity.this, web);
        ListView lv = (ListView) findViewById(R.id.reply_list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MessageMainActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

            }
        });
        ImageView imgBtn = (ImageView) findViewById(R.id.backBtnImg);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        registerForContextMenu(lv);
        TextView title=(TextView )findViewById(R.id.titleInBar);
        title.setText("Tag Main");
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo aInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Options for " + adapter.getItem(aInfo.position));
        menu.add(1, 1, 1, "Edit");
        menu.add(1, 2, 2, "Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo Info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case 1:
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.activity_dialogue_box);
                dialog.setTitle("HELOO");

                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.name);
                text.setText(adapter.getItem(Info.position));

                Button dialogButtonOK = (Button) dialog.findViewById(R.id.dialogButtonOK);
                dialogButtonOK.setText("OK");
                // if button is clicked, close the custom dialog
                dialogButtonOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Edit Successfully", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case 2:
                Toast.makeText(this, "Delete Selected", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onContextItemSelected(item);
    }
}
