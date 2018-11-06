package com.shoedazzle.m.navigationdrawerdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //NavigationDrawder;
    DrawerLayout mdrawerlayout;
    ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_id);
        navigationView.setNavigationItemSelectedListener(this);


        //NavigationDrawder;
        mdrawerlayout = findViewById(R.id.drawer);
        //mToggle = new ActionBarDrawerToggle(this,mdrawerlayout,toolbar,R.string.open,R.string.close);
        mToggle = new ActionBarDrawerToggle(this,mdrawerlayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        mdrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState==null){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
        navigationView.setCheckedItem(R.id.home);

        }



    }


    //Drawer BackProces;
    @Override
    public void onBackPressed() {
        if (mdrawerlayout.isDrawerOpen(GravityCompat.START)){
            mdrawerlayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
                break;

            case R.id.about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
                break;

            case R.id.more:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MoreAppFragment()).commit();
                break;

            case R.id.rate:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RateFragment()).commit();
                break;

            case R.id.share:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShareFragment()).commit();
                break;

        }

        mdrawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }

   /* //NavigationDrawder;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

}
