package com.example.firebasetest;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class F_Home extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_f__home, container, false);

        //아이디 초기화
        ImageButton btn_calendar= view.findViewById(R.id.btn_calendar);

        //캘린더버튼 눌렀을때 캘린더로 이동
        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Calendar.class);
                startActivity(intent);
            }
        });


        return view;
    }
}