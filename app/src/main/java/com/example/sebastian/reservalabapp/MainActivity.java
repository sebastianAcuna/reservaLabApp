package com.example.sebastian.reservalabapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sebastian.reservalabapp.adaptadores.Adapter_recycler_view;
import com.example.sebastian.reservalabapp.fragments.DetailFragment;
import com.example.sebastian.reservalabapp.fragments.testFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements testFragment.DataListener {

    private TextView mTextMessage;
    private List<String> nombres;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mA;
    private RecyclerView.LayoutManager mL;
    private int contador = 0;

    private boolean multipanel;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    mTextMessage.setText(R.string.title_home);

                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                   // mRecyclerView.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                   // mRecyclerView.setVisibility(View.INVISIBLE);
                    return true;
            }
            return false;
        }
    };






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMultipanel();
        mTextMessage = (TextView) findViewById(R.id.message);
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
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //se infla el menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //se prepara el onclick
        switch (item.getItemId()){
            case R.id.add_name:
                addName(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private List<String> getAllNombres(){
        return new ArrayList<String>(){{
            add("Alejandro");
            add("Jose");
            add("Barrera");
            add("Ruben");
            add("Antonio");

        }};
    }
    public void addName(int position){

        nombres.add(position, "Nuevo Nombre " + (++contador));
        mA.notifyItemInserted(position);
        mL.scrollToPosition(position); //lleva el scroll a la pocision donde se agregó el item
    }
    public void deleteName(int position){
        nombres.remove(position);
        mA.notifyItemRemoved(position);

    }

    @Override
    public void sendData(String text) {
        if(multipanel){
            DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.data_detail_f);
            detailFragment.renderText(text);
        }else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("text", text);
            startActivity(intent);
        }

    }

    public void setMultipanel(){
        multipanel = (getSupportFragmentManager().findFragmentById(R.id.data_detail_f) != null);
    }
}
