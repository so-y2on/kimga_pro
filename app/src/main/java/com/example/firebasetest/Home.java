package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {

    ImageButton btn_calendar;
    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bnv= findViewById(R.id.bnv);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new F_Home()).commit();

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new F_Home()).commit();

                        break;
                    case R.id.tab2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new F_Board()).commit();
                        break;
                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new F_Music()).commit();
                        break;
                    case R.id.tab4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new F_Mypage()).commit();
                        break;
                }





                return true;
            }
        });


    }
}