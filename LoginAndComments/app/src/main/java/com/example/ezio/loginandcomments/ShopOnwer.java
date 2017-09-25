package com.example.ezio.loginandcomments;

/**
 * Created by Ezio on 11/09/2017.
 */

public class ShopOnwer extends Users {

    private String accountNumber;
    private String password;

    private String firstName;
    private String lastName;
    private String MobileNumber;
    private String Emaild;

    public ShopOnwer(int ID){
        super(ID);
    }

    @Override
    public int getUserID() {
        return super.getUserID();
    }

    @Override
    public void setUserID(int ID) {
        super.setUserID(ID);
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setMobileNumber(String mobileNumber){
        this.MobileNumber = mobileNumber;
    }

    public void setEmaild(String emaild){
        this.Emaild = emaild;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getPassword(){
        return password;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getMobileNumber(){
        return MobileNumber;
    }

    public String getEmaild(){
        return Emaild;
    }


}
