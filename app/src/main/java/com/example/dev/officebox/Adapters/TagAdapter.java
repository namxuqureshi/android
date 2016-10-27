package com.example.dev.officebox.Adapters;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dev.officebox.R;

public class TagAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;

    public TagAdapter(Activity context, String[] web) {
        super(context, 0, web);
        this.context = context;
        this.web = web;

    }

    @NonNull
    @Override
    public View getView(int position, View rowView, @NonNull ViewGroup parent) {
        final LayoutInflater inflater = context.getLayoutInflater();
//        final View rowView = inflater.inflate(R.layout.custom_tag, null, true);
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.custom_tag, null);
        }
        final TextView txtTitle = (TextView) rowView.findViewById(R.id.tag_name);


        txtTitle.setText(web[position]);


        return rowView;
    }
}
