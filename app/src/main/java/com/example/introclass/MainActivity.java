package com.example.introclass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Button btnRed,btnYellow, btnGreen;
    Button insert;

    //private DBHelper dbhelper;
    EditText edtName, edtRoboname;

    TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        tvUsername = findViewById(R.id.tvUsername);
        SharedPreferences preferences = getSharedPreferences("RoboPrefs", MODE_PRIVATE);
        String username = preferences.getString("username", "");

        //SharedPreference
        //edtName = findViewById(R.id.edtName);
        //SharedPreference


        //Toolbar || Topic2, 3

        Toolbar robotoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(robotoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }
    //SharedPreferences
    @Override
    protected void onResume() {
        super.onResume();

        //Retrieves the data
        SharedPreferences preferences = getSharedPreferences("RoboPrefs", MODE_PRIVATE);
        String username = preferences.getString("username", "");

        edtName.setText(username);
    }




    private void setSupportActionBar(Toolbar robotoolbar) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.popup_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int itemID = item.getItemId();

        if(itemID == R.id.popup_content)
        {
            //display content
        }
        else if(itemID == R.id.popup_logout)
        {
            //logout
        }
        else if(itemID == R.id.popup_setting)
        {
            //load settings
        }
        return super.onOptionsItemSelected(item);
    }

    /*edtRoboname = findViewbyId(R.id.edtRoboname);
    btnInsert = findViewbyId(R.id.btnInsert);

    dbhelper = new DBHelper(this);

    btnInsert*/
}
/*
* Components used are as follows
* 1) Activities - everything within the java folder is an activity
* They are the individual screens(represents the UI elements)
*
* 2) Services - They run in the background and helps the app to function properly
* These are background components that perform operations without a UI
*
* 3) Content Providers - They share and manage data from different apps
*
* 4) Broadcast Receivers - These are component that allow your app to send and receive system wide
* broadcast messages or custom events*/

/*Shared Preference
*
* Functions LIKE a database but is not a database
* Helps su store and small collection of key-value pairs that we want to save.
* We can store and retrieve SharedPreferences objects.*/