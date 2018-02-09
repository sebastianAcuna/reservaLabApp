package com.example.sebastian.reservalabapp.actividades;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sebastian.reservalabapp.R;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.AlertFragment;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.EmailFragment;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.InfoFragment;


public class Drawer extends AppCompatActivity {

    private DrawerLayout drawerLayout; //necesario para el  drawer layout
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        setToolbar();


        drawerLayout = findViewById(R.id.drawer_layout); //se setea segun id que pusiste en el layout
        navigationView = findViewById(R.id.navView);
        setFragmentByDefault();


        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(Drawer.this, "Open", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(Drawer.this, "Close", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //menu item en donde hagamos click
                boolean fragentTransaction = false;
                Fragment fragment = null;
                switch (item.getItemId()){

                    case R.id.menu_email:
                        fragment = new EmailFragment();
                        fragentTransaction = true;
                        break;
                    case R.id.menu_alert:
                        fragment = new AlertFragment();
                        fragentTransaction = true;
                        break;
                    case R.id.menu_info:
                        fragment = new InfoFragment();
                        fragentTransaction = true;
                        break;
                }

                if(fragentTransaction){
                    changeFragment(fragment, item);
                    drawerLayout.closeDrawer(GravityCompat.START);
                }


                return false;
            }
        });


    }

    //setea la barra de herramientas
    private void setToolbar(){
        Toolbar myToolbar =  findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home); //relaciona el icono en la barra
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //habilita el icono en la barra
    }

    private void changeFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame,fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }

    private void setFragmentByDefault(){
        changeFragment(new EmailFragment(),navigationView.getMenu().getItem(0) );
    }

    //abre el menu lateral al apretar el boton sandwich
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
