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
 * Created by usman on 10/11/2016.
 */

public class RequestListAdapter extends ArrayAdapter<String> {


    private final Activity context;

    private final String[] web;

    public RequestListAdapter(Activity context, String[] web) {
        super(context, 0, web);
        this.context = context;
        this.web = web;

    }

    @NonNull
    @Override
    public View getView(int position, View rowView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
//        View rowView = inflater.inflate(R.layout.custom_requests, null, true);
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.custom_requests, null);
        }
        TextView txtTitle = (TextView) rowView.findViewById(R.id.request_list);


        txtTitle.setText(web[position]);


        return rowView;
    }
}
