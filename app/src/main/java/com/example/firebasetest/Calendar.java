package com.example.firebasetest;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Calendar extends AppCompatActivity {


    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        bnv= findViewById(R.id.bnv);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new F_Home()).commit();

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
               // R.id.frameLayout1.

                switch (item.getItemId()){
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new F_Home()).commit();

                        break;
                    case R.id.tab2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new F_Board()).commit();
                        break;
                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new F_Music()).commit();
                        break;
                    case R.id.tab4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout1, new F_Mypage()).commit();
                        break;
                }
                return true;
            }
        });

    }
}