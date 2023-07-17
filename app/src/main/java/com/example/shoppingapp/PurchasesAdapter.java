package com.example.shoppingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PurchasesAdapter extends BaseAdapter {

    ArrayList<Products> purchases;
    Context context;

    public PurchasesAdapter(ArrayList<Products> purchases, Context context) {
        this.purchases = purchases;
        this.context = context;
    }

    @Override
    public int getCount() {
        return purchases.size();
    }

    @Override
    public Products getItem(int i) {
        return purchases.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;
        if(v==null){
            v = LayoutInflater.from(context).inflate(R.layout.custome_purchases_products,null,false);
        }

        ImageView img = (ImageView) v.findViewById(R.id.img_products_purchases);
        TextView tv_name = v.findViewById(R.id.tv_name_purchases);
        TextView tv_price = v.findViewById(R.id.tv_price_purchases);
        TextView tv_brand = v.findViewById(R.id.tv_brand_purchases);
        RatingBar rating = v.findViewById(R.id.rating_purchases);
        TextView tv_quantity = v.findViewById(R.id.tv_quantity);

        Products p = getItem(i);
        if(p.getImage() != 0){
            img.setImageResource(p.getImage());
        }else{
            img.setImageResource(R.drawable.products);
        }
        tv_name.setText(p.getName());
        tv_price.setText(p.getPrice()+"$");
        tv_brand.setText(p.getBrand());
        rating.setRating(p.getRating());
        tv_quantity.setText(p.getQuantity()+"");

        return v;
    }
}
