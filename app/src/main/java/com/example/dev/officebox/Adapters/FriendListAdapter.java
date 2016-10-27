package com.example.dev.officebox.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dev.officebox.R;

/**
 * Created by N_U on 11-Oct-16.
 */

public class FriendListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] web;

    public FriendListAdapter(Activity context, String[] web) {
        super(context, 0, web);
        this.context = context;
        this.web = web;

    }

    @NonNull
    @Override
    public View getView(int position, View rowView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
//        View rowView = inflater.inflate(R.layout.custom_friend_list, null, true);

        if (rowView == null) {
            rowView = inflater.inflate(R.layout.custom_friend_list, null);
        }
        TextView txtTitle = (TextView) rowView.findViewById(R.id.friend_list_name);
//        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web[position]);

//        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
