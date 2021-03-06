package com.syngenta.rhoffman.syngenta;

import java.util.ArrayList;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;


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

	final static String describeAatrex = App.getContext().getString(R.string.describeAatrex);
	final static String describeAtrazine = App.getContext().getString(R.string.describeAtrazine);
	final static String describeBicep = App.getContext().getString(R.string.describeBicep);
	final static String describeBoundary = App.getContext().getString(R.string.describeBoundary);
	final static String describeDual = App.getContext().getString(R.string.describeDual);
	final static String describeFlexstar = App.getContext().getString(R.string.describeFlexstar);
	final static String describeHalex = App.getContext().getString(R.string.describeHalex);
	final static String describeLexar = App.getContext().getString(R.string.describeLexar);
	final static String describeLumax = App.getContext().getString(R.string.describeLumax);
	final static String describePrefix = App.getContext().getString(R.string.describePrefix);
	final static String describePrincep = App.getContext().getString(R.string.describePrincep);
	final static String describeSequence = App.getContext().getString(R.string.describeSequence);
	final static String describeTouchdownHitech = App.getContext().getString(R.string.describeTouchdownHitech);
	final static String describeTouchdownTotal = App.getContext().getString(R.string.describeTouchdownTotal);

    // Create the Products
    final static Product aatrex = new Product("Aatrex 4L", 9.15, 5000, describeAatrex);
    final static Product atrazine = new Product("Atrazine 4L", 9.15, 5000, describeAtrazine);
    final static Product bicep = new Product("Bicep II Magnum", 9.31, 5000, describeBicep);
    final static Product bicepFC = new Product("Bicep II Magnum FC", 9.31, 5000, describeBicep);
    final static Product bicepLite = new Product("Bicep LITE II Magnum", 9.31, 5000, describeBicep);
    final static Product boundary = new Product("Boundary", 9.01, 5000, describeBoundary);
    final static Product dual = new Product("Dual II Magnum", 9.28, 5000, describeDual);
    final static Product flexstar = new Product("Flexstar GT 3.5", 10.08, 4300, describeFlexstar);
    final static Product halex = new Product("Halex GT", 10.08, 4420, describeHalex);
    final static Product lexar = new Product("Lexar EZ", 9.15, 5000, describeLexar);
    final static Product lumax = new Product("Lumax EZ", 9.12, 5000, describeLumax);
    final static Product prefix = new Product("Prefix", 9.32, 5000, describePrefix);
    final static Product princep = new Product("Princep 4L", 9.47, 4800, describePrincep);
    final static Product sequence = new Product("Sequence", 10.2, 4400, describeSequence);
    final static Product touchdownHT = new Product("Touchdown HiTech", 11.73, 3800, describeTouchdownHitech);
    final static Product touchdown = new Product("Touchdown Total", 11.13, 4000, describeTouchdownTotal);

    // Initialize the arrays of products for each bulk site.
    final static String[] mtsProducts = {"Aatrex 4L", "Atrazine 4L", "Bicep II Magnum", "Brawl II ATZ",
            "Cinch + Atrazine", "Infantry", "Lexar EZ", "Lumax EZ", "Medal II ATZ", "Sequence"};
    final static String[] desMoinesProducts = {"Touchdown Total"};
    final static String[] farmerCityProducts = {"Aatrex 4L", "Bicep II Magnum", "Brawl II ATZ",
            "Charger Max ATZ", "Halex GT", "Lexar EZ", "Lumax EZ", "Medal II ATZ", "Touchdown Total"};
    final static String[] greensburgProducts = {"Flexstar GT 3.5", "Lexar EZ", "Lumax EZ", "Prefix",
            "Princep", "Touchdown HiTech", "Touchdown Total"};
    final static String[] memphisProducts = {"Prefix", "Touchdown Total"};
    final static String[] mortonProducts = {"Aatrex 4L", "Atrazine 4L", "Bicep LITE II Magnum",
            "Cinch + Atrazine", "Infantry", "Lexar EZ", "Lumax EZ", "Prefix"};
    final static String[] saintLouisProducts = {"Aatrex 4L", "Atrazine 4L", "Halex GT", "Lexar EZ"};
    final static String[] websterCityProducts = {"Halex GT", "Lexar EZ"};
    final static String[] wortonProducts = {"Touchdown Total"};

    // Create the Bulk Sites
    final static BulkSite mts = new BulkSite("Mount Sterling, OH", 8, 4, mtsProducts);
    final static BulkSite desMoines = new BulkSite("Des Moines, IA", 8, 4, desMoinesProducts);
    final static BulkSite farmerCity = new BulkSite("Farmer City, IL", 7, 3, farmerCityProducts);
    final static BulkSite gre = new BulkSite("Greensburg, IN", 7, 3, greensburgProducts);
    final static BulkSite memphis = new BulkSite("Memphis, TN", 6, 2, memphisProducts);
    final static BulkSite morton = new BulkSite("Morton, IL", 7, 3, mortonProducts);
    final static BulkSite stl = new BulkSite("Saint Louis, MO", 6, 3, saintLouisProducts);
    final static BulkSite websterCity = new BulkSite("Webster City, IA", 0, 0, websterCityProducts);
    final static BulkSite worton = new BulkSite("Worton, MD", 7, 3, wortonProducts);

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
            } else if(position == 1){
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

		// Initialize the array of products
		private Product[] products = {aatrex, atrazine, bicep, bicepFC, bicepLite, boundary,
				dual, flexstar, halex, lexar, lumax, prefix, princep, sequence, touchdownHT,
				touchdown};

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

            final View rootView = inflater.inflate(R.layout.fragment_product_info, container, false);


			initializeCards(rootView);

            return rootView;
        }

		private void initializeCards(final View rootView){

			int i;

			ArrayList<Card> cards = new ArrayList<>();
			for(i = 0; i < products.length; i++){

				Card card = initializeCard(rootView, i);

				cards.add(card);
			}

			//Create and set the array adapter so it can be displayed in the list view
			CardArrayAdapter cardArrayAdapter = new CardArrayAdapter(rootView.getContext(), cards);
			CardListView cardListView = (CardListView) rootView.findViewById(R.id.card_demo_list);
			if(cardListView != null){
				cardListView.setAdapter(cardArrayAdapter);
			}

		}

		private Card initializeCard(View rootView, final int loopCounter){

			Product product = products[loopCounter];
			String title = product.name;
			double weight = product.weight;
			int capacity = product.capacity;

			//Create a card
			Card card = new Card(rootView.getContext());

			//Create the card header
			CardHeader header = new CardHeader(rootView.getContext());

			header.setTitle(title + "\n" + weight + " pounds per gallon\n" + capacity + " gallons per load");

			card.addCardHeader(header);

			card.setOnClickListener(new Card.OnCardClickListener() {

				@Override
				public void onClick(Card card, View view) {

					displayProductInfo(loopCounter);
				}
			});

			return card;

		}

        public void displayProductInfo(int position){

			Product product = products[position];
			String title = product.name;
			double weight = product.weight;
			int capacity = product.capacity;
			String description = product.description;

			Intent intent = new Intent(ProductInfoFragment.this.getActivity(), DisplayProduct.class);

			Bundle products = new Bundle();
			products.putString("PRODUCT_NAME", title);
			products.putDouble("PRODUCT_WEIGHT", weight);
			products.putInt("PRODUCT_CAPACITY", capacity);
			products.putString("PRODUCT_DESCRIPTION", description);
			products.putInt("PRODUCT_KEY", position);
			intent.putExtras(products);

			startActivity(intent);

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

            final View rootView = inflater.inflate(R.layout.fragment_top_load_matrix, container, false);

            // Initialize the spinners.
            final Spinner spinner1 = (Spinner) rootView.findViewById(R.id.products_spinner1);
            final Spinner spinner2 = (Spinner) rootView.findViewById(R.id.products_spinner2);

            // Create the array adapters.
            ArrayAdapter<CharSequence> spinnerAdapter1 = ArrayAdapter.createFromResource(
                    this.getActivity(), R.array.product_list, android.R.layout.simple_spinner_item);
            ArrayAdapter<CharSequence> spinnerAdapter2 = ArrayAdapter.createFromResource(
                    this.getActivity(), R.array.product_list, android.R.layout.simple_spinner_item);

            // Specify the layout to use when the list of choices appears.
            spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // Apply the adapter to populate spinner with the array.
            spinner1.setAdapter(spinnerAdapter1);
            spinner2.setAdapter(spinnerAdapter2);

            // Set the onClick listener for spinner1 and wait for an item to be selected.
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

            // Set the onClick listener for spinner2 and wait for an item to be selected.
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

             /**
              * Create a button that, when clicked, will get the position of each spinner when clicked
              * as well as the String of each spinner, and pass those as arguments to the decision
              * function.
              */

            Button button = (Button) rootView.findViewById(R.id.topLoadMatrixButton);
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

            return rootView;
        }

        /**
         * This function checks if a and b are equal. If they are there is no need to go any
         * further and it will start activity_top_load_true. If they are not equal, there will need
         * to be further decisions that will be passed on.
         */

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

        private ListView listView;

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

            // Initialize the array of Bulk Sites
            BulkSite[] bulkSites = {desMoines, farmerCity, gre, memphis, morton, mts, stl, websterCity,
                worton};

			String[] bulkSiteNames = new String[9];

			for(int i = 0; i < bulkSites.length; i++){
				BulkSite bulkSite = bulkSites[i];
				bulkSiteNames[i] = bulkSite.location;
			}

            // Set up the ArrayAdapter
            ArrayAdapter<String> bulkSiteArrayAdapter =
                    new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, bulkSiteNames);

            listView = (ListView) rootView.findViewById(R.id.bulkSiteListView);
            listView.setAdapter(bulkSiteArrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                    displayBulkSiteInfo(position);

                }
            });

            return rootView;
        }

        public void displayBulkSiteInfo(int position){

            switch(position){

                case 0:
                    startBulkSite(desMoinesProducts, desMoines.location);
                    break;
                case 1:
                    startBulkSite(farmerCityProducts, farmerCity.location);
                    break;
                case 2:
                    startBulkSite(greensburgProducts, gre.location);
                    break;
                case 3:
                    startBulkSite(memphisProducts, memphis.location);
                    break;
                case 4:
                    startBulkSite(mortonProducts, morton.location);
                    break;
                case 5:
                    startBulkSite(mtsProducts, mts.location);
                    break;
                case 6:
                    startBulkSite(saintLouisProducts, stl.location);
                    break;
                case 7:
                    startBulkSite(websterCityProducts, websterCity.location);
                    break;
                case 8:
                    startBulkSite(wortonProducts, worton.location);
                    break;

            }

        }

        public void startBulkSite(String[] allProducts, String name){

            Intent bulkSiteIntent = new Intent(BulkSiteFragment.this.getActivity(), DisplayBulkSite.class);

            Bundle bulkSiteBundle = new Bundle();
            bulkSiteBundle.putString("BULK_SITE", name);
            bulkSiteBundle.putStringArray("PRODUCT_LIST", allProducts);
            bulkSiteIntent.putExtras(bulkSiteBundle);

            startActivity(bulkSiteIntent);

        }

    }
}
