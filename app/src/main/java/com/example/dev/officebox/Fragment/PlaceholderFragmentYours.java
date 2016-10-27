package com.example.dev.officebox.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dev.officebox.Adapters.MessagesAdapter;
import com.example.dev.officebox.R;

/**
 * Created by usman on 10/26/2016.
 */

public class PlaceholderFragmentYours extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private final String[] web = {
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    };

    public PlaceholderFragmentYours() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragmentYours newInstance(final int sectionNumber) {
        final PlaceholderFragmentYours fragment = new PlaceholderFragmentYours();
        final Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tag_main_fragement_messages, container, false);
        final MessagesAdapter adapter = new
                MessagesAdapter(getActivity(), web);
        final ListView lv = (ListView) rootView.findViewById(R.id.list_tag);
        lv.setAdapter(adapter);
//                    textView.setText(PlaceholderFragment.newInstance(1) + "");
        return rootView;
    }
}

