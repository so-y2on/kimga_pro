package com.example.firebasetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.firebasetest.VO.AlarmVO;



import java.util.List;

public class AlarmAdapter extends BaseAdapter {


    Context context; // 현재 페이지 정보
    int layout; // 항목 뷰 디자인
    List<AlarmVO> data; // 아이템셋

    LayoutInflater inflater; // xml파일 -> View객체

    ViewHolder viewHolder;

    String currentID; // 현재 로그인한 ID


    public AlarmAdapter(Context context, int layout, List<AlarmVO> data) {
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

        //View 객체가 필요함
        if (convertView == null) {
            convertView = inflater.inflate(layout, null);

            //convertView가 안 만들어져 있다면,
            viewHolder = new ViewHolder();

            //xml 파일에 부여한 id들을 초기화
            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
            viewHolder.tv_ampm = convertView.findViewById(R.id.tv_ampm);
            viewHolder.tv_time = convertView.findViewById(R.id.tv_time);

            //convertView가 만들어져 있는 지 판단하기 위한 도구
            convertView.setTag(viewHolder);
        }
        //만들어진 viewHolder를 가져다 사용!
        viewHolder = (ViewHolder) convertView.getTag();

        // name, img, tel을 position으로 구분하여 setting
        viewHolder.tv_name.setText(data.get(position).getName());
        viewHolder.tv_ampm.setText(data.get(position).getAmpm());
        viewHolder.tv_time.setText(data.get(position).getTime());

        return convertView;
    }
}