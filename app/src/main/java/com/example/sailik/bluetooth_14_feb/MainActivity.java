package com.example.sailik.bluetooth_14_feb;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    //AlertDialog alert;
    //Bundle extras;
    private static final String TAG=MainActivity.class.getName();
    //private final BroadcastReceiver mybroadcast = new StatusReciver();
    //StatusReciver mybroadcast;

    private BluetoothAdapter BA = BluetoothAdapter.getDefaultAdapter();
    //AlertDialog.Builder builder;
    //Intent in;
    String status;

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    
    builder.setTitle("Bluetooth is OFF!!");
    //builder.setTitle("Bluetooth is OFF!!");
    AlertDialog alert = builder.create();
    StatusReciver myb = new StatusReciver();
//        @Override
//        public void onReceive(Context context,Intent intent) {
//            Intent in = getIntent();
//            status = in.getStringExtra("state");
//            if (status == null) {
//                Toast.makeText(MainActivity.this, "state is received as null", Toast.LENGTH_SHORT).show();
//            } else if (status.equals("on")) {
//                if (alert.isShowing()) {
//                    alert.dismiss();
//                }
//                Toast.makeText(MainActivity.this, "Bluetooth: ON", Toast.LENGTH_SHORT).show();
//            } else {
//                if (status.equals("off")) {
//                    alert.show();
//                }
//            }
//        }
//
//    };
    BroadcastReceiver mybroadcast = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            //extract our message from intent
            Log.d(TAG,"receiver");
            status = intent.getStringExtra("state");
            if(status!=null){
                Log.d(TAG,"status not null");
            }
            if(status==null){

                Toast.makeText(MainActivity.this,"state is received as null",Toast.LENGTH_SHORT).show();
            }
            else if(status.equals("on")){
                if(alert.isShowing()){
                    alert.dismiss();
                }
                Toast.makeText(MainActivity.this,"Bluetooth: ON",Toast.LENGTH_SHORT).show();
            }
            else{
                if(status.equals("off")){
                    alert.show();
                }
            }


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate()");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");
        IntentFilter intfil = new IntentFilter();
        intfil.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        registerReceiver(myb, intfil);
//        Log.d(TAG,"registered myb");
        registerReceiver(mybroadcast,new IntentFilter("BluetoothAdapter.ACTION_STATE_CHANGED"));
        Log.d(TAG,"registered mybroadcast");
        if(BA.isEnabled()){
            if(alert.isShowing()){
                alert.dismiss();
            }
            Toast.makeText(this,"Bluetooth is ON",Toast.LENGTH_SHORT).show();
        }
        else{
            if(!BA.isEnabled()){
                alert.show();
            }
            else{
                Toast.makeText(this,"something is wrong",Toast.LENGTH_SHORT).show();
            }
        }
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("connectivity");


        // /new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        //IntentFilter filter = new IntentFilter("com.example.sailik.bluetooth_14_feb");

        //mybroadcast = new StatusReciver();
        //registerReceiver(mybroadcast, filter);
        //registerReceiver(mybroadcast, new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));


//        in = getIntent();
//        builder = new AlertDialog.Builder(this);
//        builder.setTitle("Bluetooth is OFF!!");
//        alert = builder.create();
//
//
//        state = in.getStringExtra("state");
//        if(state.equals("on")){
//            if(alert.isShowing()){
//                alert.dismiss();
//            }
//            Toast.makeText(this,"Bluetooth: ON",Toast.LENGTH_SHORT).show();
//        }
//        else{
//            if(state.equals("off")){
//                alert.show();
//            }
//        }
//        if (BA.isEnabled()) {
//            if(alert.isShowing()){
//                alert.dismiss();
//            }
//            Toast.makeText(this, "Bluetooth is ON", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            alert.show();}

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume()");
//        builder = new AlertDialog.Builder(this);
//        builder.setTitle("Bluetooth is OFF!!");
//        alert = builder.create();



//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("connectivity");
//        IntentFilter intfil = new IntentFilter();
//        intfil.addAction("android.bluetooth.adapter.STATE_CHANGED");
//        mybroadcast = new StatusReciver() {
//
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                //extract our message from intent
//                status = intent.getStringExtra("state");

//        registerReceiver(myb,intfil);
//        registerReceiver(mybroadcast, intentFilter);

//                if(status==null){
//                    Toast.makeText(MainActivity.this,"state is received as null",Toast.LENGTH_SHORT).show();
//                }
//                else if(status.equals("on")){
//                    if(alert.isShowing()){
//                        alert.dismiss();
//                    }
//                    Toast.makeText(MainActivity.this,"Bluetooth: ON",Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    if(status.equals("off")){
//                        alert.show();
//                    }
//                }
//                //log our message value
//                //Log.i("InchooTutorial", msg_for_me);
//
//            }
//        };
//        this.registerReceiver(mybroadcast, intentFilter);


//        in = getIntent();
//        status = in.getStringExtra("state");
//        if(status==null){
//            Toast.makeText(this,"state is received as null",Toast.LENGTH_SHORT).show();
//        }
//        if(status.equals("on")){
//            if(alert.isShowing()){
//                alert.dismiss();
//            }
//            Toast.makeText(this,"Bluetooth: ON",Toast.LENGTH_SHORT).show();
//        }
//        else{
//            if(status.equals("off")){
//                alert.show();
//            }
//        }
//        if (BA.isEnabled()) {
//            if(alert.isShowing()){
//                alert.dismiss();
//                Toast.makeText(this, "Bluetooth is ON", Toast.LENGTH_SHORT).show();
//            }
//            Toast.makeText(this, "Bluetooth is ON", Toast.LENGTH_SHORT);
//        }
//        else if(!BA.isEnabled()){
//            alert.show();}
//        else{
//            Toast.makeText(this,"something is wrong",Toast.LENGTH_SHORT).show();
//        }


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(mybroadcast);
        unregisterReceiver(myb);

    }
}
