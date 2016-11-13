package com.example.dev.officebox.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.dev.officebox.R;
import com.example.dev.officebox.adapters.FriendListAdapter;

/**
 * Created by N_U on 11-Oct-16.
 */

public class FriendListActivity extends NavigationActivity {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return super.onNavigationItemSelected(item);
    }

    //    ArrayAdapter<String> adpt;
//    ArrayList<String> name = new ArrayList<>();
//    ArrayList<Friend> friend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nav_friend);
        nav();
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
//        friend = Friend.createContactsList(20);
        // Create adapter passing in the sample user data
        FriendListAdapter adapter = new FriendListAdapter(this, web);
        // Attach the adapter to the recyclerview to populate items
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        // Set layout manager to position the items
        rv.setLayoutManager(new LinearLayoutManager(this));


//        for (int i = 0; i < 6; i++) {
//            name.add("Name " + i);
//        }
//        final ListView listview = (ListView) findViewById(R.id.friend_list);
//        adpt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, web);
//        final FriendListAdapter adapter = new
//                FriendListAdapter(FriendListActivity.this, web);
//
//        listview.setAdapter(adapter);
//        listview.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
//        listview.setSelector(R.drawable.selector_list);
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
////                TextView a = (TextView) view;
//                view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
////                adapter.notifyDataSetChanged();
//
//                Snackbar.make(view, "You Clicked at " + web[+position] + " " + view.getClass(), Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        TextView title = (TextView) findViewById(R.id.titleInBar);
        title.setText("Frieds List");
    }

}
