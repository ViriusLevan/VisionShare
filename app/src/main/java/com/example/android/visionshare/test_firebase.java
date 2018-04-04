package com.example.android.visionshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class test_firebase extends AppCompatActivity{

    //https://visionshare-2b578.firebaseio.com/

    private EditText inputName, inputPass;
    private Button btnSave;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        inputName = findViewById(R.id.editText5);
        inputPass = findViewById(R.id.editText7);
        btnSave = findViewById(R.id.button2);

        myRef = FirebaseDatabase.getInstance().getReference();
        Log.d("My Ref", myRef.toString());

        //myRef.child("Name").setValue("DDDDDDD");
        myRef.child("Users").child("User1").child("Name").setValue("DDDDDDD");

        //DOESNT WORK BECAUSE ALL OF THE LAYOUTS ARE NULL, BECAUSE INIT IS SHIT
        /*
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("My Ref", myRef.toString());
                //Log.d("Button Save",btnSave.toString());
                //myRef.child("Password").setValue(inputPass.getText().toString());

            }
        });*/
    }



}
