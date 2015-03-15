package com.syngenta.rhoffman.syngenta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class DisplayBulkSite extends Activity {

    TextView bulkSiteTextView;
    ListView bulkSiteListView;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_bulk_site);

        // Get the info that was passed along with the intent
        Intent site = getIntent();
        Bundle bundle = site.getExtras();
        String location = bundle.getString("BULK_SITE");
        String [] allProducts = bundle.getStringArray("PRODUCT_LIST");

        // Set the TextView and add the text
        bulkSiteTextView = (TextView) findViewById(R.id.locationTextView);
        bulkSiteTextView.setTextSize(20);
        bulkSiteTextView.setText(location);

        // Create the array adapter used to populate the list view
        ArrayAdapter<String> bulkSiteProductsArrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allProducts);

        // Set the ListView and set the array adapter
        bulkSiteListView = (ListView) findViewById(R.id.bulkSiteListView);
        bulkSiteListView.setAdapter(bulkSiteProductsArrayAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_bulk_site, menu);
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
}
