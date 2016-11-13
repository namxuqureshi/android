package com.example.dev.officebox.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.dev.officebox.R;

/**
 * Created by usman on 10/11/2016.
 */

public class AddNewTagAdapter extends ArrayAdapter<Integer> {


    private final Activity context;
    //    private final String[] web;
    private final Integer[] img;

    public AddNewTagAdapter(Activity context, Integer[] img) {
        super(context, 0, img);
        this.context = context;
        this.img = img;

    }

    private static class ViewHolder {
        ImageView imageView;

        ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.grid_item_image);
        }
    }

    @NonNull
    @Override
    public View getView(int position, View rowView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        ViewHolder holder;
//        View rowView = inflater.inflate(R.layout.grid_view, null, true);
//        TextView txtTitle = (TextView) rowView.findViewById(R.id.tag_name);
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.grid_view, parent, false);
            holder = new ViewHolder(rowView);
            rowView.setTag(holder);

        } else {
            holder = (ViewHolder) rowView.getTag();

        }


//        ImageView imageView = (ImageView) rowView.findViewById(R.id.grid_item_image);

        holder.imageView.setImageResource(img[position]);
        return rowView;
    }
}

