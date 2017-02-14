package com.example.sailik.bluetooth_14_feb;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by saili.k on 14-02-2017.
 */



public class StatusReciver extends BroadcastReceiver {

    //String state;
    private static final int FAIL = -1;
    private static final String TAG=MainActivity.class.getName();

    @Override
    public void onReceive(Context context, Intent intent) {
//        int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
//                -1);
        Log.d(TAG,"onReceive:receiver");
        String action = intent.getAction();            // Get intent's action string
        Bundle extras = intent.getExtras();            // Get all the Intent's extras
        if (extras == null) return;                    // All intents of interest have extras.
        Intent i = new Intent();
        i.setAction("BluetoothAdapter.ACTION_STATE_CHANGED");
        switch (action) {
            case "android.bluetooth.adapter.action.STATE_CHANGED": {
                //bluetoothStateChanged(extras.getInt("android.bluetooth.adapter.extra.STATE", FAIL));
                int state = extras.getInt("android.bluetooth.adapter.extra.STATE", FAIL);
                switch (state) {
                    case BluetoothAdapter.STATE_OFF:
                        //Intent i = new Intent("OFF")
                        Log.d(TAG,"state:off");
                        i.putExtra("state", "off");
                        context.sendBroadcast(i);
                        Log.d(TAG,"after send b off");
                        break;
                    case BluetoothAdapter.STATE_ON:
                        i.putExtra("state", "on");
                        context.sendBroadcast(i);
                        Log.d(TAG,"after send b on");
                        break;

                }
                //break;
            }
        }
    }

}

//    private void bluetoothStateChanged(int state) {
//        Intent i = new Intent("android.action.MAIN");
//        switch (state) {
//            case BluetoothAdapter.STATE_OFF:
//                //Intent i = new Intent("OFF")
//                i.putExtra("state","off");
//                context.sendBroadcast(i);
//                break;
//            case BluetoothAdapter.STATE_ON:
//                i.putExtra("state","on");
//                break;
//
//        }
//
//    }


//        Bundle extras = intent.getExtras();
//        if (extras != null) {
//            state = extras.getString(BluetoothAdapter.EXTRA_STATE);
//        }


        //Intent i = new Intent(context, MainActivity.class);
         //Intent i = new Intent("android.action.MAIN");
        //switch(state){
            //case BluetoothAdapter.STATE_OFF:
                //i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                //i.setAction("com.example.sailik.bluetooth_14_feb");
                //i.putExtra("state","off");

                //context.startActivity(i);
                //break;
            //case 12:
                //i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                //i.setAction("com.example.sailik.bluetooth_14_feb");
                //i.putExtra("state","on");
                //context.startActivity(i);
                //break;
//            case BluetoothAdapter.STATE_OFF:
//                i.putExtra("state","off");
//                context.startActivity(i);
//                break;
//            case BluetoothAdapter.STATE_ON:
//                i.putExtra("state","on");
//                context.startActivity(i);
//                break;


        //}
        //context.sendBroadcast(i);
    //}



//}
