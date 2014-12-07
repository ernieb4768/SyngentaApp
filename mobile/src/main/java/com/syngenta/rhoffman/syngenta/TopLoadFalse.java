package com.syngenta.rhoffman.syngenta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class TopLoadFalse extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_load_false);

        Intent topLoadFalse = getIntent();
        String previousProduct = topLoadFalse.getStringExtra("PREVIOUS_PRODUCT");
        String nextProduct = topLoadFalse.getStringExtra("NEXT_PRODUCT");

        TextView textView = new TextView(this);
        textView.setText(nextProduct + " can't be top loaded on " + previousProduct + ".");
        setContentView(textView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top_load_false, menu);
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
