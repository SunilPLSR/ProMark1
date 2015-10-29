package com.pro.promark1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class WhatToDo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_do);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_what_to_do, menu);
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


  /*  public void onBblueOn(View view){
        Globals.p.setBlue("1");
        //Intent i = new Intent(this, CreateProfile.class);
        //startActivity(i);
    }

    public void onBblueOff(View view){
        Globals.p.setBlue("0");
        //Intent i = new Intent(this, CreateProfile.class);
        //startActivity(i);
    }*/


    //Buttons
    public void onBblueOnWhatToDo(View view){
        Globals.p.setBlue("1");
    }
    public void onBblueOffWhatToDo(View view){
        Globals.p.setBlue("0");
    }
    public void onBwifiOnWhatToDo(View view){
        Globals.p.setWifi("1");
    }
    public void onBwifiOffWhatToDo(View view){
        Globals.p.setWifi("0");
    }

   /* public void onBvibrationOnWhatToDo(View view){
        Globals.p.setVibration("1");
    }
    public void onBvibrationOffWhatToDo(View view){
        Globals.p.setVibration("0");
    }*/
    public void onBautoBrightnessOnWhatToDo(View view){
        Globals.p.setAutoBrightness("1");
    }
    public void onBautoBrightnessOffWhatToDo(View view){
        Globals.p.setAutoBrightness("0");
    }


    public void onBdoneWhatToDo(View view){
        EditText e1,e2;
        e1 = (EditText) findViewById(R.id.ETringerVolumeWhatToDo);
       // e2 = (EditText) findViewById(R.id.ETmediaVolumeWhatToDo);

        if(e1.getText().toString().equals("")/*||e2.getText().toString().equals("")*/){
           // Globals.p.setRinger(e1.getText().toString());
          //  Globals.p.setMedia(e2.getText().toString());
            Globals.p.setRinger("555");
            Globals.p.setMedia("555");
        }
        else{
            Toast.makeText(this,"dd",Toast.LENGTH_LONG).show();
            Globals.p.setRinger(e1.getText().toString());
           // Globals.p.setMedia(e2.getText().toString());
        }



        Intent i = new Intent(this, CreateProfile.class);
        startActivity(i);

    }
}
