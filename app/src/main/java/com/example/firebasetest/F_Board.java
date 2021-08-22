package com.example.firebasetest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.firebasetest.VO.BoardVO;
import com.example.firebasetest.VO.MusicVO;

import java.util.ArrayList;
import java.util.List;


public class F_Board extends Fragment {

    ListView lv_board;
    List<BoardVO> data;
    int [] imgs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.fragment_f__board, container, false);

        //아이디 초기화
        Button btn_send = view.findViewById(R.id.btn_send);
        lv_board = view.findViewById(R.id.lv_board);
        EditText et_msg = view.findViewById(R.id.et_msg);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //img로직
                data = new ArrayList<BoardVO>();
                imgs = new int[10];
                for(int i=0; i<imgs.length; i++){
                    int resId = getResources().getIdentifier("m"+(i),"drawable", getActivity().getPackageName());
                    imgs[i]= resId;
                }

                String etMsg = et_msg.getText().toString();
                //가데이터
                data.add(new BoardVO("펭수",etMsg, imgs[0],"2021/08/20"));

                BoardAdapter adapter = new BoardAdapter(getActivity(), R.layout.boardlist,data);
                lv_board.setAdapter(adapter);


            }
        });



         return view;
    }
}