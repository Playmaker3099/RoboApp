package com.example.introclass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity
{
    EditText edtUsername, edtPassword;

    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin.setOnClickListener(v ->{
            SharedPreferences storePreference = getSharedPreferences("RoboPrefs", MODE_PRIVATE);
            SharedPreferences.Editor sharedPrefsEditor = storePreference.edit();

            sharedPrefsEditor.putString("username", edtUsername.getText().toString());
            sharedPrefsEditor.apply();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            /*Toast
            * We use a toast to display message to the user.*/
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
        });
    }
}
