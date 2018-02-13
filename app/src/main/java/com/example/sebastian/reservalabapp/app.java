package com.example.sebastian.reservalabapp;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by sebastian on 12-02-2018.
 */

public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }
}
