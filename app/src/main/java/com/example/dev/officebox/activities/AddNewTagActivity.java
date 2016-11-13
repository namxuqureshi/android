package com.example.dev.officebox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev.officebox.R;
import com.example.dev.officebox.adapters.AddNewTagAdapter;

public class AddNewTagActivity extends NavigationActivity {


    private TextView textView;
    private Integer[] numbers = {
            R.drawable.circle, R.drawable.circle, R.drawable.circle
    };

    //private ArrayList<Image> images = new ArrayList<>();

    //private int REQUEST_CODE_PICKER = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nav_add_new_tag);
        super.nav();
        TextView title = (TextView) findViewById(R.id.titleInBar);
        title.setText("Add New Tag");
        AddNewTagAdapter adapter = new
                AddNewTagAdapter(AddNewTagActivity.this, numbers);

        final GridView g_view = (GridView) findViewById(R.id.gridView);
        g_view.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE);
        g_view.setItemChecked(1, true);

        g_view.setAdapter(adapter);
//        g_view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                SparseBooleanArray sp = g_view.getCheckedItemPositions();
//
//                String selected = null;
//                final int sp_size = sp.size();// Moved  sp.size() call out of the loop to local variable sp_size
//                for (int i = 0; i < sp_size; i++) {
//                    if (sp.get(i)) {
//
//                        selected += g_view.getItemAtPosition(i).toString() + "\n";
//                    }
//                }
//
//                Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();
//                return true;
//
//            }
//        });
        g_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked at " + numbers[+position], Toast.LENGTH_SHORT).show();
            }
        });
        EditText temp = (EditText) findViewById(R.id.editText);
        temp.setText(getIntent().getStringExtra("TAG_ID"));

//        textView = (TextView) findViewById(R.id.text_view);
//        final Button buttonPickImage = (Button) findViewById(R.id.button_pick_image);
//        buttonPickImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View view) {
//                //  start();
//                textView.setText("Image Selected");
//            }
//        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return super.onNavigationItemSelected(item);
    }


    // Recomended builder
//    private void start() {
//        ImagePicker.create(this)
//                .folderMode(true) // set folder mode (false by default)
//                .folderTitle("Folder") // folder selection title
//                .imageTitle("Tap to select") // image selection title
//                .multi() // multi mode (default mode)
//                .limit(1) // max images can be selected (99 by default)
//                .showCamera(false) // show camera or not (true by default)
//                .imageDirectory("Camera")   // captured image directory name ("Camera" folder by default)
//                .origin(images) // original selected images, used in multi mode
//                .start(REQUEST_CODE_PICKER); // start image picker activity with request code
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_CODE_PICKER && resultCode == RESULT_OK && data != null) {
//            images = data.getParcelableArrayListExtra(ImagePickerActivity.INTENT_EXTRA_SELECTED_IMAGES);
//            StringBuilder stringBuffer = new StringBuilder();
//            for (int i = 0, l = images.size(); i < l; i++) {
//                stringBuffer.append(images.get(i).getPath()).append("\n");
//            }
//            CircleImageView img = (CircleImageView) findViewById(R.id.circleView2);
//
//            img.setImageURI(data.getData());
//
//            textView.setText("Image Selected");
//
//        }
//    }

    public void onBackPressed(final View view) {
        Toast.makeText(this, "Name and Image Selected Successfully!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, TagActivity.class);
        startActivity(i);
        finish();
    }
}
