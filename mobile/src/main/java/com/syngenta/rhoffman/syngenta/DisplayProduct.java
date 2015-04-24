package com.syngenta.rhoffman.syngenta;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayProduct extends Activity {

    TextView productNameTextView;
	TextView productTextView;
	ImageView productImageView;

	int[] drawables = {R.mipmap.ic_aatrex, R.mipmap.ic_atrazine, R.mipmap.ic_bicep,
			R.mipmap.ic_bicep, R.mipmap.ic_bicep,
			R.mipmap.ic_boundary, R.mipmap.ic_dual, R.mipmap.ic_flexstar, R.mipmap.ic_halex,
			R.mipmap.ic_lexar, R.mipmap.ic_lumax, R.mipmap.ic_prefix, R.mipmap.ic_princep,
			R.mipmap.ic_sequence, R.mipmap.ic_touchdown_hitech, R.mipmap.ic_touchdown_total};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);

        Intent display = getIntent();
        String name = display.getExtras().getString("PRODUCT_NAME");
        double weight = display.getExtras().getDouble("PRODUCT_WEIGHT");
        int capacity = display.getExtras().getInt("PRODUCT_CAPACITY");
		int imageID = display.getExtras().getInt("PRODUCT_KEY");

		productImageView = (ImageView) findViewById(R.id.productImageView);
		productTextView = (TextView) findViewById(R.id.productTextView);
		productNameTextView = (TextView) findViewById(R.id.productNameTextView);

		productImageView.setImageResource(drawables[imageID]);

		productNameTextView.setTextSize(30);
		productNameTextView.setTextColor(Color.WHITE);
		productNameTextView.setText(name);

		productTextView.setTextSize(30);
        productTextView.setText("Weight: " + weight + " lbs/gal\nCapacity: " + capacity + " gallons");

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
