package com.example.firebasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class AddAlarm extends AppCompatActivity {

    Switch sw_ampm;
    EditText et_time_alarm,et_name_alarm;
    Button btn_save_alarm;

    boolean am;
    String na;
    String ti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        sw_ampm=findViewById(R.id.sw_ampm);
        et_time_alarm=findViewById(R.id.et_time_alarm);
        et_name_alarm=findViewById(R.id.et_name_alarm);
        btn_save_alarm=findViewById(R.id.btn_save_alarm);

        am = sw_ampm.isChecked();
        ti = et_time_alarm.getText().toString();
        na = et_name_alarm.getText().toString();


        btn_save_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String etTimeAlarm = et_time_alarm.getText().toString();
                String etNameAlarm = et_name_alarm.getText().toString();
                Boolean swAmpm = sw_ampm.isChecked();

                // SharedPreference에 url값 저장하기
                // 1. SharedPreference 가져오기
                SharedPreferences spf = getSharedPreferences("mySPF", Context.MODE_PRIVATE);
                // 2. sdf에 데이터를 저장할 수 있는 editor 가져오기
                SharedPreferences.Editor editor = spf.edit();
                // 3. editor를 통해서 데이터 저장하기(commit 필수!!!!!!!!!!!!!!!!!!!!!!!!!!!!)
                editor.putString("address",et_time_alarm.getText().toString()).commit();
                editor.putString("address",et_name_alarm.getText().toString()).commit();
                editor.putBoolean("address",sw_ampm.isChecked()).commit();

                // et_url에 적힌 글자 Toast로 띄꾸기
                // Toast.makeText(getActivity().getApplicationContext(),
                //      et_url.getText().toString(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AddAlarm.this, Alarm.class);

                intent.putExtra("etTimeAlarm",etTimeAlarm);
                intent.putExtra("etNameAlarm",etNameAlarm);
                intent.putExtra("swAmpm",swAmpm);
                Log.d("======", String.valueOf(swAmpm));

                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

}