package com.syngenta.rhoffman.syngenta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayProduct extends Activity {

    TextView productTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);

        Intent display = getIntent();
        String name = display.getExtras().getString("PRODUCT_NAME");
        double weight = display.getExtras().getDouble("PRODUCT_WEIGHT");
        int capacity = display.getExtras().getInt("PRODUCT_CAPACITY");

        productTextView = (TextView) findViewById(R.id.productTextView);
        productTextView.setTextSize(30);
        productTextView.setText(name + "\nWeight: " + weight + " lbs/gal\nCapacity: " + capacity + " gallons");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_product, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
