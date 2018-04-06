package com.example.android.visionshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends Fragment implements OnMapReadyCallback {
    View view;
    GoogleMap mMap;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        SupportMapFragment mapFragment = null;
        if (view != null)
        {
            ViewGroup parent = (ViewGroup)view.getParent();
            if(parent != null)
            {
                parent.removeAllViews();
            }
        }
        try {
            view = inflater.inflate(R.layout.fragment_map, container, false);
            mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        }
        catch (InflateException e)
        {
            mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
        }

        mapFragment.getMapAsync(this);

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Toast.makeText(getContext(), "Place : "+place.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
