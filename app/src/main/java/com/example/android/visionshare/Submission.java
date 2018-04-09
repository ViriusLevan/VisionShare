package com.example.android.visionshare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.visionshare.Model.Model_Submission;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Submission extends Fragment{

    private FirebaseDatabase fd;
    private DatabaseReference submissionRef;
    private ImageView imageView;
    private EditText nameET, locationET, descriptionET;
    private Button submitButton;
    View view;
    public static Submission newInstance() {
        Submission fragment = new Submission();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fd = FirebaseDatabase.getInstance();
        submissionRef = fd.getReference().child("Submissions");

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
        nameET = getView().findViewById(R.id.submissionNameET);
        locationET = getView().findViewById(R.id.submissionLocationET);
        descriptionET = getView().findViewById(R.id.submissionDescriptionET);
        submitButton = getView().findViewById(R.id.submissionSubmitBtn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference pushedSubRef = submissionRef.push();
                String newKey = pushedSubRef.getKey();

                submissionRef.child(newKey).child("Type").setValue("Crowdfunding");
                submissionRef.child(newKey).child("Name").setValue(nameET.getText().toString());
                submissionRef.child(newKey).child("Description")
                        .setValue(descriptionET.getText().toString());
                submissionRef.child(newKey).child("Location")
                        .setValue(locationET.getText().toString());
                submissionRef.child(newKey).child("Status").setValue("Pending");
                submissionRef.child(newKey).child("Submitted by").setValue("DUMMY USER");
                submissionRef.child(newKey).child("Funding Goal").setValue(1000000);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
