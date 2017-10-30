package com.example.shrad.kiwicommentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<String> menuLists;
    private ArrayAdapter<String> adapter;
    public static String selectedshop="Nandos";
    public static String shop_id;
    public static DatabaseHelper helper;
   // private static Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        helper = WelcomePage.myDb;
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        Intent i = new Intent(this, SearchTwo.class);


    //    geocoder=new Geocoder(this);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_content);
        mDrawerList = (ListView) findViewById(R.id.menu);
        menuLists = new ArrayList<String>();
        menuLists.add("Log-in");
        menuLists.add("Signup");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menuLists);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sprint_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_login) {
            openLoginAcitivity();
            return true;
        }

        if (id == R.id.action_signup) {
            openSignUpAcitivity();
            return true;
        }

        if (id == R.id.action_signin) {
            openSignInAcitivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    public static LatLng getLatLang(String address){
//        LatLng latLng = null;
//        try {
//            List<Address> addressList=geocoder.getFromLocationName(address,1);
//            Address location = addressList.get(0);
//            latLng=new LatLng( location.getLatitude(),location.getLongitude());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return latLng;
//    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Restaurants();
                case 1:
                    return new Cafes();
                case 2:
                    return new Sports();

            }
            return new Cafes();
        }
        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Restaurants";
                case 1:
                    return "Cafes";
                case 2:
                    return "Sports";
            }
            return null;
        }
    }

    public void openSignUpAcitivity(){
        Intent intent = new Intent(Search.this,ShopDetailSignUpForm.class);
        startActivity(intent);
    }

    /**
     *  This method opens the map activity when pressed to get directions to the selected place.
     */
    public void openLoginAcitivity(){
        Intent intent = new Intent(Search.this,LogIn.class);
        startActivity(intent);
    }

    public void openSignInAcitivity(){
        Intent intent = new Intent(Search.this,LogIn.class);
        startActivity(intent);
    }
}
