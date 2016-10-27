package com.example.dev.officebox.Fragment;

/**
 * Created by usman on 10/26/2016.
 */

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev.officebox.Adapters.MessagesAdapter;
import com.example.dev.officebox.MessageMainActivity;
import com.example.dev.officebox.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragmentAll extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private final String[] web = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    };

    public PlaceholderFragmentAll() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragmentAll newInstance(final int sectionNumber) {
        final PlaceholderFragmentAll fragment = new PlaceholderFragmentAll();
        final Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    MessagesAdapter adapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tag_main_fragement_messages, container, false);
        adapter = new
                MessagesAdapter(getActivity(), web);
        final ListView lv = (ListView) rootView.findViewById(R.id.list_tag);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(final AdapterView<?> parent, final View view,
                                    final int position, final long id) {
                final Intent i = new Intent(getActivity(), MessageMainActivity.class);
                startActivity(i);
            }
        });
//                    textView.setText(PlaceholderFragment.newInstance(1) + "");
        registerForContextMenu(lv);
        return rootView;

    }

    @Override
    public void onCreateContextMenu(final ContextMenu menu, final View v,
                                    final ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        final AdapterView.AdapterContextMenuInfo aInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Options for " + adapter.getItem(aInfo.position));
        menu.add(1, 1, 1, "Edit");
        menu.add(1, 2, 2, "Delete");
    }

    @Override
    public boolean onContextItemSelected(final MenuItem item) {
        final AdapterView.AdapterContextMenuInfo Info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case 1:
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.activity_dialogue_box);
                dialog.setTitle("HELOO");

                // set the custom dialog components - text, image and button
                final TextView text = (TextView) dialog.findViewById(R.id.name);
                text.setText(adapter.getItem(Info.position));

                final Button dialogButtonOK = (Button) dialog.findViewById(R.id.dialogButtonOK);
                dialogButtonOK.setText("OK");
                // if button is clicked, close the custom dialog
                dialogButtonOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Toast.makeText(getContext(), "Edit Successfully", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case 2:
                Toast.makeText(getContext(), "Delete Selected", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onContextItemSelected(item);
    }
}//1Frag End Main Message Inner Class Frag
