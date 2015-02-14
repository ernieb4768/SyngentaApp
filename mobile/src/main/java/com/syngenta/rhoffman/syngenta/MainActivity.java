package com.syngenta.rhoffman.syngenta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){

            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            case R.id.action_help:
                openHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    // A place holder until I get search functionality enabled... If I ever learn how to do that.
    public boolean openSearch(){
        return true;
    }

    // Another place holder for the settings. I may add a generic settings activity and see if I can
    // customize it a little so it won't look too bad.
    public void openSettings(){

        Intent startSearch = new Intent(this, Settings.class);
        startActivity(startSearch);

    }

    // The only one that will work for now. It starts an Intent to open the Help activity.
    public void openHelp(){

        Intent helpIntent = new Intent(this, Help.class);
        startActivity(helpIntent);

    }

    public void startProductWeight(View view){

        Intent intent1 = new Intent(this, ProductWeightInfo.class);

        startActivity(intent1);
    }

}
