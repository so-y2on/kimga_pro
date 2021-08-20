package com.example.firebasetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.firebasetest.R;
import com.example.firebasetest.VO.MusicVO;
import com.example.firebasetest.ViewHolder;

import java.util.List;

public class MusicAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<MusicVO> data;

    LayoutInflater inflater;
    ViewHolder viewHolder;

    public MusicAdapter(Context context, int layout, List<MusicVO> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       if(convertView==null){
           convertView = inflater.inflate(layout, null);
           viewHolder = new ViewHolder();

           viewHolder.tv_singer= convertView.findViewById(R.id.tv_singer);
           viewHolder.tv_song= convertView.findViewById(R.id.tv_song);
           viewHolder.img_music = convertView.findViewById(R.id.img_music);

           convertView.setTag(viewHolder);
       }

            viewHolder = (ViewHolder)convertView.getTag();
       viewHolder.img_music.setImageResource(data.get(position).getImg());
       viewHolder.tv_song.setText(data.get(position).getSong());
       viewHolder.tv_singer.setText(data.get(position).getSinger());


        return convertView;
    }
}
