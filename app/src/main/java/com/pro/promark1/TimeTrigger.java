package com.pro.promark1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class TimeTrigger extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_trigger);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_time_trigger, menu);
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

    public void onBdoneTimeTrigger(View view){
        EditText e1,e2,e3,e4;
        e1 = (EditText) findViewById(R.id.ETfromHrsTimeTrigger);

        e2 = (EditText) findViewById(R.id.ETfromMinTimeTrigger);

        e3 = (EditText) findViewById(R.id.ETtoHrsTimeTrigger);

        e4 = (EditText) findViewById(R.id.ETtoMinTimeTrigger);

        if(e1.getText().toString().equals("")||e2.getText().toString().equals("")||e3.getText().toString().equals("")||e4.getText().toString().equals("")){
            Globals.p.setW_timeHrsFrom("555");
            Globals.p.setW_timeHrsTo("555");
            Globals.p.setW_timeMinFrom("555");
            Globals.p.setW_timeMinTo("555");
        }
        else{
            Globals.p.setW_timeHrsFrom(e1.getText().toString());
            Globals.p.setW_timeMinFrom(e2.getText().toString());
            Globals.p.setW_timeHrsTo(e3.getText().toString());
            Globals.p.setW_timeMinTo(e4.getText().toString());
        }



        Intent i = new Intent(this, WhenToDo.class);
        startActivity(i);
    }
}
