package com.example.dev.officebox;

import android.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TagMainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TagMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TagMainFragment extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
////    private SectionsPagerAdapter mSectionsPagerAdapter;
//
//    /**
//     * The {@link ViewPager} that will host the section contents.
//     */
//    private ViewPager mViewPager;
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;
////    private FragmentActivity myContext;
//
//    public TagMainFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment TagMainFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static Fragment newInstance(String param1, String param2) {
//        TagMainFragment fragment = new TagMainFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
////        FragmentManager fragManager = getFragmentManager();
////        mSectionsPagerAdapter = new com.example.dev.officebox.TagMainFragment.SectionsPagerAdapter(fragManager);
////
////        mViewPager = (ViewPager) getView().findViewById(R.id.container);
////        // Set up the ViewPager with the sections adapter.
////        mViewPager.setAdapter(mSectionsPagerAdapter);
////
////        TabLayout tabLayout = (TabLayout) getView().findViewById(R.id.tabs);
////        tabLayout.setupWithViewPager(mViewPager);
////
////        FloatingActionButton fab = (FloatingActionButton) getView().findViewById(R.id.fab);
////        fab.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
////            }
////        });
//        return inflater.inflate(R.layout.fragment_tag_main, container, false);
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
//
//    /**
//     * A placeholder fragment containing a simple view.*/
///*
//     *//*
//
//    public static class PlaceholderFragment extends Fragment {
//        */
///**
//         * The fragment argument representing the section number for this
//         * fragment.
//         *//*
//
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//        private String[] web = {
//                "Google Plus",
//                "Twitter",
//                "Windows",
//                "Bing",
//                "Itunes",
//                "Wordpress",
//                "Drupal"
//        };
//
//        */
///**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         *//*
//
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.tag_main_fragement_messages, container, false);
//            MessagesAdapter adapter = new
//                    MessagesAdapter(getActivity(), web);
//            ListView lv = (ListView) rootView.findViewById(R.id.list_tag);
//            lv.setAdapter(adapter);
//            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view,
//                                        int position, long id) {
//                    Intent i = new Intent(getActivity(), MessageMainActivity.class);
//                    startActivity(i);
//                }
//            });
////                    textView.setText(PlaceholderFragment.newInstance(1) + "");
//            return rootView;
//        }
//    }
//
//    public static class PlaceholderFragment2 extends Fragment {
//        */
///**
//         * The fragment argument representing the section number for this
//         * fragment.
//         *//*
//
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment2() {
//        }
//
//        private String[] web = {
//                "Bing",
//                "Itunes",
//                "Wordpress",
//                "Drupal"
//        };
//
//        */
///**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         *//*
//
//        public static PlaceholderFragment2 newInstance(int sectionNumber) {
//            PlaceholderFragment2 fragment = new PlaceholderFragment2();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.tag_main_fragement_messages, container, false);
//            MessagesAdapter adapter = new
//                    MessagesAdapter(getActivity(), web);
//            ListView lv = (ListView) rootView.findViewById(R.id.list_tag);
//            lv.setAdapter(adapter);
////                    textView.setText(PlaceholderFragment.newInstance(1) + "");
//            return rootView;
//        }
//    }
//
//
//    public static class PlaceholderFragment3 extends Fragment {
//        */
///**
//         * The fragment argument representing the section number for this
//         * fragment.
//         *//*
//
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment3() {
//        }
//
//        private String[] web = {
//                "Wordpress",
//                "Drupal"
//        };
//
//        */
///**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         *//*
//
//        public static PlaceholderFragment3 newInstance(int sectionNumber) {
//            PlaceholderFragment3 fragment = new PlaceholderFragment3();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.tag_main_fragement_messages, container, false);
//            MessagesAdapter adapter = new
//                    MessagesAdapter(getActivity(), web);
//            ListView lv = (ListView) rootView.findViewById(R.id.list_tag);
//            lv.setAdapter(adapter);
//            return rootView;
//        }
//    }
//
//    */
///**
//     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
//     * one of the sections/tabs/pages.
//     *//*
//
//    public class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//        SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            // getItem is called to instantiate the fragment for the given page.
//            // Return a PlaceholderFragment (defined as a static inner class below).
////                return PlaceholderFragment2.newInstance(position + 1);
//
//            switch (position) {
//                case 0:
//                    //page 1
//                    return PlaceholderFragment.newInstance(1);
//                case 1:
//                    //page 2
//                    return PlaceholderFragment2.newInstance(1);
//                case 2:
//                    //page 2
//                    return PlaceholderFragment3.newInstance(1);
//                default:
//                    //this page does not exists
//                    return null;
//            }
//        }
//
//        @Override
//        public int getCount() {
//            // Show 3 total pages.
//            return 3;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "All";
//                case 1:
//                    return "Yours";
//                case 2:
//                    return "Friends";
//            }
//            return null;
//        }
//    }
//*/
//

}
