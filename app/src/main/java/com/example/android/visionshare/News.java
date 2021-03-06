package com.example.android.visionshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.visionshare.Model.Model_GenericListObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class News extends AppCompatActivity {

    TextView headline, place, content;
    ImageView image;
    ListView comments;
    Model_GenericListObject news;
    private FirebaseDatabase fd;
    private DatabaseReference newsContentRef;
    private ValueEventListener newsContentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        headline = findViewById(R.id.newsHeadlineTV);
        place = findViewById(R.id.newsPlaceTV);
        content = findViewById(R.id.newsContentTV);

        //Mengambil data
        news = (Model_GenericListObject) getIntent().getSerializableExtra("news_object");
        headline.setText(news.getTitle());
        place.setText(news.getPlace());
        fd = FirebaseDatabase.getInstance();
        newsContentRef = fd.getReference().child("News Content");

        newsContentListener = newsContentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                content.setText(dataSnapshot.child
                        (news.getId_firebase()).child("Content").getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        newsContentRef.removeEventListener(newsContentListener);
    }
}
