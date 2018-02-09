package com.example.sebastian.reservalabapp.fragments.tab_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebastian.reservalabapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetHoursFragment extends Fragment {


    public GetHoursFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_hours, container, false);
        return view;
    }

}
