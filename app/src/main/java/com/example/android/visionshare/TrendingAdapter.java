package com.example.android.visionshare;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class TrendingAdapter extends ArrayAdapter{

    public TrendingAdapter(Context context, ArrayList<String> data) {
        super(context, R.layout.activity_trending_adapter, data);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
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
