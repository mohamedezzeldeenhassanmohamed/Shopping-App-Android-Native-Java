package com.example.shoppingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayProductsActivity extends AppCompatActivity {

    RatingBar rb;
    ImageView product_img;
    TextView tv_rating,product_name,Product_price,Product_discount,Product_brand,Product_pieces,Product_description;
    Spinner product_quantity;
    Button add_to_cart;
    double priceAfter;

    ShoppingDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_products);

        rb = findViewById(R.id.ratingBar);
        product_img = findViewById(R.id.display_iv_product);
        product_name = findViewById(R.id.display_tv_name);
        Product_price = findViewById(R.id.display_tv_price);
        Product_discount = findViewById(R.id.display_tv_discount);
        Product_brand = findViewById(R.id.display_tv_brand);
        Product_pieces = findViewById(R.id.display_tv_pieces);
        Product_description = findViewById(R.id.display_tv_description);
        product_quantity = findViewById(R.id.display_get_quantity);
        add_to_cart = findViewById(R.id.display_btn_cart);
        tv_rating = findViewById(R.id.display_rating_number);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tv_rating.setText(v+"");
            }
        });
        int product_id;
        String table_name;
        if(HomeActivity.flag == true){
            Intent intent = getIntent();
            product_id = intent.getIntExtra(HomeActivity.PRODUCT_KEY,-1);
            table_name = intent.getStringExtra(HomeActivity.TABLE_NAME_KEY);
        }else{
            Intent intent = getIntent();
            product_id = intent.getIntExtra(ProductsCardActivity.PRODUCT_ID_KEY,-1);
            table_name = intent.getStringExtra(ProductsCardActivity.TABLE_NAME_KEY);
        }

        db = new ShoppingDatabase(this);
        Products p = db.getProduct(product_id,table_name);

        if(p.getImage() != 0)
            product_img.setImageResource(p.getImage());
        product_name.setText(p.getName());
        if (p.getDiscount() > 0) {
            priceAfter = p.getPrice() - (p.getPrice() * (p.getDiscount() / 100));
            Product_discount.setText(priceAfter + "$");
            Product_price.setText(p.getPrice()+"$");
            Product_price.setPaintFlags(Product_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);//وضع خط علي السعر القديم
            Product_price.setTextColor(Color.parseColor("#BFBFBF"));
        } else {
            priceAfter = p.getPrice();
            Product_discount.setText("");
            Product_price.setText(priceAfter + "$");
            Product_price.setTextColor(Color.parseColor("#000000"));
        }
        Product_brand.setText(p.getBrand());
        Product_pieces.setText(p.getPieces()+"");
        Product_description.setText(p.getDescription());

        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int image = p.getImage();
                String name = product_name.getText().toString();
                String brand = Product_brand.getText().toString();
                int quantity = Integer.parseInt(product_quantity.getSelectedItem().toString());
                float rating = Float.parseFloat(tv_rating.getText().toString());
                
                Products ppp = new Products(image,name,priceAfter,brand,rating,quantity);

                AlertDialog alertDialog = new AlertDialog.Builder(DisplayProductsActivity.this).create();
                alertDialog.setTitle(name);
                alertDialog.setMessage("Click (Ok) TO Add This Product To Cart");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        db.insertProductInPurchases(ppp);
                        Toast.makeText(DisplayProductsActivity.this, "Purchased Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                alertDialog.show();
            }
        });

    }
}