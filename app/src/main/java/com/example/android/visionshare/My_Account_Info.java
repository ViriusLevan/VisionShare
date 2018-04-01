package com.example.android.visionshare;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class My_Account_Info extends Fragment {


    View view;
    public static My_Account_Info newInstance() {
        My_Account_Info fragment = new My_Account_Info();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_my_account_info, container, false);
        return view;
    }


}
