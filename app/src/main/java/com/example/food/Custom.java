package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.food.final_cart.*;

import androidx.appcompat.app.AppCompatActivity;

public class Custom extends AppCompatActivity {
    CheckBox chkAutosave2, chkAutosave3, chkAutosave4, chkAutosave5, chkAutosave6;
    TextView title1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customize);
        final_cart c= new final_cart();

        title1 = findViewById(R.id.title1);
        chkAutosave2 = findViewById(R.id.chkAutosave2);
        chkAutosave3 = findViewById(R.id.chkAutosave3);
        chkAutosave4 = findViewById(R.id.chkAutosave4);
        chkAutosave5 = findViewById(R.id.chkAutosave5);
        chkAutosave6 = findViewById(R.id.chkAutosave6);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (chkAutosave2.isChecked()) {

                    Intent i1 = new Intent(Custom.this, Cart.class);
                    c.addCostOfCustomize("Corn", 25);
                    startActivity(i1);
                }
                if (chkAutosave3.isChecked()) {
                    Intent i2 = new Intent(Custom.this, Cart.class);
                    c.addCostOfCustomize("Capsicum", 35);
                    startActivity(i2);
                }
                if (chkAutosave4.isChecked()) {
                    Intent i3 = new Intent(Custom.this, Cart.class);

                    c.addCostOfCustomize("Extra Cheese", 75);
                    startActivity(i3);
                }
                if (chkAutosave5.isChecked()) {
                    Intent i4 = new Intent(Custom.this, Cart.class);
                    c.addCostOfCustomize("Mushroom", 55);
                    startActivity(i4);
                }
                if (chkAutosave6.isChecked()) {
                    Intent i5 = new Intent(Custom.this, Cart.class);
                    c.addCostOfCustomize("Paneer", 50);
                    startActivity(i5);
                }

            }
        });
    }
}

