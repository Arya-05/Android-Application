package com.example.food;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import com.example.food.final_cart.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Pizza extends AppCompatActivity {
    ImageView imageView2, imageView3, imageView4;
    TextView title1, title2, title3, title4, cost1, cost2, cost3, desc1, desc2, desc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        final_cart c= new final_cart();


        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

        title2 = findViewById(R.id.title2);
        title3 = findViewById(R.id.title3);
        title4 = findViewById(R.id.title4);
        title1 = findViewById(R.id.title1);

        cost1 = findViewById(R.id.cost1);
        cost2 = findViewById(R.id.cost2);
        cost3 = findViewById(R.id.cost3);

        desc1 = findViewById(R.id.desc1);
        desc2 = findViewById(R.id.desc2);
        desc3 = findViewById(R.id.desc3);
        //btnFilter = (Button) findViewById(R.id.btnFilter);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popup2 = new PopupMenu(Pizza.this, imageView2);
                popup2.getMenuInflater().inflate(R.menu.popup_cart, popup2.getMenu());
                popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {


                        int id = item.getItemId();
                        switch (id) {
                            case R.id.menu_add:
                                //Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_LONG).show();
                                Intent i_sand = new Intent(Pizza.this, Cart.class);
                                c.addToCart("margherita",200);
                                startActivity(i_sand);
                                return true;
                            case R.id.menu_customize:
                                Intent i_pasta = new Intent(Pizza.this, Custom.class);
                                c.addToCart("margherita",200);
                                startActivity(i_pasta);
                                return true;
//                Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();

                        }


//                      Intent i = new Intent(Sandwich.this, Cart.class);
//                      startActivity(i);
                        //Toast.makeText(Pizza.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                      return true;
                    }
                });
                popup2.show();//showing popup menu
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup2 = new PopupMenu(Pizza.this, imageView3);
                popup2.getMenuInflater().inflate(R.menu.popup_cart, popup2.getMenu());
                popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {


                        int id = item.getItemId();
                        switch (id) {
                            case R.id.menu_add:
                                //Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_LONG).show();
                                Intent i_sand = new Intent(Pizza.this, Cart.class);
                                c.addToCart("Garden Fresh Veggies",469);
                                startActivity(i_sand);
                                return true;
                            case R.id.menu_customize:
                                Intent i_pasta = new Intent(Pizza.this, Custom.class);
                                c.addToCart("Garden Fresh Veggies",469);
                                startActivity(i_pasta);
                                return true;
//                Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();

                        }
                            return true;

//                      Intent i = new Intent(Sandwich.this, Cart.class);
//                      startActivity(i);
                        //Toast.makeText(Pizza.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });
                popup2.show();//showing popup menu
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup2 = new PopupMenu(Pizza.this, imageView4);
                popup2.getMenuInflater().inflate(R.menu.popup_cart, popup2.getMenu());
                popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {


                        int id = item.getItemId();
                        switch (id) {
                            case R.id.menu_add:
                                //Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_LONG).show();
                                Intent i_sand = new Intent(Pizza.this, Cart.class);
                                c.addToCart("Paneer Tikka",560);
                                startActivity(i_sand);
                                return true;
                            case R.id.menu_customize:
                                Intent i_pasta = new Intent(Pizza.this, Custom.class);
                                c.addToCart("Paneer Tikka",560);
                                startActivity(i_pasta);
                                return true;
//                Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();

                        }


//                      Intent i = new Intent(Sandwich.this, Cart.class);
//                      startActivity(i);
                        //Toast.makeText(Pizza.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup2.show();//showing popup menu
            }
        });
            }
        }


