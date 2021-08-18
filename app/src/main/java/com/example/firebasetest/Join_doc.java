package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Join_doc extends AppCompatActivity {

    Button btn_join_doc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_doc);

        btn_join_doc = findViewById(R.id.btn_join_doc);


        btn_join_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Join_doc.this, Login_doc.class );
                startActivity(intent);
            }
        });
    }
}