package com.example.android.visionshare;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, container, false);
        ListView newsList = view.findViewById(R.id.news_list);
        String[] news = {"Heboh naga di Tulung Agung", "Ikan Indosiar Mati", "[HELP] Desa Benowo sebagai tempat wisata"};
        newsList.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, news));
        return view;
    }

}
