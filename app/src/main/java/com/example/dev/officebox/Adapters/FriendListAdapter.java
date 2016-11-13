package com.example.dev.officebox.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev.officebox.R;
import com.example.dev.officebox.viewsHolder.FriendListHolder;
import com.l4digital.fastscroll.FastScroller;


public class FriendListAdapter extends
        RecyclerView.Adapter<FriendListHolder> implements FastScroller.SectionIndexer {

    @Override
    public FriendListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.custom_friend_list, parent, false);

        // Return a new holder instance
        return new FriendListHolder(contactView);
    }

    @Override
    public void onBindViewHolder(FriendListHolder viewHolder, int position) {
        // Get the data model based on position
//        Friend friend = mContacts.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.getNameTextView();
        textView.setText(friendData[position]);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Hola", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return friendData.length;
    }

    @Override
    public String getSectionText(int position) {
        return String.valueOf(getItemId(position));
    }


    //    private List<Friend> mContacts;
    private String[] friendData;

    private Context mContext;

    //    List<Friend> contacts
    public FriendListAdapter(Context context, String[] data) {
        friendData = data;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }
}
//public class FriendListAdapter extends RecyclerView.Adapter {
//    private static final String TAG = "Recycle";
//    private Activity context;
//    private String[] web;
//    public LayoutInflater inflater;
//
//    public FriendListAdapter(Activity context, String[] web) {
//        super();
//        this.context = context;
//        this.web = web;
//        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//
//    private class ViewHolder extends RecyclerView.ViewHolder {
//        TextView txtName;
//
//        ViewHolder(View v) {
//            super(v);
//            txtName = (TextView) v.findViewById(R.id.friend_list_name);
//            Log.d(TAG, "ViewHolder: run");
//        }
//    }
//
//    public void add(int position, String item) {
//        notifyItemInserted(position);
//    }
//
//    public void remove(String item) {
//
//    }
//    @Override
//    public FriendListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_friend_list, parent, false);
//        Log.d(TAG, "onCreateViewHolder: run");
//        return new ViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
//        final FriendListAdapter.ViewHolder hold = (FriendListAdapter.ViewHolder) holder;
//        hold.txtName.setText(web[position]);
//        Toast.makeText(context, "run", Toast.LENGTH_SHORT).show();
//        Log.d(TAG, "onBindViewHolder: run");
//        hold.txtName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Touched" + web[hold.getAdapterPosition()], Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//}
//
//public class FriendListAdapter extends ArrayAdapter<String> {
//    private final Activity context;
//    private final String[] web;
//
//    public FriendListAdapter(Activity context, String[] web) {
//        super(context, 0, web);
//        this.context = context;
//        this.web = web;
//
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, View rowView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = context.getLayoutInflater();
////        View rowView = inflater.inflate(R.layout.custom_friend_list, null, true);
//
//        if (rowView == null) {
//            rowView = inflater.inflate(R.layout.custom_friend_list, null);
//        }
//        TextView txtTitle = (TextView) rowView.findViewById(R.id.friend_list_name);
//////        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
////
//        txtTitle.setText(web[position]);
//
////        imageView.setImageResource(imageId[position]);
//        return rowView;
//    }
//}