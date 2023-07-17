package com.example.shoppingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    EditText et_name,et_gmail,et_phone;
    ImageView iv_edit_data,iv_edit_photo,iv_photo;
    Button btn_save;
    TextView tv_full_name,tv_user_name;
    LinearLayout layout_name;
    Uri imageUri;
    SharedPreferences shp_id;
    private static final int PICK_IMAGE_REQ_COD = 1;
    SharedPreferences.Editor shpEditor_id;
    ShoppingDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("My Profile");

        et_name = findViewById(R.id.et_full_name_profile);
        et_gmail = findViewById(R.id.et_gmail_user_profile);
        et_phone = findViewById(R.id.et_phone_user_profile);
        iv_edit_data = findViewById(R.id.iv_edit_data);
        iv_edit_photo = findViewById(R.id.iv_edit_photo);
        iv_photo = findViewById(R.id.ri_profile_image);
        btn_save = findViewById(R.id.btn_save_data);
        tv_full_name = findViewById(R.id.tv_full_name_profile);
        tv_user_name = findViewById(R.id.tv_user_name_profile);
        layout_name = findViewById(R.id.enter_name);

        shp_id = getSharedPreferences("Preferences_id", MODE_PRIVATE);

        int user_id = shp_id.getInt("user_id",0);

        db = new ShoppingDatabase(this);

        Users users = db.getUser(user_id);
        et_name.setText(users.getFullName());
        et_gmail.setText(users.getEmail());
        et_phone.setText(users.getPhone());
        if(users.getUserImage()!=null && !users.getUserImage().equals("")){
            imageUri = Uri.parse(users.getUserImage());
            iv_photo.setImageURI(imageUri);
        }else{
            iv_photo.setImageResource(R.drawable.man);
        }
        tv_full_name.setText(users.getFullName());
        tv_user_name.setText(users.getUserName());


        iv_edit_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_edit_data.setVisibility(View.INVISIBLE);
                btn_save.setVisibility(View.VISIBLE);
                et_name.setEnabled(true);
                et_gmail.setEnabled(true);
                et_phone.setEnabled(true);
                iv_edit_photo.setVisibility(View.VISIBLE);
                layout_name.setVisibility(View.VISIBLE);
            }
        });


        iv_edit_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(in,PICK_IMAGE_REQ_COD);
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get data

                String name = et_name.getText().toString();
                String gmail = et_gmail.getText().toString();
                String phone = et_phone.getText().toString();
                String image = "";
                if(imageUri != null){
                    image = imageUri.toString();
                }

                db.upDataUser(new Users(user_id,name,image,gmail,phone));

                Users user = db.getUser(user_id);
                et_name.setText(user.getFullName());
                et_gmail.setText(user.getEmail());
                et_phone.setText(user.getPhone());
                if(user.getUserImage()!=null && !user.getUserImage().equals("")){
                    iv_photo.setImageURI(Uri.parse(user.getUserImage()));
                }else{
                    iv_photo.setImageResource(R.drawable.man);
                }
                tv_full_name.setText(user.getFullName());

                iv_edit_data.setVisibility(View.VISIBLE);
                btn_save.setVisibility(View.GONE);
                et_name.setEnabled(false);
                et_gmail.setEnabled(false);
                et_phone.setEnabled(false);
                iv_edit_photo.setVisibility(View.GONE);
                layout_name.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQ_COD && resultCode == RESULT_OK){
            if(data != null){
                imageUri = data.getData();
                iv_photo.setImageURI(imageUri);
            }
        }
    }

}