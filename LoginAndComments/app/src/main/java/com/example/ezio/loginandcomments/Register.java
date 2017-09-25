package com.example.ezio.loginandcomments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onClick(View v)
    {
        if(v.getId() == R.id.okButton)
        {
            EditText Account = (EditText)findViewById(R.id.editAccount);
            EditText FN = (EditText)findViewById(R.id.editFN);
            EditText LN = (EditText)findViewById(R.id.editLN);
            EditText mobilNumber = (EditText)findViewById(R.id.editMN);
            EditText email = (EditText)findViewById(R.id.editEA);
            EditText pass = (EditText)findViewById(R.id.editPass);

            String accountStr = Account.getText().toString();
            String FNstr = FN.getText().toString();
            String LNstr = LN.getText().toString();
            String MNstr = mobilNumber.getText().toString();
            String EAstr = email.getText().toString();
            String passStr = pass.getText().toString();

            ShopOnwer shopOnwer = new ShopOnwer(0);
            shopOnwer.setAccountNumber(accountStr);
            shopOnwer.setFirstName(FNstr);
            shopOnwer.setLastName(LNstr);
            shopOnwer.setMobileNumber(MNstr);
            shopOnwer.setEmaild(EAstr);
            shopOnwer.setPassword(passStr);

            helper.insertContact(shopOnwer);

            Intent i = new Intent(Register.this, MainActivity.class);
            startActivity(i);
        }

        if(v.getId() == R.id.Back)
        {
            Intent i = new Intent(Register.this, MainActivity.class);
            startActivity(i);
        }
    }
}
