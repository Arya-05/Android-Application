package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.food.final_cart.*;

//public class Select extends AppCompatActivity {
//    Button button1, button2;
//    TextView title1, title2;
//    public int counter;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_select);
//        final NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        title1 = findViewById(R.id.title1);
//        title2 = findViewById(R.id.title2);
//        final Button button2 = findViewById(R.id.button2);
//        final Button button1 = findViewById(R.id.button1);
//        createChannel(mgr);
//
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////CREATION OF PENDING INTENT
//                new CountDownTimer(12000, 1000 * 6) {
//
//                    public void onTick(long millisUntilFinished) {
//                        final NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//                        createChannel(mgr);
//
//
//                        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(Select.this, "mychannels.Apps");
//                        long min = (millisUntilFinished / 6000) % 60;
//
//                        Intent i = new Intent(Select.this,Dine.class);
//
//                        i.putExtra("Msg","Your order is ready to serve");
//                       // startActivity(i);
//                        PendingIntent pi = PendingIntent.getActivity(Select.this, 0, i, 0);
//
//                        Notification n = nBuilder
//                                .setSmallIcon(R.drawable.ic_baseline_fastfood_24)
//                                .setContentTitle("Dine In! \uD83D\uDE0B")
//                                .setContentText("Your Order will be prepared in " + String.valueOf(min + 1) + "min")
//                                .setWhen(System.currentTimeMillis())
//                        .setContentIntent(pi)
//                                .build();
//                        mgr.notify(11, n);
//
//
//                    }
//
//                    public void onFinish() {
//                        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(Select.this, "mychannels.Apps");
//
//                        Notification n = nBuilder
//                                .setSmallIcon(R.drawable.ic_baseline_fastfood_24)
//                                .setContentTitle("Dine in")
//                                .setContentText("Yeahh..\uD83E\uDD29 wait is over!!!\n Your order is ready to serve")
//                                .setWhen(System.currentTimeMillis())
////                        .setContentIntent(pi)
//                                .build();
//                        mgr.notify(11, n);
//
//
//                    }
//                }.start();
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new CountDownTimer(12000, 1000 * 6) {
//
//                    public void onTick(long millisUntilFinished) {
//
//                        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(Select.this, "mychannels.Apps");
//                        long min = (millisUntilFinished / 6000) % 60;
//                        Intent i = new Intent(Select.this,Dine.class);
//
//                        i.putExtra("Msg","Your Order will be prepared in"+ String.valueOf(min + 1) + "min");
//                        // startActivity(i);
//                        PendingIntent pi = PendingIntent.getActivity(Select.this, 0, i, 0);
//
//                        Notification n = nBuilder
//                                .setSmallIcon(R.drawable.ic_baseline_fastfood_24)
//                                .setContentTitle("Delivery! \uD83D\uDE0B")
//                                .setContentText("Your \uD83C\uDF54 Order will deliver in" + String.valueOf(min + 1) + "min")
//                                .setWhen(System.currentTimeMillis())
//                        .setContentIntent(pi)
//                                .build();
//                        mgr.notify(11, n);
//
//
//                    }
//
//                    public void onFinish() {
//                        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(Select.this, "mychannels.Apps");
//
//                        Notification n = nBuilder
//                                .setSmallIcon(R.drawable.ic_baseline_fastfood_24)
//                                .setContentTitle("Delivery!\uD83C\uDF55")
//                                .setContentText("Yeahh..\uD83E\uDD29 wait is over!!!\n Your order is on your door step")
//                                .setWhen(System.currentTimeMillis())
////                        .setContentIntent(pi)
//                                .build();
//                        mgr.notify(11, n);
//
//
//                    }
//                }.start();
//            }
//        });
//    }
//    protected void createChannel(NotificationManager mgr){
//        //create the notification channel
//        NotificationChannel appsChannel = new NotificationChannel("mychannels.Apps", "Apps", NotificationManager.IMPORTANCE_DEFAULT);
//        appsChannel.setLightColor(Color.BLUE);
//        mgr.createNotificationChannel(appsChannel);
//    }
//}
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class Select extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine);

        TextView update = findViewById(R.id.title1);

        Intent intent = getIntent();
        String val = intent.getStringExtra("Selected");

        final int[] n = {5};

        final NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        createChannel(mgr);

        if (val.equals("home")){

            CountDownTimer countDownTimer = new CountDownTimer(30000,5000) {
                @Override
                public void onTick(long l) {
                    String msg = "Your order will be delivered in " + String.valueOf(30 - n[0]) + " min";

                    update.setText(msg);

                    n[0] += 5;
                }
                @Override
                public void onFinish() {
                    String msg = "Your order is Delivered";

                    update.setText(msg);

                    NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(getApplicationContext(), "mychannels.Apps");
                    Notification n = nBuilder
                            .setSmallIcon(R.drawable.ic_baseline_restaurant_24)
                            .setContentTitle("Order Delivered!!!")
                            .setContentText("Enjoy your meal......")
                            .setWhen(System.currentTimeMillis())
                            .build();
                    mgr.notify(11, n);
                }
            }.start();
        }

        else {

            CountDownTimer countDownTimer = new CountDownTimer(30000,5000) {
                @Override
                public void onTick(long l) {
                    String msg = "Your order will be delivered in " + String.valueOf(30 - n[0]) + " min";

                    update.setText(msg);

                    n[0] += 5;
                }

                @Override
                public void onFinish() {
                    String msg = "Order ready for Pickup";

                    update.setText(msg);

                    NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(getApplicationContext(), "mychannels.Apps");
                    Notification n = nBuilder
                            .setSmallIcon(R.drawable.ic_baseline_restaurant_24)
                            .setContentTitle("Order Ready!!!")
                            .setContentText("Come and get it asap......")
                            .setWhen(System.currentTimeMillis())
                            .build();
                    mgr.notify(11, n);
                }
            }.start();

        }




    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void createChannel(NotificationManager mgr){
        //create the notification channel
        NotificationChannel appsChannel = new NotificationChannel("mychannels.Apps", "Apps", NotificationManager.IMPORTANCE_DEFAULT);
        appsChannel.setLightColor(Color.BLUE);
        mgr.createNotificationChannel(appsChannel);
    }
}