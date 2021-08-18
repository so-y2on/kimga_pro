package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login_doc extends AppCompatActivity {

    Button btn_login_doc;
    TextView tv_join_doc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_doc);

        btn_login_doc = findViewById(R.id.btn_login_doc);
        tv_join_doc= findViewById(R.id.tv_join_doc);


        tv_join_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_doc.this, Join_doc.class);
                startActivity(intent);
            }
        });
    }
}