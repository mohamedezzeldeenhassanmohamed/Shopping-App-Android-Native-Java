package com.example.shoppingapp;

import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<Products> products;
    OnRecyclerViewClickListener listener;

    public ProductAdapter(ArrayList<Products> products, OnRecyclerViewClickListener listener) {
        this.products = products;
        this.listener = listener;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_card_products,null,false);
        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Products p = products.get(position);
        if(p.getImage() != 0){
            holder.img.setImageResource(p.getImage());
        }else{
            holder.img.setImageResource(R.drawable.products);
        }
        holder.name.setText(p.getName());
        holder.price.setText(p.getPrice()+"$");
        holder.brand.setText("Brand: "+p.getBrand());
        holder.number_pieces.setText(p.getPieces()+"");
        if(p.getDiscount()>0){
            holder.priceAfter.setText(p.getPrice()-(p.getPrice()*(p.getDiscount()/100))+"$");
            holder.price.setPaintFlags(holder.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);//وضع خط علي السعر القديم
            holder.price.setTextColor(Color.parseColor("#BFBFBF"));
        }else{
            holder.priceAfter.setText("");
            holder.price.setTextColor(Color.parseColor("#000000"));
        }

        holder.name.setTag(position+1); //اوبجكت مخفي لكي اخزن product_id
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name,price,brand,number_pieces,priceAfter;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_card_products);
            name = itemView.findViewById(R.id.tv_name_card_products);
            price = itemView.findViewById(R.id.tv_price_card_products);
            brand = itemView.findViewById(R.id.tv_brand_card_products);
            number_pieces = itemView.findViewById(R.id.tv_mun_pieces_card_products);
            priceAfter = itemView.findViewById(R.id.tv_priceafter_card_products);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = (int)name.getTag();
                    listener.OnItemClick(id);
                }
            });

        }
    }

}
