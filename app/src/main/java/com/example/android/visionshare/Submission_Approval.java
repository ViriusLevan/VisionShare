package com.example.android.visionshare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Submission_Approval extends AppCompatActivity {

    private TextView submissionApprovalNameTV, submissionApprovalLocationTV,
            submissionApprovalDescriptionTV;
    private ImageView submissionApprovalImageIV;
    private ValueEventListener submissionListener;

    private FirebaseDatabase fd;
    private DatabaseReference myRef, submissionsRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission_approval);

        submissionApprovalNameTV = findViewById(R.id.submissionApprovalNameTV);
        submissionApprovalDescriptionTV = findViewById(R.id.submissionApprovalDescriptionTV);
        submissionApprovalLocationTV = findViewById(R.id.submissionApprovalLocationTV);
        submissionApprovalImageIV = findViewById(R.id.submissionApprovalImageIV);

        fd = FirebaseDatabase.getInstance();
        submissionsRef = fd.getReference().child("Submissions");

        submissionListener = submissionsRef.orderByChild("Status").equalTo("Pending")
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    submissionApprovalNameTV.setText(ds.child("Name").getValue(String.class));
                    submissionApprovalDescriptionTV.setText(ds.child("Description").getValue(String.class));
                    submissionApprovalLocationTV.setText(ds.child("Location").getValue(String.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("SUBMISSIONS READ FAIL", "Failed to read value.",
                        databaseError.toException());
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        submissionsRef.removeEventListener(submissionListener);
    }
}
