package com.example.ezio.loginandcomments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Review extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
    }

    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.Update_Button)
        {
            EditText a = (EditText)findViewById(R.id.editComment);
            String str = a.getText().toString();




        }

    }
}
