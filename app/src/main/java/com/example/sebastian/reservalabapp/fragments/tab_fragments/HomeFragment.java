package com.example.sebastian.reservalabapp.fragments.tab_fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sebastian.reservalabapp.actividades.Drawer;
import com.example.sebastian.reservalabapp.R;

public class HomeFragment extends Fragment {

    Button btn_go;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btn_go = view.findViewById(R.id.btn_home_gragment);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Drawer.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
