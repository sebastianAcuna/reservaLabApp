package com.example.sebastian.reservalabapp.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sebastian.reservalabapp.R;
import com.example.sebastian.reservalabapp.adaptadores.PagerAdapter;
import com.example.sebastian.reservalabapp.fragments.DetailFragment;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.AlertFragment;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.EmailFragment;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.InfoFragment;
import com.example.sebastian.reservalabapp.fragments.testFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout; //necesario para el  drawer layout
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar(); //instancio el action bar
        navigationView = findViewById(R.id.navView);
        setFragmentByDefault();

        TabLayout tabLayout = findViewById(R.id.tab_menu);
        //agrego los tabs
        tabLayout.addTab(tabLayout.newTab().setText("Circulares"));
        tabLayout.addTab(tabLayout.newTab().setText("Calendario"));
        tabLayout.addTab(tabLayout.newTab().setText("Solicitud"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL); //para que tomen todoo el ancho

        //instancio el adaptador que cambiara entre los tabs
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        //bindeo el viewpager para identificar si arrastro para moverme entre tabs
        final ViewPager viewPager = findViewById(R.id.viewPager);
        //seteo adaptador
        viewPager.setAdapter(adapter);
        //creo un listener para identificar algun cambio entre los tabs
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //creo un listener para identificar algun cambio al seleccionar un tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //para el tab seleccionado se obtiene la posicion del tab y se envia al adapador para hacer el cambio
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //identifica el tab que anterior al seleccionado
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //identifica si selecciona el tab ya seleccionado
            }
        });


        drawerLayout = findViewById(R.id.drawer_layout); //se setea segun id que pusiste en el layout
        NavigationView navigationView = findViewById(R.id.navView);


        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //Toast.makeText(MainActivity.this, "Open", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                //Toast.makeText(MainActivity.this, "Close", Toast.LENGTH_SHORT).show();
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

                    case R.id.menu_login:
                        fragment = new EmailFragment();
                        fragentTransaction = true;
                        break;
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

    //setea la barra de herramientas
    private void setToolbar(){
        Toolbar myToolbar =  findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home); //relaciona el icono en la barra
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //habilita el icono en la barra
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
