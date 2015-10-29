package com.pro.promark1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class BatteryTrigger extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_trigger);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_battery_trigger, menu);
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
    public void onBdoneBattreyTrigger(View view){
        EditText e1,e2;
        e1 = (EditText) findViewById(R.id.ETfromBatteryTrigger);
        e2 = (EditText) findViewById(R.id.ETtoBatteryTrigger);
        if((e1.getText().toString().equals(""))||(e2.getText().toString().equals(""))){
            Globals.p.setW_battFrom("555");
            Globals.p.setW_battTo("555");
        }
        else{
            Globals.p.setW_battFrom(e1.getText().toString());
            Globals.p.setW_battTo(e2.getText().toString());
        }



        Intent i = new Intent(this, WhenToDo.class);
        startActivity(i);

    }
}
