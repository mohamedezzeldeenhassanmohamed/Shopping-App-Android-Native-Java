package com.example.shoppingapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ShoppingDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "shopping_db";
    public static final int DB_VERSION = 1;

    public static final String TB_FASHION = "fashion";
    public static final String TB_BOOK = "book";
    public static final String TB_BEAUTY = "beauty";
    public static final String TB_ELECTRICS = "electrics";
    public static final String TB_GAME = "game";
    public static final String TB_HOME_COOKER = "homeCooker";
    public static final String TB_LAPTOP = "laptop";
    public static final String TB_MOBILE = "mobile";
    public static final String TB_SPORTS = "sports";
    public static final String TB_CAR_TOOL = "carTools";
    public static final String TB_USERS = "users";
    public static final String TB_PURCHASES = "purchases";
    public static final String TB_PRODUCT_DISCOUNT = "product_discount";

    public static final String TB_CLM_ID = "id";
    public static final String TB_CLM_IMAGE = "image";
    public static final String TB_CLM_NAME = "name";
    public static final String TB_CLM_PRICE = "price";
    public static final String TB_CLM_BRAND = "brand";
    public static final String TB_CLM_PIECES = "pieces";
    public static final String TB_CLM_DESCRIPTION = "description";
    public static final String TB_CLM_DISCOUNT = "discount";
    public static final String TB_CLM_RATING = "rating";
    public static final String TB_CLM_QUANTITY = "quantity";

    public static final String TB_CLM_USER_ID = "user_id";
    public static final String TB_CLM_USER_NAME = "user_name";
    public static final String TB_CLM_USER_FULL_NAME = "full_name";
    public static final String TB_CLM_USER_PASSWORD = "user_password";
    public static final String TB_CLM_USER_EMAIL = "user_email";
    public static final String TB_CLM_USER_PHONE = "user_phone";
    public static final String TB_CLM_USER_IMAGE = "user_image";

    public ShoppingDatabase(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(createTables(TB_FASHION));
        sqLiteDatabase.execSQL(createTables(TB_BOOK));
        sqLiteDatabase.execSQL(createTables(TB_BEAUTY));
        sqLiteDatabase.execSQL(createTables(TB_ELECTRICS));
        sqLiteDatabase.execSQL(createTables(TB_GAME));
        sqLiteDatabase.execSQL(createTables(TB_HOME_COOKER));
        sqLiteDatabase.execSQL(createTables(TB_LAPTOP));
        sqLiteDatabase.execSQL(createTables(TB_MOBILE));
        sqLiteDatabase.execSQL(createTables(TB_SPORTS));
        sqLiteDatabase.execSQL(createTables(TB_CAR_TOOL));
        sqLiteDatabase.execSQL(createTables(TB_PRODUCT_DISCOUNT));

        sqLiteDatabase.execSQL("CREATE TABLE "+TB_USERS+" ("+TB_CLM_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+TB_CLM_USER_NAME+" TEXT UNIQUE , "+
                TB_CLM_USER_FULL_NAME+" TEXT , "+TB_CLM_USER_PASSWORD+" TEXT , "+TB_CLM_USER_EMAIL+" TEXT UNIQUE , "+TB_CLM_USER_PHONE+" TEXT , "+TB_CLM_USER_IMAGE+" TEXT );");


        sqLiteDatabase.execSQL("CREATE TABLE "+TB_PURCHASES+" ("+TB_CLM_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+TB_CLM_IMAGE+" INTEGER , "+
                TB_CLM_NAME+" TEXT , "+TB_CLM_PRICE+" REAL , "+TB_CLM_BRAND+" TEXT , "+TB_CLM_RATING+" REAL , "+TB_CLM_QUANTITY+" INTEGER );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public String createTables(String tableName){
        return "CREATE TABLE "+tableName+" ("+TB_CLM_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+TB_CLM_IMAGE+" INTEGER , "+
                TB_CLM_NAME+" TEXT , "+TB_CLM_PRICE+" REAL , "+TB_CLM_BRAND+" TEXT , "+TB_CLM_PIECES+" INTEGER , "+
                TB_CLM_DESCRIPTION+" TEXT , "+TB_CLM_DISCOUNT+" REAL) ; ";
    }


    public boolean insertProduct(Products p,String tableName){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TB_CLM_IMAGE,p.getImage());
        values.put(TB_CLM_NAME,p.getName());
        values.put(TB_CLM_PRICE,p.getPrice());
        values.put(TB_CLM_BRAND,p.getBrand());
        values.put(TB_CLM_PIECES,p.getPieces());
        values.put(TB_CLM_DESCRIPTION,p.getDescription());
        values.put(TB_CLM_DISCOUNT,p.getDiscount());

        long res = db.insert(tableName,null,values);
        db.close();
        if(p.getDiscount()>0){
            insertProductDiscount(p);
        }
        return res != -1;
    }

    public boolean insertProductDiscount(Products p){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TB_CLM_IMAGE,p.getImage());
        values.put(TB_CLM_NAME,p.getName());
        values.put(TB_CLM_PRICE,p.getPrice());
        values.put(TB_CLM_BRAND,p.getBrand());
        values.put(TB_CLM_PIECES,p.getPieces());
        values.put(TB_CLM_DESCRIPTION,p.getDescription());
        values.put(TB_CLM_DISCOUNT,p.getDiscount());

        long ress = db.insert(TB_PRODUCT_DISCOUNT,null,values);
        db.close();

        return ress != -1;
    }

    public ArrayList<Products> getAllProducts(String tableName){
        ArrayList<Products> products = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tableName+"",null);

        if(cursor.moveToFirst()){
            do{
                @SuppressLint("Range") int image = cursor.getInt(cursor.getColumnIndex(TB_CLM_IMAGE));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(TB_CLM_NAME));
                @SuppressLint("Range") Double price = cursor.getDouble(cursor.getColumnIndex(TB_CLM_PRICE));
                @SuppressLint("Range") String brand = cursor.getString(cursor.getColumnIndex(TB_CLM_BRAND));
                @SuppressLint("Range") int pieces = cursor.getInt(cursor.getColumnIndex(TB_CLM_PIECES));
                @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex(TB_CLM_DESCRIPTION));
                @SuppressLint("Range") double discount = cursor.getDouble(cursor.getColumnIndex(TB_CLM_DISCOUNT));

                Products p = new Products(image,name,price,brand,pieces,description,discount);
                products.add(p);
            }while (cursor.moveToNext());
                cursor.close();
        }
        db.close();
        return products;
    }

    public Products getProduct(int product_id,String tableName){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tableName+" WHERE "+TB_CLM_ID+" =?",new String[]{String.valueOf(product_id)});

        if(cursor.moveToFirst() && cursor != null){
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(TB_CLM_ID));
            @SuppressLint("Range") int image = cursor.getInt(cursor.getColumnIndex(TB_CLM_IMAGE));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(TB_CLM_NAME));
            @SuppressLint("Range") Double price = cursor.getDouble(cursor.getColumnIndex(TB_CLM_PRICE));
            @SuppressLint("Range") String brand = cursor.getString(cursor.getColumnIndex(TB_CLM_BRAND));
            @SuppressLint("Range") int pieces = cursor.getInt(cursor.getColumnIndex(TB_CLM_PIECES));
            @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex(TB_CLM_DESCRIPTION));
            @SuppressLint("Range") double discount = cursor.getDouble(cursor.getColumnIndex(TB_CLM_DISCOUNT));

            Products p = new Products(id,image,name,price,brand,pieces,description,discount);
            cursor.close();
            db.close();
            return p;
        }
        return null;
    }

    public ArrayList<Products> getProductForSearch(String nameProduct, String tableName){
        ArrayList<Products> products = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tableName+" WHERE "+TB_CLM_NAME+" =?",new String[]{String.valueOf(nameProduct)});

        if(cursor.moveToFirst() && cursor != null){
            do{
                @SuppressLint("Range") int image = cursor.getInt(cursor.getColumnIndex(TB_CLM_IMAGE));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(TB_CLM_NAME));
                @SuppressLint("Range") Double price = cursor.getDouble(cursor.getColumnIndex(TB_CLM_PRICE));
                @SuppressLint("Range") String brand = cursor.getString(cursor.getColumnIndex(TB_CLM_BRAND));
                @SuppressLint("Range") int pieces = cursor.getInt(cursor.getColumnIndex(TB_CLM_PIECES));
                @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex(TB_CLM_DESCRIPTION));
                @SuppressLint("Range") double discount = cursor.getDouble(cursor.getColumnIndex(TB_CLM_DISCOUNT));

                Products p = new Products(image,name,price,brand,pieces,description,discount);
                products.add(p);
            }while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return products;
    }

    public boolean deleteProduct(Products products,String tableName){
        SQLiteDatabase database = getWritableDatabase();
        String args [] = new String[]{products.getId()+""};
        long result = database.delete(tableName,TB_CLM_ID+"=?",args);
        return result > 0;
    }

    public boolean insertProductInPurchases(Products p){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TB_CLM_IMAGE,p.getImage());
        values.put(TB_CLM_NAME,p.getName());
        values.put(TB_CLM_PRICE,p.getPrice());
        values.put(TB_CLM_BRAND,p.getBrand());
        values.put(TB_CLM_RATING,p.getRating());
        values.put(TB_CLM_QUANTITY,p.getQuantity());

        long res = db.insert(TB_PURCHASES,null,values);
        db.close();
        return res != -1;
    }

    public ArrayList<Products> getAllProductsInPurchases(){
        ArrayList<Products> products = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TB_PURCHASES+"",null);

        if(cursor.moveToFirst() && cursor != null){
            do{
                @SuppressLint("Range") int image = cursor.getInt(cursor.getColumnIndex(TB_CLM_IMAGE));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(TB_CLM_NAME));
                @SuppressLint("Range") Double price = cursor.getDouble(cursor.getColumnIndex(TB_CLM_PRICE));
                @SuppressLint("Range") String brand = cursor.getString(cursor.getColumnIndex(TB_CLM_BRAND));
                @SuppressLint("Range") float rating = cursor.getFloat(cursor.getColumnIndex(TB_CLM_RATING));
                @SuppressLint("Range") int quantity = cursor.getInt(cursor.getColumnIndex(TB_CLM_QUANTITY));

                Products p = new Products(image,name,price,brand,rating,quantity);
                products.add(p);
            }while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return products;
    }

    public boolean insertUser(Users user){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TB_CLM_USER_NAME,user.getUserName());
        values.put(TB_CLM_USER_FULL_NAME,user.getFullName());
        values.put(TB_CLM_USER_PASSWORD,user.getUserPassword());
        values.put(TB_CLM_USER_EMAIL,user.getEmail());
        values.put(TB_CLM_USER_PHONE,user.getPhone());
        values.put(TB_CLM_USER_IMAGE,user.getUserImage());

        long res = db.insert(TB_USERS,null,values);
        db.close();
        return res != -1;
    }

    public Users getUser(int user_id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TB_USERS+" WHERE "+TB_CLM_USER_ID+" =?",new String[]{String.valueOf(user_id)});

        if(cursor.moveToFirst() && cursor != null){
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(TB_CLM_USER_ID));
            @SuppressLint("Range") String userName = cursor.getString(cursor.getColumnIndex(TB_CLM_USER_NAME));
            @SuppressLint("Range") String fullName = cursor.getString(cursor.getColumnIndex(TB_CLM_USER_FULL_NAME));
            @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(TB_CLM_USER_PASSWORD));
            @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(TB_CLM_USER_EMAIL));
            @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex(TB_CLM_USER_PHONE));
            @SuppressLint("Range") String image = cursor.getString(cursor.getColumnIndex(TB_CLM_USER_IMAGE));

            Users user = new Users(id,userName,fullName,image,password,email,phone);
            cursor.close();
            db.close();
            return user;
        }
        return null;
    }

    public boolean upDataUser(Users user){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TB_CLM_USER_FULL_NAME,user.getFullName());
        values.put(TB_CLM_USER_EMAIL,user.getEmail());
        values.put(TB_CLM_USER_PHONE,user.getPhone());
        values.put(TB_CLM_USER_IMAGE,user.getUserImage());

        String args [] = new String[]{user.getId()+""};
        long result = db.update(TB_USERS, values,TB_CLM_USER_ID+"=?",args);
        db.close();
        return result > 0;

    }

    @SuppressLint("Range")
    public int checkUser(String user_name, String password){
        SQLiteDatabase db = getReadableDatabase();
        String[] selectionArgs = {user_name, password};
        String[] columns = {TB_CLM_USER_ID};

        Cursor cursor = db.query(TB_USERS,columns,TB_CLM_USER_NAME+" =? AND "+TB_CLM_USER_PASSWORD+" =?",selectionArgs,null,null,null);
        int id=0;
        int cursorCount = cursor.getCount();

        if (cursorCount > 0) {
            cursor.moveToFirst();
            id = cursor.getInt(cursor.getColumnIndex(TB_CLM_USER_ID));
            cursor.close();
            db.close();
            return id;
        }

        return id;
    }

}
