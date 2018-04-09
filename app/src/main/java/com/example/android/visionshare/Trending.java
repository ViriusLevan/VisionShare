package com.example.android.visionshare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.android.visionshare.Model.GenericListObject;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Trending extends Fragment {
    View view;
    GenericListAdapter adapter;
    private FirebaseDatabase fd;
    private DatabaseReference trendingMetaRef;
    private ValueEventListener newsMetaListener;
    private ListView newsList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fd = FirebaseDatabase.getInstance();
//        trendingMetaRef = fd.getReference().child("News Meta");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_trending, container, false);

        Spinner dropdown = view.findViewById(R.id.tranding_spinner);
        ArrayList<String> items = new ArrayList<String>();
        items.add("Now");
        items.add("Monthly");
        dropdown.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items));

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ListView listView = view.findViewById(R.id.trending_listView);
        ArrayList<GenericListObject> trend = new ArrayList<GenericListObject>();
        trend.add(new GenericListObject("1", "Pantai Kute", "5", "place"));
        trend.add(new GenericListObject("2", "Nude Beach", "5", "place"));
        adapter = new GenericListAdapter(getContext(), trend);
        listView.setAdapter(adapter);

        return view;
    }
}
