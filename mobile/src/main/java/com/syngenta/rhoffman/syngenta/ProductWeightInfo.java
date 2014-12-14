package com.syngenta.rhoffman.syngenta;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;


public class ProductWeightInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_weight_info);

        //Initialize the spinner and get the selected value.
        final Spinner spinner = (Spinner) findViewById(R.id.products_spinner_weight);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){
                // Do nothing.
            }
        });

        //Set the onClick listener to handle clicks.
        Button button = (Button) findViewById(R.id.productWeightInfoButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int pos = spinner.getSelectedItemPosition();
                displayProductInfo(pos);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.product_weight_info, menu);
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

    // This function is just a decision maker which starts another function displaying the appropriate
    // product information.
    public void displayProductInfo(int product){

        Product aatrex = new Product("Aatrex 4L", 9.15, 5000);
        Product atrazine = new Product("Atrazine 4L", 9.15, 5000);
        Product bicep = new Product("Bicep II Magnum", 9.31, 5000);
        Product bicepFC = new Product("Bicep II Magnum FC", 9.31, 5000);
        Product bicepLite = new Product("Bicep LITE II Magnum", 9.31, 5000);
        Product boundary = new Product("Boundary", 9.01, 5000);
        Product dual = new Product("Dual II Magnum", 9.28, 5000);
        Product flexstar = new Product("Flexstar GT 3.5", 10.08, 4300);
        Product halex = new Product("Halex GT", 10.08, 4420);
        Product lexar = new Product("Lexar EZ", 9.15, 5000);
        Product lumax = new Product("Lumax EZ", 9.12, 5000);
        Product prefix = new Product("Prefix", 9.32, 5000);
        Product princep = new Product("Princep 4L", 9.47, 4800);
        Product sequence = new Product("Sequence", 10.2, 4400);
        Product touchdownHT = new Product("Touchdown HiTech", 11.73, 3800);
        Product touchdown = new Product("Touchdown Total", 11.13, 4000);

        switch (product){
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;
            case 11:

                break;
            case 12:

                break;
            case 13:

                break;
            case 14:

                break;
            case 15:

                break;

        }

    }



}
