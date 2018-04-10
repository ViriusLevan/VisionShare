package com.example.android.visionshare;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.visionshare.Model.Model_GenericListObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard_News extends Fragment {
    private FirebaseDatabase fd;
    private DatabaseReference newsMetaRef;
    private ValueEventListener newsMetaListener;
    private ListView newsList;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fd = FirebaseDatabase.getInstance();
        newsMetaRef = fd.getReference().child("News Meta");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard_news, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newsList = view.findViewById(R.id.news_listView);

        newsMetaListener = newsMetaRef.orderByChild("Date Created")
                .limitToLast(20).addValueEventListener(new ValueEventListener() {

                    private LinkedList<Model_GenericListObject> tempStack = new LinkedList<>();
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot newsMeta : dataSnapshot.getChildren()){

                            Model_GenericListObject ins = new Model_GenericListObject(
                                    newsMeta.getKey(),
                                    newsMeta.child("Headline").getValue(String.class),
                                    String.valueOf(newsMeta.child("nOfComments").getValue()),
                                    "News", newsMeta.child("Place").getValue(String.class)
                            );
                            tempStack.push(ins);
                        }
                        GenericListAdapter adapter = new GenericListAdapter(getContext(), tempStack);
                        newsList.setAdapter(adapter);
                        newsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent news = new Intent(getActivity(), News.class);
                                news.putExtra("news_object", tempStack.get(i));
                                startActivity(news);
                            }
                        });
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        newsMetaRef.removeEventListener(newsMetaListener);
    }
}
