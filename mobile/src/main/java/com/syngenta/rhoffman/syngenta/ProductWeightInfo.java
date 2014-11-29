package com.syngenta.rhoffman.syngenta;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


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

        View aatrexView = new View(this);
        View atrazineView = new View(this);
        View bicepIIMagView = new View(this);
        View bicepIIMagFCView = new View(this);
        View bicepLiteView = new View(this);
        View boundaryView = new View(this);
        View dualIIMagView = new View(this);
        View flexstarView = new View(this);
        View halexView = new View(this);
        View lexarView = new View(this);
        View lumaxView = new View(this);
        View prefixView = new View(this);
        View princepView = new View(this);
        View sequenceView = new View(this);
        View tdtView = new View(this);
        View tdhtView = new View(this);

        switch (product){
            case 0:
                displayAatrex(aatrexView);
                break;
            case 1:
                displayAtrazine(atrazineView);
                break;
            case 2:
                displayBicepIIMagnum(bicepIIMagView);
                break;
            case 3:
                displayBicepIIMagnumFC(bicepIIMagFCView);
                break;
            case 4:
                displayBicepLiteIIMagnum(bicepLiteView);
                break;
            case 5:
                displayBoundary(boundaryView);
                break;
            case 6:
                displayDualIIMagnum(dualIIMagView);
                break;
            case 7:
                displayFlexstar(flexstarView);
                break;
            case 8:
                displayHalex(halexView);
                break;
            case 9:
                displayLexar(lexarView);
                break;
            case 10:
                displayLumax(lumaxView);
                break;
            case 11:
                displayPrefix(prefixView);
                break;
            case 12:
                displayPrincep(princepView);
                break;
            case 13:
                displaySequence(sequenceView);
                break;
            case 14:
                displayTouchdownHiTech(tdhtView);
                break;
            case 15:
                displayTouchdownTotal(tdtView);
                break;

        }

    }

    public void displayAatrex(View view){

        Intent aatrex = new Intent(this, Aatrex.class);
        startActivity(aatrex);

    }

    public void displayAtrazine(View view){

        Intent atrazine = new Intent(this, Atrazine.class);
        startActivity(atrazine);

    }

    public void displayBicepIIMagnum(View view){

        Intent bicep = new Intent(this, BicepIIMagnum.class);
        startActivity(bicep);

    }

    public void displayBicepIIMagnumFC(View view){

        Intent bicepFC = new Intent(this, BicepIIMagnumFC.class);
        startActivity(bicepFC);

    }

    public void displayBicepLiteIIMagnum(View view){

        Intent bicepLite = new Intent(this, BicepLiteIIMagnum.class);
        startActivity(bicepLite);

    }

    public void displayBoundary(View view){

        Intent boundary = new Intent(this, Boundary.class);
        startActivity(boundary);

    }

    public void displayDualIIMagnum(View view){

        Intent dual = new Intent(this, DualIIMagnum.class);
        startActivity(dual);

    }

    public void displayFlexstar(View view){

        Intent flexstar = new Intent(this, Flexstar.class);
        startActivity(flexstar);

    }

    public void displayHalex(View view){

        Intent halex = new Intent(this, Halex.class);
        startActivity(halex);

    }

    public void displayLexar(View view){

        Intent lexar = new Intent(this, Lexar.class);
        startActivity(lexar);

    }

    public void displayLumax(View view){

        Intent lumax = new Intent(this, Lumax.class);
        startActivity(lumax);

    }

    public void displayPrefix(View view){

        Intent prefix = new Intent(this, Prefix.class);
        startActivity(prefix);

    }

    public void displayPrincep(View view){

        Intent princep = new Intent(this, Princep.class);
        startActivity(princep);

    }

    public void displaySequence(View view){

        Intent sequence = new Intent(this, Sequence.class);
        startActivity(sequence);

    }

    public void displayTouchdownTotal(View view){

        Intent tdt = new Intent(this, TouchdownTotal.class);
        startActivity(tdt);

    }

    public void displayTouchdownHiTech(View view){

        Intent tdht = new Intent(this, TouchdownHitech.class);
        startActivity(tdht);

    }

}
