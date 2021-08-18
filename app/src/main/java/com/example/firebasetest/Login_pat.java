package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login_pat extends AppCompatActivity {

    Button btn_login_pat;
    TextView tv_join_pat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pat);

        btn_login_pat = findViewById(R.id.btn_login_pat);
        tv_join_pat = findViewById(R.id.tv_join_pat);

        btn_login_pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_pat.this, Home.class);
                startActivity(intent);
            }
        });

        tv_join_pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_pat.this, Join_pat.class);
                startActivity(intent);
            }
        });

    }
}