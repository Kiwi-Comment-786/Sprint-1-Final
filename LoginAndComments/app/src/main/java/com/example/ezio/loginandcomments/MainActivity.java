package com.example.ezio.loginandcomments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);

    Button LoginButton;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.LoginButton)
        {
            EditText a = (EditText)findViewById(R.id.editAccount);
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.editPass);
            String pass = b.getText().toString();

            String password = helper.login(str);
            if(pass.equals(password))
            {
                //Intent i = new Intent(this, Register.class);
               // i.putExtra("Account", str);
                //startActivity(i);
            }
            else
            {
                Toast temp = Toast.makeText(MainActivity.this,"Account doesn't match!", Toast.LENGTH_SHORT);
                temp.show();
            }
        }

        if(v.getId() == R.id.Register)
        {
            Intent i = new Intent(this, Register.class);
            startActivity(i);
        }
    }


}
