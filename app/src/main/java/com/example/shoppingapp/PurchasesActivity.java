package com.example.shoppingapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PurchasesActivity extends AppCompatActivity {

    ListView lv;
    PurchasesAdapter pa;
    ShoppingDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchases);

        lv = findViewById(R.id.lv_purchases);

        db = new ShoppingDatabase(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("purchases");

        ArrayList<Products> p = new ArrayList<>();
        p = db.getAllProductsInPurchases();
        pa = new PurchasesAdapter(p,this);
        pa.notifyDataSetChanged();
        lv.setAdapter(pa);

    }
}