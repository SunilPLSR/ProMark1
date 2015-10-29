package com.pro.promark1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class NameProfile extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_profile);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_name_profile, menu);
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
    public void onBdoneNewProfile(View view){
        EditText t = (EditText) findViewById(R.id.ETnameNameProfile);
        if(t.getText().toString().equals("")){
            Globals.cons.setName("555");
            Toast.makeText(this,"profile name saved",Toast.LENGTH_LONG).show();
        }
        else{
            Globals.cons.setName(t.getText().toString());
            Toast.makeText(this,"profile name saved",Toast.LENGTH_LONG).show();

        }
        Intent i = new Intent(this, CreateProfile.class);
        startActivity(i);
    }
}
