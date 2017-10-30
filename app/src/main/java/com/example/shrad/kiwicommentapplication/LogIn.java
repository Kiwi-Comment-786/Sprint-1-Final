package com.example.shrad.kiwicommentapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    DatabaseHelper helper = WelcomePage.myDb;
    static String username,passwords;
    static String successLogInShopId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    //button methoed
    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.LoginButton)
        {
            EditText a = (EditText)findViewById(R.id.editAccount);
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.editPass);
            String pass = b.getText().toString();

            String password = helper.login(str);
            username=str;
            passwords=password;
            if(pass.equals(password))
            {
                Intent i = new Intent(LogIn.this, UpdateShopDetails.class);
                i.putExtra("Account", str);
                successLogInShopId=DatabaseHelper.loginShopId;
                startActivity(i);
            }
            else
            {
                Toast.makeText(LogIn.this,"Account doesn't exist!", Toast.LENGTH_SHORT).show();

            }
        }

        if(v.getId() == R.id.Register)
        {
            Intent i = new Intent(LogIn.this, ShopDetailSignUpForm.class);
            startActivity(i);
        }
    }

    private String shopID(String userName, String password){
        Cursor shop_id=helper.shopID(userName,password);
        String shopid="";
        while(shop_id.moveToNext()){
            shopid=shop_id.getString(0);
        }
        return shopid;
    }
}
