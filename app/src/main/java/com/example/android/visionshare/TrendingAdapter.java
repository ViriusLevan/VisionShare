package com.example.android.visionshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.visionshare.Model.ListViewLayout;

import java.util.ArrayList;

public class TrendingAdapter extends ArrayAdapter{

    public TrendingAdapter(Context context, ArrayList<ListViewLayout> data) {
        super(context, R.layout.activity_trending_adapter, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewLayout item = (ListViewLayout) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_trending_adapter, parent, false);
        }

        TextView title = convertView.findViewById(R.id.trending_title);
        TextView num_comment = convertView.findViewById(R.id.trending_comment_number);

        title.setText(item.getTitle());
        num_comment.setText(item.getNum_of_comment());

//        Chapter chapter = getItem(position);
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_single, parent, false);
//        }
//
//        TextView title = (TextView) convertView.findViewById(R.id.listChapterTitle);
//
//        title.setText("Chapter "+chapter.getNum()+" "+chapter.getTitle());
//        if(chapter.getStatus()==1) {
//            title.setTextColor(Color.parseColor("#000000"));
//        }
//        else {
//            title.setTextColor(Color.parseColor("#FFFFFF"));
//        }

        return convertView;
    }
}
