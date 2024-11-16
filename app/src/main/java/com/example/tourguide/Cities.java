package com.example.tourguide;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Cities extends Fragment {
    View citylistview;
    ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        citylistview = inflater.inflate(R.layout.fragment_cities, container, false);
        listview = citylistview.findViewById(R.id.citylistview);
        Resources res = getResources();
        String [] cities = res.getStringArray(R.array.cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, cities);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener((adapterView, view, i, l) -> {
            Descriptions descriptions = (Descriptions) getFragmentManager().findFragmentById(R.id.descriptionList);

            String [] citydescriptions = res.getStringArray(R.array.city_descriptions);
            descriptions.setmethod("" + citydescriptions[i]);
            listview.setSelector(android.R.color.holo_blue_dark);
        });


        return citylistview;
    }

}