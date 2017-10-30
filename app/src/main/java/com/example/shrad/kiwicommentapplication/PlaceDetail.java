package com.example.shrad.kiwicommentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.List;
import java.util.Random;

public class PlaceDetail extends AppCompatActivity {

    private  final int REQUEST_CODE_PLACEPIKER=1;
    DatabaseHelper myDb;
    static Information info=new Information();
    static String addressDirection="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);
        myDb=WelcomePage.myDb;

        Button goBtn = (Button) findViewById(R.id.buttonGo);
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPlacePicketActivity();
            }
        });

    }

    private void startPlacePicketActivity(){
        PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
        try{
            Intent intent=intentBuilder.build(this);
            startActivityForResult(intent,REQUEST_CODE_PLACEPIKER);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==REQUEST_CODE_PLACEPIKER && resultCode==RESULT_OK){
            displaySelectedPlacefromPlacePicker(data);
        }
    }

    private void displaySelectedPlacefromPlacePicker(Intent data){
        Place placeSelected=PlacePicker.getPlace(data,this);
        String id = placeSelected.getId();
        String name = placeSelected.getName().toString();
        List<Integer> placeType = placeSelected.getPlaceTypes();
        String type=placeType.get(0).toString();
        if(placeType.get(0)==15)
            type="Cafe";
        else if(placeType.get(0)==79)
            type="Restaurant";
        String address = placeSelected.getAddress().toString();
        float rating= placeSelected.getRating();
        String ratings=Float.toString(rating);
        String phoneNumber=placeSelected.getPhoneNumber().toString();
        int priceLevel = placeSelected.getPriceLevel();
        String website = placeSelected.getWebsiteUri().toString();
        TextView textView = (TextView) findViewById(R.id.textView);
        Random random = new Random();
        int shopid=random.nextInt(1000);
        String shopID=Integer.toString(shopid);
        TextView websiteTxt=(TextView) findViewById(R.id.websitelink);
        websiteTxt.setText("Website: "+website);
        TextView phoneNumberTxt=(TextView) findViewById(R.id.phonenumber);
        phoneNumberTxt.setText("Phone number: "+phoneNumber);
        textView.setText("Id: "+id+ "\n"+"Type:"+type+"\n"+name+ "\n" +address + "\nRating: "+rating +"\n"+ "Price Level: "+priceLevel+ "\n"+website+"\nPhone number:"+phoneNumber);
        boolean isInserted = myDb.insertShopData(shopID,name,"1",type,
                phoneNumber,website,address,ratings);
        if(isInserted==true) {
            Toast.makeText(PlaceDetail.this, "Data inserted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(PlaceDetail.this, "Data Not inserted", Toast.LENGTH_LONG).show();
        }
    }

    public void openDirectionAPI() {
        Intent intent = new Intent(this, ShowDirections.class);
        startActivity(intent);
    }

}
