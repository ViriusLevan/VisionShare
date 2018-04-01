package com.example.android.visionshare;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class My_Account_Projects extends Fragment {

    View view;
    public static My_Account_Projects newInstance() {
        My_Account_Projects fragment = new My_Account_Projects();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_my_account_projects, container, false);
        return view;
    }
}
