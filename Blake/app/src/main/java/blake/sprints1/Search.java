package blake.sprints1;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Search extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<String> menuLists;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        Intent i = new Intent(this, SearchTwo.class);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_content);
        mDrawerList = (ListView) findViewById(R.id.menu);
        menuLists = new ArrayList<String>();
        menuLists.add("Log-in");
        menuLists.add("Signup");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menuLists);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sprints_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Restaurant();
                case 1:
                    return new Cafe();
                case 2:
                    return new Shopping();
                case 3:
                    return new Sport();
            }
            return new Cafe();
        }
        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Restaurant";
                case 1:
                    return "Cafe";
                case 2:
                    return "Shopping";
                case 3:
                    return "Sport";
            }
            return null;
        }
    }
}
