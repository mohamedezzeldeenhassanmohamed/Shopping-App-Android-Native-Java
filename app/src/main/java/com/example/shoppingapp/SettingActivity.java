package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;

public class SettingActivity extends AppCompatActivity {

    SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Setting s = new Setting();
        fragmentTransaction.replace(R.id.settings,s);
        fragmentTransaction.commit();

//        sh = getSharedPreferences("myPreferences", MODE_PRIVATE);
//        boolean stats = sh.getBoolean("dark_mood_screen",false);
//
//        if(stats == true){
//            setTheme(androidx.preference.R.style.ThemeOverlay_AppCompat_Dark);
//        }else{
//            setTheme(com.airbnb.lottie.R.style.Theme_AppCompat_DayNight);
//        }

    }
}