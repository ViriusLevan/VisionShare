package com.example.android.visionshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.visionshare.Model.Model_GenericListObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;

public class Home extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FirebaseDatabase fd;
    private DatabaseReference newsMetaRef, trendingMetaRef;
    private ValueEventListener newsMetaListener, trendingMetaListener;
    private ListView newsList, trendingList;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Home newInstance() {
        Home fragment = new Home();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fd = FirebaseDatabase.getInstance();
        newsMetaRef = fd.getReference().child("News Meta");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button map = view.findViewById(R.id.home_map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getContext(), MapsActivity.class);
                startActivity(a);
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsList = view.findViewById(R.id.home_news_list);
        trendingList = view.findViewById(R.id.home_trending_list);

        LinkedList<Model_GenericListObject> fake = new LinkedList<>();
        fake.push(new Model_GenericListObject(
            "Crowdfunding1","Beach Cleaning", "1", "Crowdfunding",
                "Kuta Beach","50000","1000000"
        ));
        fake.push(new Model_GenericListObject(
                "News1","Promo Durian Murah", "1", "News",
                "Pasar A"
        ));
        fake.push(new Model_GenericListObject(
                "Place1","Hidden Dragon", "1", "Place"
        ));
        GenericListAdapter temAdap = new GenericListAdapter(getContext(),fake);
        trendingList.setAdapter(temAdap);

        newsMetaListener = newsMetaRef.orderByChild("Date Created")
                .limitToLast(5).addValueEventListener(new ValueEventListener() {

                    private LinkedList<Model_GenericListObject> tempStack = new LinkedList<>();
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot newsMeta : dataSnapshot.getChildren()){

                            Model_GenericListObject ins = new Model_GenericListObject(
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
