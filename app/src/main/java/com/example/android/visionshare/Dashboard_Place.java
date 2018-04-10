package com.example.android.visionshare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.visionshare.Model.Model_GenericListObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;

public class Dashboard_Place extends Fragment{
    private FirebaseDatabase fd;
    private DatabaseReference placeMetaRef;
    private ValueEventListener placeMetaListener;
    private ListView placeList;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fd = FirebaseDatabase.getInstance();
        placeMetaRef = fd.getReference().child("Place Meta");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard_place, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        placeList = view.findViewById(R.id.place_listView);

        placeMetaListener = placeMetaRef.orderByChild("Date Created")
                .limitToLast(20).addValueEventListener(new ValueEventListener() {

                    private LinkedList<Model_GenericListObject> tempStack = new LinkedList<>();
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot newsMeta : dataSnapshot.getChildren()){

                            Model_GenericListObject ins = new Model_GenericListObject(
                                    newsMeta.getKey(),
                                    newsMeta.child("Headline").getValue(String.class),
                                    String.valueOf(newsMeta.child("nOfComments").getValue()),
                                    "Place"
                            );
                            tempStack.push(ins);
                        }
                        GenericListAdapter adapter = new GenericListAdapter(getContext(), tempStack);
                        placeList.setAdapter(adapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        placeMetaRef.removeEventListener(placeMetaListener);
    }
}
