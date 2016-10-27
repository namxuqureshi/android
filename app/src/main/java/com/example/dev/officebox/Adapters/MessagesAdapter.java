package com.example.dev.officebox.Adapters;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dev.officebox.R;

public class MessagesAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;

    public MessagesAdapter(final Activity context, final String[] web) {
        super(context, 0, web);
        this.context = context;
        this.web = web;

    }

    @NonNull
    @Override
    public View getView(final int position, View rowView, final @NonNull ViewGroup parent) {
        final LayoutInflater inflater = context.getLayoutInflater();
//        final View rowView = inflater.inflate(R.layout.custom_message, null, true);
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.custom_message, null);
        }
        final TextView txtTitle = (TextView) rowView.findViewById(R.id.message_name);

//        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web[position]);

//        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
