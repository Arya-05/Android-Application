package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.food.final_cart.*;



public class Home extends AppCompatActivity {
    TextView title1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        title1 = findViewById(R.id.title1);
        //getting the notification message
        //getting the notification message
        title1.setText(getIntent().getStringExtra("Msg"));
    }
}


