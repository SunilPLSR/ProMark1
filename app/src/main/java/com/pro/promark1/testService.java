package com.pro.promark1;

import android.app.Activity;
import android.app.IntentService;
import android.app.Notification;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.widget.Toast;

/**
 * Created by Sunil on 2/26/2015.
 */
public class testService extends IntentService {

    public testService() {
        super("testService");
    }
    protected void onHandleIntent(Intent intent){


        NotificationCompat.Builder notification;
        notification = new NotificationCompat.Builder(this);
        startForeground(12346, notification.build());


        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        BluetoothAdapter b;
        b = BluetoothAdapter.getDefaultAdapter();
        WifiManager w = (WifiManager) getSystemService(getBaseContext().WIFI_SERVICE);
        WifiInfo wi = w.getConnectionInfo();
        Context context = getBaseContext();
        ContentResolver cr = getContentResolver();
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        GsmCellLocation loc = (GsmCellLocation) tm.getCellLocation();
        int i=1;
        while(1<2) {

            //premanent
            long future = System.currentTimeMillis() + 1000;
            while (System.currentTimeMillis() < future) {
                synchronized (this) {
                    try {
                        wait(future - System.currentTimeMillis());

                    } catch (Exception e) {
                    }
                }
            }
            //service code
            if(i>=10){
                i=1;
            }
            //passCheck(i);


            Globals.gv.setDefault();
            //setting current settings

            //if wifi not enabled
            if (w.isWifiEnabled() == false){
                Globals.gv.setW_wifi("5");
            }   //wifi enabled nut not connected
            else if (w.isWifiEnabled() == true){
                if (wi.getBSSID().equals("")){
                    Globals.gv.setW_wifi("5");
                }
                else{//wifi enabled and connected to n/w
                    Globals.gv.setW_wifi(wi.getBSSID());
                }
            }
           // Integer in = loc.getCid();
           // String s = in.toString();
           // Globals.gv.setW_cellTower(s);



            MyDBHandler dbhandler;
            dbhandler = new MyDBHandler(this, null ,null, 1);
            dbhandler.check(i);
            i++;






            //doing actions
            if (Globals.gv.getBlue().equals("1")){

                b.enable();
            }
            else if (Globals.gv.getBlue().equals("0")){
                b.disable();
            }
            //Ringer
            if(Globals.gv.getRinger()!="555" && Globals.gv.getRinger()!="null" && Globals.gv.getRinger()!="NULL"){
                int in = Integer.valueOf(Globals.gv.getRinger());
                if( in == 0){
                    audioManager.setRingerMode(audioManager.RINGER_MODE_VIBRATE);
    //Toast.makeText(this,"vibration is activaed",Toast.LENGTH_LONG).show();

                }

                if(in>0 && in<=7 && audioManager.getStreamVolume(audioManager.STREAM_RING)!=in){
                    audioManager.setStreamVolume(AudioManager.STREAM_RING,in,0);
                }

            }
            //Media
           /* if(Globals.gv.getMedia()!="555" &&Globals.gv.getMedia()!="null" && Globals.gv.getMedia()!="NULL"){
                Toast.makeText(this, Globals.gv.getMedia(),Toast.LENGTH_LONG);
                int in = Integer.valueOf(Globals.gv.getMedia());
                if(in>0 && in<=15 && audioManager.getStreamVolume(audioManager.STREAM_MUSIC)!=in){
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, in, 0);
                }
            }*/
            //wifi
            if(Globals.gv.getWifi().equals("1")){
                w.setWifiEnabled(true);
      Toast.makeText(this,"wifi is enabled",Toast.LENGTH_LONG).show();

            }
            else if(Globals.gv.getWifi().equals("0")){
                w.setWifiEnabled(false);
      Toast.makeText(this,"wifi is disabled",Toast.LENGTH_LONG).show();
            }
            //vibration
           /*if(Globals.gv.getVibration()!="555" && Globals.gv.getVibration()!="null" && Globals.gv.getVibration()!="NULL"){
                int in = Integer.valueOf(Globals.gv.getVibration());
                if( in != audioManager.getRingerMode()){
                    audioManager.setRingerMode(audioManager.RINGER_MODE_VIBRATE);
                }
                //audioManager.setStreamVolume(AudioManager.STREAM_RING,0, AudioManager.FLAG_VIBRATE| AudioManager.FLAG_ALLOW_RINGER_MODES);
            }
            else if(Globals.gv.getVibration().equals("0")){
                audioManager.setStreamVolume(AudioManager.STREAM_RING,7, AudioManager.FLAG_PLAY_SOUND| AudioManager.FLAG_ALLOW_RINGER_MODES);
            }*/
            //AUTO BRIGTNESS
            if(Globals.gv.getAutoBrightness().equals("1")){
                String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
                Settings.System.putInt(cr, SCREEN_BRIGHTNESS_MODE, 1);
       //Toast.makeText(this,"auto brightness.....",Toast.LENGTH_LONG).show();
            }
            else if(Globals.gv.getAutoBrightness().equals("0")){
                String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
                Settings.System.putInt(cr, SCREEN_BRIGHTNESS_MODE, 0);
            }






            Globals.gv.setDefault();
        }

    }
}
