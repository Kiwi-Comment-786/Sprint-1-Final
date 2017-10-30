package com.example.shrad.kiwicommentapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchTwo extends AppCompatActivity {

    private TextView nametv;
    private TextView address;
    private TextView phonetv;
    private TextView netlink;
    private TextView ratings;
    Button writeReview;
    DatabaseHelper myDb;
    String ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_two);
        myDb = WelcomePage.myDb;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ids = bundle.getString("shop_id");


        nametv = (TextView) findViewById(R.id.name);
        address = (TextView) findViewById(R.id.address);
        phonetv = (TextView) findViewById(R.id.phonenumber);
        netlink = (TextView) findViewById(R.id.netlink);
        ratings = (TextView) findViewById(R.id.ratingsTxtView);
        writeReview = (Button) findViewById(R.id.writeReview);

        final ArrayList<Information> list = WelcomePage.getSpecificShopDetail(ids);

        String str = "Name: " + list.get(0).getName();
        nametv.setText(str);
        str = "Address: " + list.get(0).getStreetAddress();
        address.setText(str);
        str = "Phone number: " + list.get(0).getPhonenumber();
        phonetv.setText(str);
        str = "Website address: " + list.get(0).getNetlink();
        netlink.setText(str);
        str = "Ratings: " + list.get(0).getRatings();
        ratings.setText(str);

        Button webview = (Button) findViewById(R.id.wbtn);
        webview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });

        Button vistiWebsitebtn = (Button) findViewById(R.id.visitWebsitebtn);
        webview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://"+list.get(0).getNetlink()); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button sharebtn = (Button) findViewById(R.id.sharebtn);
        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hey, Check this out:\n http://"+list.get(0).getNetlink();
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        Button callbtn = (Button) findViewById(R.id.phnbtn);
        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+list.get(0).getPhonenumber()));
                startActivity(callIntent);
            }
        });
        Button btnMapActivity=(Button) findViewById(R.id.getDirectionbtn);
        btnMapActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMapAcitivity();
            }
        });

        Button btnReviewActivity=(Button) findViewById(R.id.writeReview);
        btnReviewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("shop_id",ids);
                Intent intent = new Intent(getApplicationContext(),Review.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    public void openMapAcitivity(){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }

    public void openReviewAcitivity(){
        Bundle bundle = new Bundle();
        bundle.putString("shop_id",ids);
        Intent intent = new Intent(this,Review.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goToUrl(String addres){
        Uri uri = Uri.parse(addres); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
