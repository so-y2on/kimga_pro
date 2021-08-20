package com.example.firebasetest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.firebasetest.VO.MusicVO;

import java.util.ArrayList;
import java.util.List;

public class F_Music extends Fragment {

    ListView lv_music;
    List<MusicVO> data;
    int [] imgs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_f__music, container, false);

       //아이디 초기화
        lv_music = view.findViewById(R.id.lv_music);


       //img로직
        data = new ArrayList<MusicVO>();
        imgs = new int[10];
        for(int i=0; i<imgs.length; i++){
            int resId = getResources().getIdentifier("m"+(i),"drawable", getActivity().getPackageName());
            imgs[i]= resId;
        }

        //가데이터
            data.add(new MusicVO("청춘", "우효", imgs[0]));
            data.add(new MusicVO("혼자라고 생각말기", "김보경", imgs[1]));
            data.add(new MusicVO("응원가", "어쿠스틱콜라보", imgs[2]));


        MusicAdapter adapter = new MusicAdapter(getActivity(), R.layout.musiclist,data);
        lv_music.setAdapter(adapter);


        //리스트 클릭했을때 유튭으로
        lv_music.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent();

                if(position==0){
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse( "https://www.youtube.com/watch?v=wrmyqKRGW-0"));

                }else if(position==1){
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse( "https://www.youtube.com/watch?v=tJ02RvpMNA4"));

                }else if(position==2){
                   intent = new Intent(Intent.ACTION_VIEW, Uri.parse( "https://www.youtube.com/watch?v=QS9xV54-bPQ"));

                }
                startActivity(intent);
            }
        });

       return view;
    }
}