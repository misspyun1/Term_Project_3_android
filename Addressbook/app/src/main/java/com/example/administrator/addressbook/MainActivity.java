package com.example.administrator.addressbook;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private BottomNavigationView navigation;
    private ViewPager viewPager;

    private Contacts contact_fragment = new Contacts();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPager.addOnPageChangeListener(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private TextView mTextMessage;

    private MenuItem prevBottomNavigation;

    @Override
    pubic void onPageSelected(int position){
        if(prevBottomNavigation !=null){
            prevBottomNavigation.setChecked(false);
        }
        prevBottomNavigation = mOnNavigationIte
    }

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent contact_intent = new Intent(getApplicationContext(),Contacts.class);
            switch (item.getItemId()) {
                case R.id.navigation_contacts:
                    startActivity(contact_intent);
                    return true;
                case R.id.navigation_favorites:
                    mTextMessage.setText(R.string.selection_favorites);
                    return true;
                case R.id.navigation_recent:
                    mTextMessage.setText(R.string.selection_recents);
                    return true;
                case R.id.navigation_keypad:
                    mTextMessage.setText(R.string.title_keypad);
                    return true;
            }
            return false;
        }

    };











}
