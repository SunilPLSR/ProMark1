package com.pro.promark1;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.content.BroadcastReceiver;


import com.pro.promark1.MyService.MyLocaleBinder;


public class MainActivity extends ActionBarActivity {

    //MyService m;
    Handler handler = new Handler(){

        public void handleMessage(Message msg){
            super.handleMessage(msg);
        }

    };
    //headphone
    public Headphonejack headphonejack;


    //db handler for headphones
    public MyDBHandler dbHandler;




    //battery
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context arg0, Intent intent) {
            // TODO Auto-generated method stub
            int level = intent.getIntExtra("level", 0);
            //contentTxt.setText(String.valueOf(level) + "%");
            Globals.bat.setLevel(level);
        }
    };


    //Notification
    NotificationCompat.Builder notification;
    final int unique_id=12345;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //service
        //Intent i = new Intent(this,MyService.class);
        //bindService(i, s, Context.BIND_AUTO_CREATE);


        Intent intent = new Intent(this, testService.class);
        startService(intent);
       // Globals.gv.setW_wifi("5");
       // Globals.gv.setBlue("5");
       // Globals.gv.setName("5");
        Globals.gv.setDefault();

        //headphone
        headphonejack = new Headphonejack();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        registerReceiver(headphonejack, intentFilter);



        //battery
        this.registerReceiver(this.mBatInfoReceiver,
                new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        //Integer batter= Globals.bat.getLevel();
        //Toast.makeText(this, batter.toString(),Toast.LENGTH_LONG).show();


        //notification
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(false);

        notification.setSmallIcon(R.drawable.abc_ab_share_pack_holo_light);
        notification.setTicker("tick");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("title");
        notification.setContentText("TEXT");

        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pi);


        //bulds notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(12345, notification.build());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(headphonejack);
        unregisterReceiver(mBatInfoReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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



    //headphones class
    public class Headphonejack extends BroadcastReceiver {

        @Override

        public void onReceive(Context context, Intent intent) {

            if (!intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {

                return;

            }


            boolean connectedHeadphones = (intent.getIntExtra("state", 0) == 1);

            //boolean connectedMicrophone = (intent.getIntExtra("microphone", 0) == 1) && connectedHeadphones;

            //String headsetName = intent.getStringExtra("name");

            if(connectedHeadphones)
            {

                Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.music");
                startActivity(LaunchIntent);


            }




        }

    }


   /* public static int getBattery(){

        if (rawlevel >= 0 && scale > 0) {
            level = rawlevel / scale * 100;

        }
        int battPercent = (int) level;
    }
*/



    //Buttons
    public void onBnewProfile(View view){
        Intent i = new Intent(this, NameProfile.class);
        startActivity(i);
        Globals.p.setDefault();

    }
    public void onBeditProfile(View view){
        Intent i = new Intent(this, EditProfile.class);
        startActivity(i);
    }














   /* //BoundServiceCode
    private ServiceConnection s = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocaleBinder bin = (MyLocaleBinder) service;
            m = bin.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };*/








}
