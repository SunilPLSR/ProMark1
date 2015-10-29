package com.pro.promark1;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class WiFiTrigger extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_trigger);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wi_fi_trigger, menu);
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


    public void onBdone(View view){
        WifiManager w = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo wi = w.getConnectionInfo();

        if(!w.isWifiEnabled()){
            Toast.makeText(this, "Please connect to a WiFi network and try again.",Toast.LENGTH_SHORT).show();
        }

        else if(wi.getBSSID().toString().equals("")){
            Globals.p.setW_wifi("555");
            Intent i = new Intent(this, WhenToDo.class);
            startActivity(i);
        }
        else{
            Globals.p.setW_wifi(wi.getBSSID().toString());
            Intent i = new Intent(this, WhenToDo.class);
            startActivity(i);
        }



    }
}
