package com.example.firebasetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.firebasetest.VO.BoardVO;

import java.util.List;

public class BoardAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<BoardVO> data;

    LayoutInflater inflater;
    ViewHolder viewHolder;

    public BoardAdapter(Context context, int layout, List<BoardVO> data) {
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

            viewHolder.img_board_user= convertView.findViewById(R.id.img_board_user);
            viewHolder.tv_writer= convertView.findViewById(R.id.tv_writer);
            viewHolder.tv_answer= convertView.findViewById(R.id.tv_answer);
            viewHolder.tv_board_date = convertView.findViewById(R.id.tv_board_date);

            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder)convertView.getTag();
        viewHolder.img_board_user.setImageResource(data.get(position).getImg_board());
        viewHolder.tv_writer.setText(data.get(position).getWirter());
        viewHolder.tv_answer.setText(data.get(position).getAnswer());
        viewHolder.tv_board_date.setText(data.get(position).getBoard_date());

        return convertView;
    }
}
