package com.example.sebastian.reservalabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sebastian.reservalabapp.fragments.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(getIntent().getExtras() != null){
            text = getIntent().getStringExtra("text");

            DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.data_detail_f);
            detailFragment.renderText(text);
        }
    }
}
