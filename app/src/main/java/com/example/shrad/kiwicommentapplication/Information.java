package com.example.shrad.kiwicommentapplication;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by shrad on 23/10/2017.
 */

public class Information implements Serializable {

    public static ArrayList<Information> shopList;
    private String name;
    private static String addresss;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    private String streetAddress;
    private String phonenumber;
    private String netlink;
    private String id;
    private float ratings;
    private String placeType;
    private LatLng latLng;

    public Information(String id,String name, String addresss, String phonenumber,String netlink,
                       String placeType,
                       float ratings, LatLng latLng){
        this.id=id;
        this.name=name;
        this.addresss=addresss;
        this.phonenumber=phonenumber;
        this.netlink=netlink;
        this.placeType=placeType;
        this.latLng = latLng;
        this.streetAddress=addresss;
        this.ratings=ratings;
    }

    public Information(String name, String shopPhonno, String netlink, float ratings, String id){
        this.name = name;
        this.phonenumber=shopPhonno;
        this.netlink=netlink;
        this.ratings=ratings;
        this.id=id;
    }

    public Information(String name, String shopPhonno, String netlink, String address,float ratings){
        this.name = name;
        this.phonenumber=shopPhonno;
        this.netlink=netlink;
        this.streetAddress=address;
        this.ratings=ratings;
//        this.id=id;
    }

    public Information(String name, String addresss,String shopPhonno){
        this.name = name;
        this.phonenumber=shopPhonno;
        this.streetAddress=addresss;
    }

    public Information(){
        this.name="StarBucks";
        this.addresss= "Westgate Shopping Centre, 2-20 Fernhill Drive, Auckland 0614";
        this.phonenumber="09-832 8541";
    }


    public static String getAddresss() {
        return addresss;
    }

    public static void setAddresss(String addresss) {
        Information.addresss = addresss;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getNetlink() {
        return netlink;
    }

    public void setNetlink(String netlink) {
        this.netlink = netlink;
    }

    public String getId() { return id;}

    public void setId(String id) {
        this.id = id;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

