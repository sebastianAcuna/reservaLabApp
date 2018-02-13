package com.example.sebastian.reservalabapp.actividades;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.sebastian.reservalabapp.R;
import com.example.sebastian.reservalabapp.fragments.DetailFragment;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.AlertFragment;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.EmailFragment;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.InfoFragment;

public class Email extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout; //necesario para el  drawer layout
    private SharedPreferences prefs;
    private TextView user_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        navigationView = findViewById(R.id.navView);
        user_name = navigationView.getHeaderView(0).findViewById(R.id.name_user_lb);
        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        logInOut();

        navigationView.getMenu().getItem(2).setChecked(true);

        setToolbar();
        EmailFragment emailFragment = (EmailFragment) getSupportFragmentManager().findFragmentById(R.id.email_fragment);

        drawerLayout = findViewById(R.id.drawer_layout); //se setea segun id que pusiste en el layout
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
                        if(item.getTitle() == "Iniciar Sesión"){
                            Intent LoginIntent = new Intent(Email.this, Login.class);
                            startActivity(LoginIntent);
                        }else{
                            LogOut();
                        }
                        break;
                    case R.id.menu_home:
                        Intent homeIntent = new Intent(Email.this, MainActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.menu_email:
                        Intent emailIntent = new Intent(Email.this, Email.class);
                        startActivity(emailIntent);
                        /*fragment = new EmailFragment();
                        fragentTransaction = true;*/
                        break;
                    case R.id.menu_alert:
                        fragment = new AlertFragment();
                        fragentTransaction = true;
                        break;
                    case R.id.menu_info:
                        //deberia mostrar alerta con la informacion de el desarrollador
                        fragment = new InfoFragment();
                        fragentTransaction = true;
                        break;
                }
                if(fragentTransaction){
                    //changeFragment(fragment, item);
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




    private void logInOut(){
        boolean session = prefs.getBoolean("session", false);
        if(session){
            navigationView.getMenu().getItem(0).setTitle("Cerrar Sesión").setIcon(R.drawable.ic_logout);
            user_name.setText(prefs.getString("email", ""));
        }else{
            navigationView.getMenu().getItem(0).setTitle("Iniciar Sesión").setIcon(R.drawable.ic_login);
            user_name.setText("INVITADO");
        }
    }

    private void LogOut(){
        prefs.edit().clear().apply();
        navigationView.getMenu().getItem(0).setTitle("Iniciar Sesión").setIcon(R.drawable.ic_login);
        user_name.setText("INVITADO");
    }
}
