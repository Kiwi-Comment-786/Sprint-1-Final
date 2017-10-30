package com.example.shrad.kiwicommentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class Restaurants extends Fragment {
    private TextView name;
    private TextView address;
    private TextView phonenumber;
    private TextView netlink;
    private String n[]= new String[100];
    private String a[]= new String[100];
    private String p[]= new String[100];
    private String l[]= new String[100];
    private int count;
    public static String shop_id;
    DatabaseHelper myDb = WelcomePage.myDb;


    public Restaurants(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int i=0;i<99;i++)
        {
            n[i]="name"+ n[i];
            a[i]="address"+a[i];
            p[i]="phonenumber"+p[i];
            l[i]="Netlink"+l[i];
//            n[i]=list.get(i).getName();
//            a[i]=list.get(i).getStreetAddress();
//            p[i]=list.get(i).getPhonenumber();
//            l[i]=list.get(i).getNetlink();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ArrayList<Information> list=WelcomePage.getRestaurantDetails();
        final View rootView = inflater.inflate(R.layout.fragment_restaurants, container, false);

        name = rootView.findViewById(R.id.name1);
        name.setText("Name: "+WelcomePage.getRestaurantDetails().get(0).getName());
        address = rootView.findViewById(R.id.address1);
        address.setText("Ratings: "+WelcomePage.getRestaurantDetails().get(0).getRatings());

        name = rootView.findViewById(R.id.name2);
        name.setText("Name: "+WelcomePage.getRestaurantDetails().get(1).getName());
        address = rootView.findViewById(R.id.address2);
        address.setText("Ratings: "+WelcomePage.getRestaurantDetails().get(1).getRatings());

        name = rootView.findViewById(R.id.name3);
        name.setText("Name: "+WelcomePage.getRestaurantDetails().get(2).getName());
        address = rootView.findViewById(R.id.address3);
        address.setText("Ratings: "+WelcomePage.getRestaurantDetails().get(2).getRatings());

        name = rootView.findViewById(R.id.name4);
        name.setText("Name: "+WelcomePage.getRestaurantDetails().get(3).getName());
        address = rootView.findViewById(R.id.address4);
        address.setText("Ratings: "+WelcomePage.getRestaurantDetails().get(3).getRatings());


        rootView.findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
            }
        });
        rootView.findViewById(R.id.choose1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shop_id=list.get(0).getId();
                Bundle bundle = new Bundle();
                bundle.putString("shop_id",shop_id);
                Intent i = new Intent(getActivity(), SearchTwo.class);
                i.putExtras(bundle);
                getActivity().startActivity(i);
            }
        });
        rootView.findViewById(R.id.choose2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shop_id=list.get(1).getId();
                Bundle bundle = new Bundle();
                bundle.putString("shop_id",shop_id);
                Intent i = new Intent(getActivity(), SearchTwo.class);
                i.putExtras(bundle);
                getActivity().startActivity(i);
            }
        });
        rootView.findViewById(R.id.choose3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shop_id=list.get(2).getId();
                Bundle bundle = new Bundle();
                bundle.putString("shop_id",shop_id);
                Intent i = new Intent(getActivity(), SearchTwo.class);
                i.putExtras(bundle);
                getActivity().startActivity(i);
            }
        });
        rootView.findViewById(R.id.choose4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shop_id=list.get(3).getId();
                Bundle bundle = new Bundle();
                bundle.putString("shop_id",shop_id);
                Intent i = new Intent(getActivity(), SearchTwo.class);
                i.putExtras(bundle);
                getActivity().startActivity(i);
            }
        });

        rootView.findViewById(R.id.previous).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count>3){
                    count=count-4;
                    getFragmentManager().beginTransaction().attach(new Cafes()).commit();
                }
            }
        });

        rootView.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=count+4;
                getFragmentManager().beginTransaction().attach(new Cafes()).commit();
            }
        });

        return rootView;

    }


}
