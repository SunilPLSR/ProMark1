package com.pro.promark1;

import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Sunil on 2/25/2015.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABSE_VERSION = 1;
    //public static final String COLUMN_NAME = "name";
   // public static final String COLUMN_WIFI = "w_wifi";
   // public static final String COLUMN_BLUE = "blue";
   // public static final String COLUMN_ID = "_id";
    private static final String DATABASE_NAME = "profiles.db";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABSE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE profile(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "W_WIFI TEXT," +
                "W_CELLTOWER TEXT," +
                "W_TIMEHRSFROM TEXT," +
                "W_TIMEMINFROM TEXT," +
                "W_TIMEHRSTO TEXT," +
                "W_TIMEMINTO TEXT," +
                "W_BATTFROM TEXT," +
                "W_BATTTO TEXT," +
                "BLUETOOTH TEXT," +
                "WIFI TEXT," +
                "MEDIA TEXT," +
                "RINGER TEXT," +
                "VIBRATION TEXT," +
                "AUTO_BRIGHTNESS TEXT);";

        //String query2 = "CREATE TABLE PRODUCTS(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PRODUCTNAME +" TEXT);";
        db.execSQL(query);



        //for default values
        ContentValues Values = new ContentValues();
        Values.put("NAME", "NULL");
        Values.put("W_WIFI", "555");
        Values.put("W_CELLTOWER", "5");
        Values.put("W_TIMEHRSFROM", "555");
        Values.put("W_TIMEMINFROM", "555");
        Values.put("W_TIMEHRSTO", "555");
        Values.put("W_TIMEMINTO", "555");
        Values.put("W_BATTFROM", "555");
        Values.put("W_BATTTO", "555");
        Values.put("BLUETOOTH", "555");
        Values.put("WIFI", "NULL");
        Values.put("MEDIA", "555");
        Values.put("RINGER", "555");
        Values.put("VIBRATION", "555");
        Values.put("AUTO_BRIGHTNESS", "55");

        //SQLiteDatabase db = getWritableDatabase();
        db.insert("profile", null, Values);
        //db.close();
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS profile");
        onCreate(db);
    }


    public void addProduct(){
        ContentValues Values = new ContentValues();


        Values.put("NAME", Globals.cons.getName());
        Values.put("W_WIFI", Globals.p.getW_wifi());
        Values.put("W_CELLTOWER", Globals.p.getW_cellTower());
        Values.put("W_TIMEHRSFROM", Globals.p.getW_timeHrsFrom());
        Values.put("W_TIMEMINFROM", Globals.p.getW_timeMinFrom());

        Values.put("W_TIMEHRSTO", Globals.p.getW_timeHrsTo());
        Values.put("W_TIMEMINTO", Globals.p.getW_timeMinTo());

        Values.put("W_BATTFROM", Globals.p.getW_battFrom());
        Values.put("W_BATTTO", Globals.p.getW_battTo());
        Values.put("BLUETOOTH", Globals.p.getBlue());
        Values.put("WIFI", Globals.p.getWifi());
        Values.put("MEDIA", Globals.p.getMedia());
        Values.put("RINGER", Globals.p.getRinger());
        Values.put("VIBRATION", Globals.p.getVibration());
        Values.put("AUTO_BRIGHTNESS", Globals.p.getAutoBrightness());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("profile", null, Values);
        db.close();



        //setting defaut values
        Globals.p.setDefault();
       /* SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO PRODUCTS VALUES (" + product.get_id() + "," + product.get_productname() + ");");*/

    }


    //function to gett configured headphones app
    public String getApp(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT blue FROM profiles where _id=1", null);
        c.moveToFirst();
        return c.getString(c.getColumnIndex("W_CELLTOWER"));

    }

    //function to set configured headphones app
    public void setApp(String s){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE profiles SET W_CELLTOWER='"+s+"' WHERE _id=1");

    }



    //function to get available profile names
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM profile WHERE 1;";

        //CURSOR point to the location in your result
        Cursor c = db.rawQuery(query, null);
        //move to the 1st row in ressult
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("NAME"))!= null){
                dbString += c.getString(c.getColumnIndex("NAME"));
                dbString += "\n";
                c.moveToNext();


            }
        }
        db.close();
        return dbString;
    }


    //delete profile
    public void deleteProfile(String productname){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM profile WHERE NAME=\"" + productname + "\";");


    }


   /* public int check(int n){
        SQLiteDatabase db = getWritableDatabase();
        String q = "SELECT blue FROM profile WHERE _id="+n;

    }*/

    //public String get
    /*public Cursor returnData()
    {
        SQLiteDatabase db = getWritableDatabase();
        return db.query("profile", new String[] {COLUMN_WIFI,COLUMN_BLUE}, null,null ,null, null, null);

    }*/
    public void check(int i){

        SQLiteDatabase db = getWritableDatabase();






        String query = "SELECT * FROM profile;";
        Cursor c = db.rawQuery(query, null);

               // Log.d(TAG,c.getString(c.getColumnIndex("w_wifi"));
        c.moveToFirst();
        c.moveToNext();
        while(!c.isAfterLast()){
            //code to compare time
            Integer hrsFrom,minFrom,hrsTo,minTo;
            Boolean time = false;
            Boolean battery = false;
            hrsFrom = Integer.parseInt(c.getString(c.getColumnIndex("W_TIMEHRSFROM")));
            minFrom = Integer.parseInt(c.getString(c.getColumnIndex("W_TIMEMINFROM")));
            hrsTo = Integer.parseInt(c.getString(c.getColumnIndex("W_TIMEHRSTO")));
            minTo = Integer.parseInt(c.getString(c.getColumnIndex("W_TIMEMINTO")));
            if(hrsFrom!=555 && minFrom!=555 && hrsTo!=555 && minTo!=555){
                final Calendar cal = Calendar.getInstance();
                Integer mHour = cal.get(Calendar.HOUR_OF_DAY);
                Integer mMinute = cal.get(Calendar.MINUTE);
                if(hrsFrom<mHour && mHour<hrsTo){
                    time =true;
                }
                else if(hrsFrom.equals(mHour)){
                    if(minFrom<=mMinute){
                        time=true;
                    }
                }
                else if(hrsTo.equals(mHour)){
                    if(mMinute<=minTo){
                        time=true;
                    }
                }
            }
            if(hrsFrom==555 || minFrom==555 || hrsTo==555 || minTo==555){
                time =true;
            }


            //Battery Checking
           /* Integer battFrom = Integer.parseInt(c.getString(c.getColumnIndex("W_BATTFROM")));
            Integer battTo = Integer.parseInt(c.getString(c.getColumnIndex("W_BATTTO")));
            int batt = MainActivity.getBattery();*/
            Boolean batteryCheck = false;
            Integer batFrom,batTo;
            batFrom = Integer.parseInt(c.getString(c.getColumnIndex("W_BATTFROM")));
            batTo = Integer.parseInt(c.getString(c.getColumnIndex("W_BATTTO")));
            if(Globals.bat.getLevel()!=0){
                if(batFrom!=555 && batTo!=555){
                    if(batFrom <= Globals.bat.getLevel() && Globals.bat.getLevel()<= batTo){
                        batteryCheck = true;
                    }
                }
                if(batFrom == 555  &&  batTo == 555){
                    batteryCheck = true;
                }
            }








           // if()


            if(((c.getString(c.getColumnIndex("W_WIFI"))!= "555") || c.getString(c.getColumnIndex("W_WIFI")).equals(Globals.gv.getW_wifi()))    &&      ((c.getString(c.getColumnIndex("W_CELLTOWER"))!= "555") || c.getString(c.getColumnIndex("W_CELLTOWER")).equals(Globals.gv.getW_cellTower()))    &&   time   &&  batteryCheck){
               //IF TRIGGERS MEET THEN ACTIONS ARE SET
                Globals.gv.setBlue(c.getString(c.getColumnIndex("BLUETOOTH")));
                Globals.gv.setRinger(c.getString(c.getColumnIndex("RINGER")));
                Globals.gv.setMedia(c.getString(c.getColumnIndex("MEDIA")));
                Globals.gv.setWifi(c.getString(c.getColumnIndex("WIFI")));
                Globals.gv.setVibration(c.getString(c.getColumnIndex("VIBRATION")));
                Globals.gv.setAutoBrightness(c.getString(c.getColumnIndex("AUTO_BRIGHTNESS")));
                }
                else{//IF TRIGGERS DISNOT MEET
                Globals.gv.setBlue("555");
                Globals.gv.setRinger("555");
                Globals.gv.setMedia("555");
                Globals.gv.setWifi("555");
                Globals.gv.setVibration("555");
                Globals.gv.setAutoBrightness("555");
                }

            c.moveToNext();
        }




    }




}
