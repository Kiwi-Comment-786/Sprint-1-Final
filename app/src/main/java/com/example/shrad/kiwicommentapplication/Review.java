package com.example.shrad.kiwicommentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Review extends AppCompatActivity {

    Comments aComment;
    EditText commentPersonName, commentRating, commentContent;
    DatabaseHelper helper;
    String personName, rating,content;
    Comments comments;
    Button postbtn;
    String shop_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        helper = Search.helper;

        commentPersonName = (EditText) findViewById(R.id.nameTxt);
        commentRating = (EditText) findViewById(R.id.ratingsTxt);
        commentContent = (EditText) findViewById(R.id.reviewTxt);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        shop_id = bundle.getString("shop_id");
        postbtn =(Button) findViewById(R.id.postbtn);

    }

    public void readShop_ID(String ShopID){
        aComment.setShop_ID(ShopID);
    }

    public void onClicks(View v){
        switch (v.getId()) {
            case R.id.postbtn:
                personName = commentPersonName.getText().toString();
                rating = commentRating.getText().toString();
                content = commentContent.getText().toString();
                comments = new Comments(personName,Float.parseFloat(rating),content,shop_id);
                boolean insertedComment = helper.insertComment(comments);
                if(insertedComment==true) {
                    Toast.makeText(Review.this, "Comment posted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Review.this, "Comment Not posted", Toast.LENGTH_LONG).show();
                }

        }
    }
}
