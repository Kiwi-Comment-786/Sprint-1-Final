package com.example.ezio.loginandcomments;

/**
 * Created by Ezio on 11/09/2017.
 */

public abstract class Users {

    private int userID;

    public Users(int userID){
        this.userID = userID;
    }

    public int getUserID(){
        return userID;
    }

    public void setUserID(int ID){
        this.userID = ID;
    }


}
