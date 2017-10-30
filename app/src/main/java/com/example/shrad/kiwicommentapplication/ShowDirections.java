package com.example.shrad.kiwicommentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class ShowDirections extends AppCompatActivity {

    TextView address;
    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_directions);
        address = (TextView) findViewById(R.id.textView2);
        address.setText("Address: "+ PlaceDetail.addressDirection);
        address.setAutoLinkMask(Linkify.MAP_ADDRESSES);

    }
}
