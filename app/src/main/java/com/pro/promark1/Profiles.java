package com.pro.promark1;

/**
 * Created by Sunil on 2/25/2015.
 */
public class Profiles {

    String name,w_wifi,w_cellTower,w_timeHrsFrom,w_timeMinFrom,w_timeHrsTo,w_timeMinTo,w_battFrom,w_battTo,wifi,ringer,media,vibration,brightness,autoBrightness,blue,_id;

    public Profiles() {
    }



    public void setName(String name) {
        this.name = name;
    }



    public void setW_wifi(String w_wifi) {
        this.w_wifi = w_wifi;
    }



    public void setBlue(String blue) {
        this.blue = blue;
    }



    public void set_id(String _id) {
        this._id = _id;
    }



    public void setW_cellTower(String w_cellTower) {
        this.w_cellTower = w_cellTower;
    }




    public void setW_battFrom(String w_battFrom) {
        this.w_battFrom = w_battFrom;
    }


    public void setW_battTo(String w_battTo) {
        this.w_battTo = w_battTo;
    }



    public void setWifi(String wifi) {
        this.wifi = wifi;
    }


    public void setRinger(String ringer) {
        this.ringer = ringer;
    }



    public void setMedia(String media) {
        this.media = media;
    }



    public void setVibration(String vibration) {
        this.vibration = vibration;
    }



    public void setBrightness(String brightness) {
        this.brightness = brightness;
    }



    public void setAutoBrightness(String autoBrightness) {
        this.autoBrightness = autoBrightness;
    }

    public void setDefault(){
        this.w_battFrom=this.w_timeHrsFrom=this.w_timeHrsTo=this.w_timeMinFrom=this.w_timeMinTo=this.w_battTo=this.w_cellTower=this.w_wifi=this.name=this.wifi=this.ringer=this.vibration=this.brightness=this.autoBrightness=this.blue="555";
    }

    public String getName() {
        return name;
    }

    public String getW_wifi() {

            return w_wifi;


    }

    public String getW_cellTower() {
        return w_cellTower;
    }

    public String getW_battFrom() {
        return w_battFrom;
    }

    public String getW_battTo() {
        return w_battTo;
    }

    public String getWifi() {
        return wifi;
    }

    public String getRinger() {
        return ringer;
    }

    public String getMedia() {
        return media;
    }

    public String getVibration() {
        return vibration;
    }

    public String getBrightness() {
        return brightness;
    }

    public String getAutoBrightness() {
        return autoBrightness;
    }

    public String getBlue() {
        return blue;
    }

    public String get_id() {
        return _id;
    }

    public String getW_timeHrsFrom() {
        return w_timeHrsFrom;
    }

    public void setW_timeHrsFrom(String w_timeHrsFrom) {
        this.w_timeHrsFrom = w_timeHrsFrom;
    }

    public String getW_timeMinFrom() {
        return w_timeMinFrom;
    }

    public void setW_timeMinFrom(String w_timeMinFrom) {
        this.w_timeMinFrom = w_timeMinFrom;
    }

    public String getW_timeHrsTo() {
        return w_timeHrsTo;
    }

    public void setW_timeHrsTo(String w_timeHrsTo) {
        this.w_timeHrsTo = w_timeHrsTo;
    }

    public String getW_timeMinTo() {
        return w_timeMinTo;
    }

    public void setW_timeMinTo(String w_timeMinTo) {
        this.w_timeMinTo = w_timeMinTo;
    }



}


