package com.example.shoppingapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CardView fashion_card,book_card,beauty_card,electrics_card,game_card,homeCooker_card,laptop_card,mobile_card,sports_card,carTools_card;
    TextView tv_fashion,tv_book,tv_beauty,tv_electrics,tv_game,tv_home,tv_laptop,tv_mobile,tv_sports,tv_car;
    public static final String FASHION_KEY = "fashion_key";
    public static final String BOOK_KEY = "book_key";
    public static final String BEAUTY_KEY = "beauty_key";
    public static final String ELECTRICS_KEY = "electrics_key";
    public static final String GAME_KEY = "game_key";
    public static final String HOME_KEY = "home_key";
    public static final String LAPTOP_KEY = "laptop_key";
    public static final String MOBILE_KEY = "mobile_key";
    public static final String SPORTS_KEY = "sports_key";
    public static final String CAR_KEY = "car_key";
    public static String name_data ="";

    ShoppingDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fashion_card = findViewById(R.id.fashion_card);
        book_card = findViewById(R.id.book_card);
        beauty_card = findViewById(R.id.beauty_card);
        electrics_card = findViewById(R.id.electronics_card);
        game_card = findViewById(R.id.games_card);
        homeCooker_card = findViewById(R.id.home_cooker_card);
        laptop_card = findViewById(R.id.laptop_card);
        mobile_card = findViewById(R.id.mobiles_card);
        sports_card = findViewById(R.id.sports_card);
        carTools_card = findViewById(R.id.car_card);
        tv_fashion = findViewById(R.id.tv_fashion_card);
        tv_book = findViewById(R.id.tv_books_card);
        tv_beauty = findViewById(R.id.tv_beauty_card);
        tv_electrics = findViewById(R.id.tv_electronics_card);
        tv_game = findViewById(R.id.tv_game_card);
        tv_home = findViewById(R.id.tv_home_card);
        tv_laptop = findViewById(R.id.tv_laptop_card);
        tv_mobile = findViewById(R.id.tv_mobile_card);
        tv_sports = findViewById(R.id.tv_sports_card);
        tv_car = findViewById(R.id.tv_car_card);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Products");


        db = new ShoppingDatabase(this);
//        Products p = new Products(R.drawable.python,"python",32.0,"Electronic Book",23,"Python is a computer programming language often used to build websites and software, automate tasks, and conduct data analysis.",0);
//
//        db.insertProduct(p,ShoppingDatabase.TB_BOOK);

        fashion_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_fashion.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(FASHION_KEY,tv_fashion.getText().toString());
                startActivity(intent);
            }
        });

        book_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_book.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(BOOK_KEY,tv_book.getText().toString());
                startActivity(intent);
            }
        });

        beauty_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_beauty.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(BEAUTY_KEY,tv_beauty.getText().toString());
                startActivity(intent);
            }
        });

        electrics_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_electrics.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(ELECTRICS_KEY,tv_electrics.getText().toString());
                startActivity(intent);
            }
        });

        game_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_game.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(GAME_KEY,tv_game.getText().toString());
                startActivity(intent);
            }
        });

        homeCooker_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_home.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(HOME_KEY,tv_home.getText().toString());
                startActivity(intent);
            }
        });

        laptop_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_laptop.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(LAPTOP_KEY,tv_laptop.getText().toString());
                startActivity(intent);
            }
        });

        mobile_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_mobile.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(MOBILE_KEY,tv_mobile.getText().toString());
                startActivity(intent);
            }
        });

        sports_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_sports.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(SPORTS_KEY,tv_sports.getText().toString());
                startActivity(intent);
            }
        });

        carTools_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_car.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(CAR_KEY,tv_car.getText().toString());
                startActivity(intent);
            }
        });

    }
}