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

public class Crowdfunding extends AppCompatActivity{

    TextView headline, place, content, fundsGathered, fundingGoal;
    ImageView image;
    ListView comments;
    Model_GenericListObject news;
    private FirebaseDatabase fd;
    private DatabaseReference crowdfundingContentRef;
    private ValueEventListener crowdfundingContentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        headline = findViewById(R.id.crowdfundingNameTV);
        place = findViewById(R.id.crowdfundingPlaceTV);
        content = findViewById(R.id.crowdfundingDescriptionTV);
        fundsGathered = findViewById(R.id.crowdfundingFundsGatheredTV);
        fundingGoal = findViewById(R.id.crowdfundingFundsNeededTV);

        //Mengambil data
        news = (Model_GenericListObject) getIntent().getSerializableExtra("news_object");
        headline.setText(news.getTitle());
        place.setText(news.getPlace());
        fundsGathered.setText(news.getFundsGathered());
        fundingGoal.setText(news.getFundingGoal());

        fd = FirebaseDatabase.getInstance();
        crowdfundingContentRef = fd.getReference().child("Crowdfunding Content");

        crowdfundingContentListener = crowdfundingContentRef.addValueEventListener(new ValueEventListener() {
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
        crowdfundingContentRef.removeEventListener(crowdfundingContentListener);
    }
}
