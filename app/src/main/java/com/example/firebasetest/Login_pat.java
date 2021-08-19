package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login_pat extends AppCompatActivity {

    Button btn_login_pat;
    TextView tv_join_pat;
    EditText et_id, et_pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pat);

        // 아이디 초기화
        btn_login_pat = findViewById(R.id.btn_login_pat);
        tv_join_pat = findViewById(R.id.tv_join_pat);

        //로그인버튼
        btn_login_pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        });

        //회원가입버튼
        tv_join_pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Join_pat.class);
                startActivity(intent);
            }
        });

    }
}