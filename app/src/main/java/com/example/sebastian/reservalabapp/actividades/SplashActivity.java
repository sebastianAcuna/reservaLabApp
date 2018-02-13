package com.example.sebastian.reservalabapp.actividades;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

public class SplashActivity extends AppCompatActivity {
private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        if(!TextUtils.isEmpty(prefs.getString("email", "")) && !TextUtils.isEmpty(prefs.getString("pass", ""))){
            Intent it = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(it);
        }else{
            Intent it = new Intent(SplashActivity.this, Login.class);
            startActivity(it);
        }
        finish();

    }
}
