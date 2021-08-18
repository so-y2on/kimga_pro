package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class AddAlarm extends AppCompatActivity {

    Switch sw_ampm;
    EditText et_time_alarm,et_name_alarm;
    Button btn_save_alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

    sw_ampm=findViewById(R.id.sw_ampm);
    et_time_alarm=findViewById(R.id.et_time_alarm);
    et_name_alarm=findViewById(R.id.et_pat_id);
    btn_save_alarm=findViewById(R.id.btn_save_alarm);

    btn_save_alarm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String ampm = sw_ampm.getText().toString();
            String time  = et_time_alarm.getText().toString();
            String name  = et_name_alarm.getText().toString();

            Intent intent = new Intent();
        }
    });




    }
}