package com.pro.promark1;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.os.Binder;
import android.provider.Settings;

public class MyService extends Service {
    public MyService() {
    }




    //waste sevice






    private final IBinder bind = new MyLocaleBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return bind;
    }


    public class MyLocaleBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }




    public void startService(){
        AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        BluetoothAdapter b;
        b = BluetoothAdapter.getDefaultAdapter();
        WifiManager w = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo wi = w.getConnectionInfo();
        Context context = getBaseContext();
        ContentResolver cr = getContentResolver();
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
            if(i>=10){i=1;}
            //passCheck(i);


            //setting current settings

            Globals.gv.setW_wifi(wi.getBSSID());


            MyDBHandler dbhandler;
            dbhandler = new MyDBHandler(this, null ,null, 1);
            dbhandler.check(i);


            //doing actions
            if (Globals.gv.getBlue().equals("1")){

                b.enable();
            }
            else if (Globals.gv.getBlue().equals("0")){
                b.disable();
            }
           //Ringer
            if(Globals.gv.getRinger()!="555"){
                int in = Integer.valueOf(Globals.gv.getRinger());
                if(in>0 && in<=7 && audioManager.getStreamVolume(2)!=in){
                    audioManager.setStreamVolume(AudioManager.STREAM_RING,in,0);
                }

            }
            //Media
            if(Globals.gv.getMedia()!="555"){
                int in = Integer.valueOf(Globals.gv.getMedia());
                if(in>0 && in<=15 && audioManager.getStreamVolume(3)!=in){
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, in, 0);
                }
            }
            //wifi
            if(Globals.gv.getWifi().equals("1")){
                w.setWifiEnabled(true);
            }
            else if(Globals.gv.getWifi().equals("0")){
                w.setWifiEnabled(false);
            }
            //vibration
          /*  if(Globals.gv.getVibration().equals("1")){
                audioManager.setStreamVolume(AudioManager.STREAM_RING,0, AudioManager.FLAG_ALLOW_RINGER_MODES| AudioManager.FLAG_ALLOW_RINGER_MODES);
            }
            else if(Globals.gv.getVibration().equals("0")){
                audioManager.setStreamVolume(AudioManager.STREAM_RING,7, AudioManager.FLAG_ALLOW_RINGER_MODES| AudioManager.FLAG_ALLOW_RINGER_MODES);
            }*/
            //AUTO BRIGTNESS
            if(Globals.gv.getAutoBrightness().equals("1")){
                String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
                Settings.System.putInt(cr, SCREEN_BRIGHTNESS_MODE, 1);

            }
            else if(Globals.gv.getAutoBrightness().equals("0")){
                String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
                Settings.System.putInt(cr, SCREEN_BRIGHTNESS_MODE, 0);
            }






            Globals.gv.setDefault();
        }


    }

////waste service

}
