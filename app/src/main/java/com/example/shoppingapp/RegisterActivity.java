package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView tv_login;
    EditText et_user_name,et_full_name,et_user_email,et_user_password,et_user_ConformPassword,et_user_phone;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tv_login  = findViewById(R.id.et_login_from_register);
        et_user_name = findViewById(R.id.et_user_name_register);
        et_full_name = findViewById(R.id.et_full_name_register);
        et_user_email = findViewById(R.id.et_user_email_register);
        et_user_password = findViewById(R.id.et_user_password_register);
        et_user_ConformPassword = findViewById(R.id.et_user_ConformPassword_register);
        et_user_phone = findViewById(R.id.et_user_phone_register);
        btn_register = findViewById(R.id.btn_register_from_register);

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        ShoppingDatabase db = new ShoppingDatabase(this);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = 0;

                if(et_user_name.getText().toString().isEmpty()){
                    et_user_name.setError("Please Enter Your User Name");
                }else{
                    c++;
                }
                if(et_full_name.getText().toString().isEmpty()){
                    et_full_name.setError("Please Enter Your Full Name");
                }else{
                    c++;
                }
                if(et_user_email.getText().toString().isEmpty()){
                    et_user_email.setError("Please Enter Your Email");
                }else{
                    c++;
                }
                if(et_user_password.getText().toString().isEmpty()){
                    et_user_password.setError("Please Enter Your password");
                }else{
                    c++;
                }
                if(et_user_ConformPassword.getText().toString().isEmpty()){
                    et_user_ConformPassword.setError("Please Enter Your password");
                }else{
                    if(et_user_password.getText().toString().equals(et_user_ConformPassword.getText().toString())){
                        c++;
                    }else {
                        Toast.makeText(RegisterActivity.this, "ConformPassword not equals Password", Toast.LENGTH_SHORT).show();
                    }
                }
                if(et_user_phone.getText().toString().isEmpty()){
                    et_user_phone.setError("Please Enter Your Phone");
                }else{
                    c++;
                }

                if(c == 6){
                    db.insertUser(new Users(et_user_name.getText().toString(),
                                            et_full_name.getText().toString(),
                                            R.drawable.user+"",
                                            et_user_password.getText().toString(),
                                            et_user_email.getText().toString(),
                                            et_user_phone.getText().toString()));
                    Toast.makeText(RegisterActivity.this, "successfully registered", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });



    }
}