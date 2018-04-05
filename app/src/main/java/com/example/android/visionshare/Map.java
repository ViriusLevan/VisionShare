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
import android.widget.LinearLayout;
import android.widget.ListView;

public class Map extends Fragment {
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_map, container, false);

//        LinearLayout map = view.findViewById(R.id.map_home_map);
//        View childLayout = inflater.inflate(R.layout.activity_maps, null);
//        childLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//        map.addView(childLayout);

        ListView newsList = view.findViewById(R.id.map_news_list);
        ListView trendingList = view.findViewById(R.id.map_trending_list);
        String[] news = {"Heboh naga di Tulung Agung", "Ikan Indosiar Mati", "[HELP] Desa Benowo sebagai tempat wisata"};
        String[] trend = {"Pantai Kute", "Tugu Pahlawan", "Bandar Jakarta"};
        newsList.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, news));
        trendingList.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, trend));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
