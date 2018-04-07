package com.example.android.visionshare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Submission extends Fragment{

    private TextView projectNameTV, projectDescTV, projectLocationTV;
    private ImageView projectImageIV;
    private FirebaseDatabase fd;
    private DatabaseReference myRef, projectInfoRef;
    private ChildEventListener myProjectChildListener;
    private ValueEventListener projectInfoListener;

    View view;
    public static Submission newInstance() {
        Submission fragment = new Submission();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        fd = FirebaseDatabase.getInstance();
        myRef = fd.getReference().child("User has Projects").child("iQhuQQFduEck3r2yT7jpQLZnD6k2");
        projectInfoRef = fd.getReference().child("Crowdfunding Projects");


        //        myProjectChildListener = myRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getKey();
//                projectNameTV.setText(value);
//                Log.d("MY PROJECT READ SUCCESS", "Value is: " + value);
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.w("MY PROJECT READ FAIL", "Failed to read value.",
//                        databaseError.toException());
//            }
//        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_submission, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        projectNameTV = getView().findViewById(R.id.myProjectNameTV);
        projectLocationTV = getView().findViewById(R.id.myProjectLocationTV);
        projectImageIV = getView().findViewById(R.id.myProjectImageIV);
        projectDescTV = getView().findViewById(R.id.myProjectDescriptionTV);

        //Read from database
        projectInfoListener = projectInfoRef.orderByChild("Submitted By").
                equalTo("iQhuQQFduEck3r2yT7jpQLZnD6k2").addValueEventListener
                (new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot myProjectData : dataSnapshot.getChildren()){
                            projectNameTV.setText(myProjectData.child("Name").getValue(String.class));
                            projectLocationTV.setText(myProjectData.child("Location").getValue(String.class));
                            projectDescTV.setText(myProjectData.child("Description").getValue(String.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myRef.removeEventListener(projectInfoListener);
    }


}
