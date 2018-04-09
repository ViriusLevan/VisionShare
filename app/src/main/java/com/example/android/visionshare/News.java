package com.example.android.visionshare;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.visionshare.Model.GenericListObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.Stack;

/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {
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
        view = inflater.inflate(R.layout.fragment_news, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newsList = view.findViewById(R.id.news_listView);

        newsMetaListener = newsMetaRef.orderByChild("Date Created")
                .limitToLast(20).addValueEventListener(new ValueEventListener() {

                    private LinkedList<GenericListObject> tempStack = new LinkedList<>();
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot newsMeta : dataSnapshot.getChildren()){

                            GenericListObject ins = new GenericListObject(
                                    newsMeta.getKey(),
                                    newsMeta.child("Headline").getValue(String.class),
                                    String.valueOf(newsMeta.child("nOfComments").getValue()),
                                    "News"
                            );
                            tempStack.push(ins);
                        }
                        GenericListAdapter adapter = new GenericListAdapter(getContext(), tempStack);
                        newsList.setAdapter(adapter);
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
