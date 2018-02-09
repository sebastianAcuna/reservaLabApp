package com.example.sebastian.reservalabapp.fragments.tab_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebastian.reservalabapp.R;

import java.util.ArrayList;
import java.util.List;


public class HoursFragment extends Fragment {
    private List<String> nombres;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mA;
    private RecyclerView.LayoutManager mL;

    public HoursFragment() {
        // Required empty public constructor
    }

    //implements testFragment.DataListener para poder cambiar entre fragments

    //private boolean multipanel; //para saber si hay mas de un fragment
    //setMultipanel(); // llama a funcino multipanel
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hours, container, false);

        //mRecyclerView = findViewById(R.id.recycler_view);
/*
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/


        // nombres = this.getAllNombres();

        //mL = new LinearLayoutManager(MainActivity.this);
        // grid layout recibe contexto y numero de columnas
        //mL = new GridLayoutManager(MainActivity.this, 4);
        //Staggered recibe numero de columnas y orientacion formato collage
        //mL = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);


/*        mA = new Adapter_recycler_view(nombres, R.layout.recycler_view_item, new Adapter_recycler_view.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                //Toast.makeText(MainActivity.this, name + " " + position, Toast.LENGTH_SHORT).show();
                deleteName(position);
            }
        });*/

/*        mRecyclerView.setHasFixedSize(false); // sirve para dejar de un tamaño fijo el recycler (optimiza el dejarlo fijo)
        mRecyclerView.setItemAnimator(new DefaultItemAnimator()); // agrega una animacion default ( ya se aprendera a crear animaciones :3)



        mRecyclerView.setLayoutManager(mL);
        mRecyclerView.setAdapter(mA);*/


        return view;
    }


/*    private List<String> getAllNombres(){
        return new ArrayList<String>(){{
            add("Alejandro");
            add("Jose");
            add("Barrera");
            add("Ruben");
            add("Antonio");

        }};
    }*/
/*    public void addName(int position){

        nombres.add(position, "Nuevo Nombre " + (++contador));
        mA.notifyItemInserted(position);
        mL.scrollToPosition(position); //lleva el scroll a la pocision donde se agregó el item
    }
    public void deleteName(int position){
        nombres.remove(position);
        mA.notifyItemRemoved(position);

    }*/

/*    @Override
    public void sendData(String text) {
        if(multipanel){
            DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.data_detail_f);
            detailFragment.renderText(text);
        }else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("text", text);
            startActivity(intent);
        }

    }*/
/*
    public void setMultipanel(){
        multipanel = (getSupportFragmentManager().findFragmentById(R.id.data_detail_f) != null);
    }*/

}
