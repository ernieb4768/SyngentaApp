package com.syngenta.rhoffman.syngenta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;


public class TopLoadMatrix extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_load_matrix);

        // Initialize the first spinner and get the selected item.
        final Spinner spinner1 = (Spinner) findViewById(R.id.products_spinner1);
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
        final Spinner spinner2 = (Spinner) findViewById(R.id.products_spinner2);
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

        Button button = (Button) findViewById(R.id.topLoadMatrixButton);
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

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top_load_matrix, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    // This function checks if a and b are equal. If they are there is no need to go any
    // further and it will start activity_top_load_true. If they are not equal,
    // there will need to be further decisions that will be passed on.
    public void decision(int previousProduct, int nextProduct, String previousProductString,
                         String nextProductString){

        if(previousProduct == nextProduct){
            startTrue(previousProductString, nextProductString);
        } else if(previousProduct == 5 || previousProduct == 7 || previousProduct == 8 ||
                previousProduct == 11 || previousProduct == 12 || previousProduct == 13 ||
                previousProduct == 15 || nextProduct == 5 || nextProduct == 7 || nextProduct == 8 ||
                nextProduct == 11 || nextProduct == 12 || nextProduct == 13 || nextProduct == 15){
            startFalse(previousProductString, nextProductString);
        } else {
            Toploadable toploadable = new Toploadable();
            toploadable.checkProductsByName(nextProduct, previousProductString, nextProductString);
        }

    }

    public void startTrue(String previousProductExtra, String nextProductExtra){

        Intent intent = new Intent(this, TopLoadTrue.class);

        Bundle products = new Bundle();
        products.putString("PREVIOUS_PRODUCT", previousProductExtra);
        products.putString("NEXT_PRODUCT", nextProductExtra);
        intent.putExtras(products);

        startActivity(intent);

    }

    public void startFalse(String previousProductExtra, String nextProductExtra){

        Intent intent = new Intent(this, TopLoadFalse.class);

        Bundle products = new Bundle();
        products.putString("PREVIOUS_PRODUCT", previousProductExtra);
        products.putString("NEXT_PRODUCT", nextProductExtra);
        intent.putExtras(products);

        startActivity(intent);

    }

}
