package com.example.food;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food.final_cart.*;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;


public class Cart extends AppCompatActivity {

    TextView title1, title2, title3, title4;
    ListView list1, list2;
    Button button;
   int sum=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        final_cart c = new final_cart();

        title1 = findViewById(R.id.title1);
        title2 = findViewById(R.id.title2);
        title3 = findViewById(R.id.title3);
        title4 = findViewById(R.id.title4);
        list1 = findViewById(R.id.list1);
        list2 = findViewById(R.id.list2);
        button = findViewById(R.id.button);
        ArrayList<String> a = c.get_cart_array();
        ArrayList<Integer> b = c.get_cost_array();


        ArrayAdapter<String> s1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, a);
        ArrayAdapter<Integer> s2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, b);


        for (int i = 0; i < b.size(); i++)
            sum += b.get(i);

        title2.setText("Total cost : " + sum);
        list1.setAdapter(s1);
        list2.setAdapter(s2);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        createChannel(notificationManager);

        // On click listener on dine in button
        int finalSum = sum;
        findViewById(R.id.button).setOnClickListener(view -> {

            int crying_face = 0x1F622;
            int smirking_face = 0x1F60F;
            int tasty_face = 0x1F60B;
            int star_face = 0x1F929;
            int love_face = 0x1F60D;

            if (finalSum == 0){
                Toast.makeText(this, "Nothing to order", Toast.LENGTH_SHORT).show();
            }

            else{
                String title = "Yayy!! Cooking....." + new String(Character.toChars(tasty_face));
                String text = "Your order is being prepared " + new String(Character.toChars(tasty_face));

                String[] list = {"Home Delivery ", "Pick up "};

                AlertDialog.Builder builder = new AlertDialog.Builder(Cart.this);
                builder.setTitle("Choose the option");

                builder.setItems(list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                Intent intent = new Intent(getApplicationContext(),Select.class);
                                intent.putExtra("Selected", "home");
                                PendingIntent informer = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                                Notification notification = notify1(title,text, informer);

                                notificationManager.notify(113,notification);

//                                CountDownTimer countDownTimer = new CountDownTimer(10000,5000) {
//                                    @Override
//                                    public void onTick(long l) {
//                                    }
//
//                                    @Override
//                                    public void onFinish() {
//                                        String title = "Order ready....." + new String(Character.toChars(love_face));
//                                        String text = "Your Order is on the way..." + new String(Character.toChars(star_face));
//
//                                        Notification notification1 = notify1(title,text,informer);
//                                        notificationManager.notify(113,notification1);
//                                    }
//                                }.start();


                                Toast.makeText(Cart.this, "Order is placed", Toast.LENGTH_SHORT).show();
                                return;

                            case 1:
                                Intent intent1 = new Intent(getApplicationContext(),Select.class);
                                intent1.putExtra("Selected", "pickup");
                                PendingIntent informer1 = PendingIntent.getActivity(getApplicationContext(),0,intent1,PendingIntent.FLAG_UPDATE_CURRENT);

                                Notification notification1 = notify1(title,text, informer1);

                                notificationManager.notify(113,notification1);

                                Toast.makeText(Cart.this, "Order is placed", Toast.LENGTH_SHORT).show();
                                return;
                        }
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();



            }

        });

    }

    public Notification notify1(String title, String text, PendingIntent informer){
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(getApplicationContext(),"notify");

        Notification notification = notifyBuilder
                .setSmallIcon(R.drawable.ic_baseline_restaurant_24)
                .setContentTitle(title)
                .setContentText(text)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(informer)
                .build();

        return notification;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void createChannel(NotificationManager mgr){
        if (android.os.Build.VERSION. SDK_INT >= android.os.Build.VERSION_CODES. O ) {

            //create the notification channel
            NotificationChannel appsChannel = new NotificationChannel("notify", "Apps", NotificationManager.IMPORTANCE_DEFAULT);
            appsChannel.setLightColor(Color.BLUE);
            mgr.createNotificationChannel(appsChannel);
        }
    }
}