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
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.sebastian.reservalabapp.R;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.AlertFragment;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.EmailFragment;
import com.example.sebastian.reservalabapp.fragments.menu_fragments.InfoFragment;

public class Login extends AppCompatActivity {

    private SharedPreferences prefs;
    private DrawerLayout drawerLayout; //necesario para el  drawer layout
    private NavigationView navigationView;

    private Button btn_login;
    private EditText et_email;
    private EditText et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        setToolbar(); //instancio el action bar

        btn_login = findViewById(R.id.btn_login);
        et_email = findViewById(R.id.et_login_email);
        et_pass = findViewById(R.id.et_login_pass);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //realizar login
                String email = et_email.getText().toString();
                String pass = et_pass.getText().toString();
                if(login(email,pass)){
                    saveOnPreference(email, pass);
                    goToMain();
                }
            }
        });
    }

    //setea la barra de herramientas
    private void setToolbar(){
        Toolbar myToolbar =  findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_button); //relaciona el icono en la barra
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //habilita el icono en la barra
    }

    //abre el menu lateral al apretar el boton sandwich
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent mainIntent = new Intent(Login.this, MainActivity.class);
                startActivity(mainIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean login(String email, String pass){
        if(!isValidEmail(email))  {
            Toast.makeText(this, "Email invalido, ingrese un Email valido ", Toast.LENGTH_LONG).show();
            return false;
        }
        else if(!isValidPass(pass)) {
            Toast.makeText(this, "Contraseña invalida, Ingrese una valida", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }

    private void saveOnPreference(String email, String pass){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("email",email);
        editor.putString("pass",pass);
        editor.putBoolean("session", true);
        editor.apply();
    }
    private void goToMain(){
        Intent goMain = new Intent(this, MainActivity.class);
        goMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(goMain);
    }

    private boolean isValidEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPass(String pass){
        return pass.length() > 4;
    }

}
