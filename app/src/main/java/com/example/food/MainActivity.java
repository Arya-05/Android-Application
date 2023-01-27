package com.example.food;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;



public class MainActivity extends AppCompatActivity {
   // ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //home=findViewById(R.id.home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu1, menu);
    }
    // @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        return super.onContextItemSelected(item);
//        int id1 = item.getItemId();
//        switch (id1) {
//            case R.id.i1:
//
//                 Intent i1 = new Intent(MainActivity.this,Customize.class);
//                startActivity(i1);
////            case R.id.i2:
////                Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
////                return true;
////            case R.id.i3:
////                Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_LONG).show();
////                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }


//    this, FlashActivity.class);
//             this.startActivity(intent);

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.i1:
                Intent i_pasta = new Intent(MainActivity.this,Pasta.class);
                startActivity(i_pasta);
//                Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.i2:
                Intent i_pizza = new Intent(MainActivity.this,Pizza.class);
                startActivity(i_pizza);
                //Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.i3:
                Intent i_cart = new Intent(MainActivity.this,Cart.class);
                startActivity(i_cart);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
