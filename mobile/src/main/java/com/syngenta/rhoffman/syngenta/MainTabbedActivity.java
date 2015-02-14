package com.syngenta.rhoffman.syngenta;

import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;


public class MainTabbedActivity extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * sections. We use a {@link FragmentPagerAdapter} derivative, which will keep every loaded
     * fragment in memory. If this becomes too memory intensive, it may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tabbed);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the
     * sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm){

            super(fm);
        }

        @Override
        public Fragment getItem(int position){
            // getItem is called to instantiate the fragment for the given page.
            // Test the position and return the correct fragment for each tab.

            if(position == 0){
                return ProductInfoFragment.newInstance(position + 1);
            } else if(position ==1){
                return TopLoadMatrixFragment.newInstance(position + 1);
            } else if(position == 2){
                return BulkSiteFragment.newInstance(position + 1);
            }

            return null;

        }

        @Override
        public int getCount(){
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position){

            Locale l = Locale.getDefault();
            switch(position){
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A fragment containing a ListView that lists all of the products we haul for Syngenta. When
     * clicked, it will pull up details about whatever product was selected.
     *
     * These details include: The product name, the weight in pounds per gallon, the maximum
     * amount that can fit in a trailer, and a description about what the product is used for.
     */
    public static class ProductInfoFragment extends Fragment {

        /**
         * The fragment argument representing the section number for this fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section number.
         */
        public static ProductInfoFragment newInstance(int sectionNumber){

            ProductInfoFragment fragment = new ProductInfoFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public ProductInfoFragment(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState){

            View rootView = inflater.inflate(R.layout.fragment_product_info, container, false);
            return rootView;
        }
    }

    /**
     * A fragment containing a simple view for the second tab of the main activity. This is the tab
     * that contains the top load matrix to test if one product can be top loaded onto another
     * without a wash.
     */
    public static class TopLoadMatrixFragment extends Fragment {

        /**
         * The fragment argument representing the section number for this fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section number.
         */
        public static TopLoadMatrixFragment newInstance(int sectionNumber){

            TopLoadMatrixFragment fragment = new TopLoadMatrixFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public TopLoadMatrixFragment(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState){
            // Initialize the first spinner and get the selected item.
            final Spinner spinner1 = (Spinner) getActivity().findViewById(R.id.products_spinner1);
            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> parent1, View view, int position1, long id1){
                    parent1.getItemAtPosition(position1);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent1){
                    // Do nothing.
                }
            });


            // Initialize the second spinner and get the selected item.
            final Spinner spinner2 = (Spinner) getActivity().findViewById(R.id.products_spinner2);
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                @Override
                public void onItemSelected(AdapterView<?> parent2, View view, int position2, long id2){
                    parent2.getItemAtPosition(position2);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent2){
                    // Do nothing.
                }

            });

            Button button = (Button) getActivity().findViewById(R.id.topLoadMatrixButton);
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int product1 = spinner1.getSelectedItemPosition();
                    int product2 = spinner2.getSelectedItemPosition();
                    String productA = spinner1.getSelectedItem().toString();
                    String productB = spinner2.getSelectedItem().toString();
                    decision(product1, product2, productA, productB);
                }
            });

            View rootView = inflater.inflate(R.layout.fragment_top_load_matrix, container, false);
            return rootView;
        }

        // This function checks if a and b are equal. If they are there is no need to go any
        // further and it will start activity_top_load_true. If they are not equal,
        // there will need to be further decisions that will be passed on.
        public void decision(int previousProduct, int nextProduct, String previousProductString,
                             String nextProductString){

            Toploadable toploadable = new Toploadable(previousProductString, nextProductString);

            if(previousProduct == nextProduct){
                startTrue(previousProductString, nextProductString);
            } else if(previousProduct == 5 ||
                    previousProduct == 7 ||
                    previousProduct == 8 ||
                    previousProduct == 11 ||
                    previousProduct == 12 ||
                    previousProduct == 13 ||
                    previousProduct == 15 ||
                    nextProduct == 5 ||
                    nextProduct == 7 ||
                    nextProduct == 8 ||
                    nextProduct == 11 ||
                    nextProduct == 12 ||
                    nextProduct == 13){
                startFalse(previousProductString, nextProductString);
            } else if(toploadable.checkProductsByName()){
                startTrue(previousProductString, nextProductString);
            } else if(!toploadable.checkProductsByName()){
                startFalse(previousProductString, nextProductString);
            }

        }

        public void startTrue(String previousProductExtra, String nextProductExtra){

            Intent intent = new Intent(TopLoadMatrixFragment.this.getActivity(), TopLoadTrue.class);

            Bundle products = new Bundle();
            products.putString("PREVIOUS_PRODUCT", previousProductExtra);
            products.putString("NEXT_PRODUCT", nextProductExtra);
            intent.putExtras(products);

            startActivity(intent);

        }

        public void startFalse(String previousProductExtra, String nextProductExtra){

            Intent intent = new Intent(TopLoadMatrixFragment.this.getActivity(), TopLoadFalse.class);

            Bundle products = new Bundle();
            products.putString("PREVIOUS_PRODUCT", previousProductExtra);
            products.putString("NEXT_PRODUCT", nextProductExtra);
            intent.putExtras(products);

            startActivity(intent);

        }

    }

    /**
     * A fragment containing a list view to display information about each bulk loading site. It
     * will list each location in the list view, and when clicked it will start a new activity that
     * displays all the products available at the site, as well as the address and hours.
     */
    public static class BulkSiteFragment extends Fragment {

        /**
         * The fragment argument representing the section number for this fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section number.
         */
        public static BulkSiteFragment newInstance(int sectionNumber){

            BulkSiteFragment fragment = new BulkSiteFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public BulkSiteFragment(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState){

            View rootView = inflater.inflate(R.layout.fragment_bulk_site, container, false);
            return rootView;
        }
    }
}
