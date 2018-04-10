package com.example.android.visionshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.visionshare.Model.Model_GenericListObject;

public class News extends AppCompatActivity {

    TextView headline, place, content;
    ImageView image;
    ListView comments;  
    Model_GenericListObject news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        headline = findViewById(R.id.newsHeadlineTV);


        //Mengambil data
        news = (Model_GenericListObject) getIntent().getSerializableExtra("news_object");
        headline.setText(news.getId_firebase());
    }

}
