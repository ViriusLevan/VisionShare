package com.example.android.visionshare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.android.visionshare.Model.Model_GenericListObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Dashboard_Trending extends Fragment {
    View view;
    GenericListAdapter adapter;
    private FirebaseDatabase fd;
    private DatabaseReference commentsRef, newsMetaRef,placeMetaRef,crowdfundingMetaRef;
    private ValueEventListener commentsListener, newsMetaListener, placeMetaListener, crowdfundingMetaListener;
    private ListView newsList;
    private byte spinnerValue = 0;
    private ListView listView;
    private ArrayList<Model_GenericListObject> trends;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fd = FirebaseDatabase.getInstance();
        commentsRef = fd.getReference().child("Comments");
        newsMetaRef = fd.getReference().child("News Meta");
        placeMetaRef = fd.getReference().child("Place Meta");
        crowdfundingMetaRef = fd.getReference().child("Crowdfunding Projects");
        trends  = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_dashboard_trending, container, false);

        Spinner dropdown = view.findViewById(R.id.tranding_spinner);
        ArrayList<String> items = new ArrayList<String>();
        items.add("Today");
        items.add("Monthly");
        dropdown.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items));

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).toString().equals("Today")){
                    spinnerValue = 0;
                }else if(parent.getItemAtPosition(position).toString().equals("Monthly")){
                    spinnerValue = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listView = view.findViewById(R.id.trending_listView);
        ArrayList<Model_GenericListObject> trend = new ArrayList<Model_GenericListObject>();
        trend.add(new Model_GenericListObject("1", "Pantai Kute", "5", "place"));
        trend.add(new Model_GenericListObject("2", "Nude Beach", "5", "place"));
        adapter = new GenericListAdapter(getContext(), trend);
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //attachListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        commentsRef.removeEventListener(commentsListener);
    }

    private void attachListener(){
        String date= "", date2 = "";
        //TODO ACTUALLY GET THESE DATES
        if(spinnerValue == 0){
            date = "2018-4-9";
            date2 = date;
        }else if(spinnerValue == 1){
            date = "2018-4-9";
            date2 = date;
        }
        commentsListener = commentsRef.orderByChild("Date Created").
                startAt(date).endAt(date2).limitToLast(5).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    if(ds == null){
                        continue;
                    }

                    Model_GenericListObject ins = new Model_GenericListObject(
                            ds.child("inThread").getValue().toString(),
                            ds.child("inCategory").getValue(String.class)
                    );
                    trends.add(ins);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//
//        newsMetaListener = newsMetaRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot ds : dataSnapshot.getChildren()){
//                    for(Model_GenericListObject a : trends){
//                        if(a.getId_firebase().equals(ds.getKey())){
//                            ds.child("Title")
//                        }
//
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//        placeMetaListener = placeMetaRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//
//        crowdfundingMetaListener = crowdfundingMetaRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }
}
