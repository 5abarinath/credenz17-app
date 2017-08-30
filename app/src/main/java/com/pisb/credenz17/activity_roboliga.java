package com.pisb.credenz17;

import android.support.v4.view.PagerTabStrip;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


public class activity_roboliga extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_event_screen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        PagerTabStrip tabStrip = (PagerTabStrip) findViewById(R.id.pager_tab_strip);
        tabStrip.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_activity_webweaver, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final int DATA[] = new int[6];

        public PlaceholderFragment() {  //TODO: Add correct data
            DATA[0] = R.string.robo_intro;
            DATA[1] = R.string.robo_rules;
            DATA[2] = R.string.robo_structure;
            DATA[3] = R.string.robo_judging;
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_event_data, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(DATA[getArguments().getInt(ARG_SECTION_NUMBER)] ));
            return rootView;
        }
    }

    /*
        Fragment for contact tab
     */
    public static class EventFragment_contact extends Fragment {

        private static final int CONTACT_DATA[] = new int[5];

        public EventFragment_contact() {
            CONTACT_DATA[0] = R.string.robo_coord1;
            CONTACT_DATA[1] = R.string.robo_coord1_contact;
            CONTACT_DATA[2] = R.string.robo_coord2;
            CONTACT_DATA[3] = R.string.robo_coord2_contact;
            CONTACT_DATA[4] = R.string.robo_email;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_event_contact, container, false);
            TextView tv_coord1 = (TextView) rootView.findViewById(R.id.tv_coord1);
            tv_coord1.setText(getString(CONTACT_DATA[0]));

            TextView tv_coord1_contact = (TextView) rootView.findViewById(R.id.tv_coord1_contact);
            tv_coord1_contact.setText(getString(CONTACT_DATA[1]));

            TextView tv_coord2 = (TextView) rootView.findViewById(R.id.tv_coord2);
            tv_coord2.setText(getString(CONTACT_DATA[2]));

            TextView tv_coord2_contact = (TextView) rootView.findViewById(R.id.tv_coord2_contact);
            tv_coord2_contact.setText(getString(CONTACT_DATA[3]));

            TextView tv_email = (TextView) rootView.findViewById(R.id.tv_email);
            tv_email.setText(getString(CONTACT_DATA[4]));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position==4) {
                return new EventFragment_contact();
            }
            else
                return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Intro";
                case 1:
                    return "Rules";
                case 2:
                    return "Structure";
                case 3:
                    return "Judging";
                case 4:
                    return "Contact";
            }
            return null;
        }
    }
}
