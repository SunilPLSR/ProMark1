package com.pro.promark1;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CreateProfile extends ActionBarActivity {


    //EditText t1 = (EditText) findViewById(R.id.ETnameProfileCreateProfile);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        TextView t = (TextView) findViewById(R.id.TVheadingCreateProfile);
        t.setText(Globals.cons.getName());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_profile, menu);
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

    @Override
    protected void onResume() {
        super.onResume();
        TextView t = (TextView) findViewById(R.id.TVheadingCreateProfile);
        t.setText(Globals.cons.getName());
    }

    public void onBwhenToDo(View view){
       // EditText t = (EditText) findViewById(R.id.ETnameProfileCreateProfile);
       // Globals.p.setName(t.getText().toString());
        Intent i = new Intent(this, WhenToDo.class);
        startActivity(i);

    }


    public void onBwhatToDo(View view){

        Intent i = new Intent(this, WhatToDo.class);
        startActivity(i);
    }

    public void onBcreateProfile(View view){


        //setting default values
        if(Globals.p.getBlue().equals("")){Globals.p.setBlue("555");}
        //if(Globals.p.getMedia().equals("")){Globals.p.setMedia("555");}
        if(Globals.p.getName().equals("")){Globals.p.setName("555");}
        if(Globals.p.getWifi().equals("")){Globals.p.setWifi("555");}
        if(Globals.p.getRinger().equals("")){Globals.p.setRinger("555");}
        if(Globals.p.getAutoBrightness().equals("")){Globals.p.setAutoBrightness("555");}
        if(Globals.p.getW_battFrom().equals("")){Globals.p.setW_battFrom("555");}
        if(Globals.p.getW_battTo().equals("")){Globals.p.setW_battTo("555");}
        if(Globals.p.getW_wifi().equals("")){Globals.p.setWifi("555");}
        if(Globals.p.getW_cellTower().equals("")){Globals.p.setW_cellTower("555");}
        if(Globals.p.getW_timeHrsFrom().equals("")){Globals.p.setW_timeHrsFrom("555");}
        if(Globals.p.getW_timeMinFrom().equals("")){Globals.p.setW_timeMinFrom("555");}

        if(Globals.p.getW_timeHrsTo().equals("")){Globals.p.setW_timeHrsTo("555");}
        if(Globals.p.getW_timeMinTo().equals("")){Globals.p.setW_timeMinTo("555");}



        Toast.makeText(getApplicationContext(),"o",Toast.LENGTH_SHORT).show();
        MyDBHandler dbhandler;
        dbhandler = new MyDBHandler(this, null ,null, 1);
        Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
        dbhandler.addProduct();
        Toast.makeText(getApplicationContext(),"okk",Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
}
