package com.pro.promark1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class CellTowerTrigger extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cell_tower_trigger);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cell_tower_trigger, menu);
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


    //Button
    public void onBdoneCellTowerTrigger(View view){
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        GsmCellLocation loc = (GsmCellLocation) tm.getCellLocation();
        Integer in = loc.getCid();
        String s = in.toString();
       // int doseNotHavewNetwork = 555;
      //  doseNotHavewNetwork = TelephonyManager.NETWORK_TYPE_UNKNOWN;

                // True if the phone is not connected to some type of network i.e. has signal
      //  if(doseNotHavewNetwork == 1){
      //      Toast.makeText(this, "Please make sure that phone has connected to carrier service.",Toast.LENGTH_LONG).show();
      //  }
        if(s.equals("")){
            Globals.p.setW_cellTower("555");
            Intent i = new Intent(this, WhenToDo.class);
            startActivity(i);
        }
        else{
            Globals.p.setW_cellTower(s);
         //   Toast.makeText(this, TelephonyManager.NETWORK_TYPE_UNKNOWN,Toast.LENGTH_LONG).show();

            Intent i = new Intent(this, WhenToDo.class);
            startActivity(i);
        }

    }
}
