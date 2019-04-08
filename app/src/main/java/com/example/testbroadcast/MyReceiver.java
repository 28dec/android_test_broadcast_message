package com.example.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        String intent_action = intent.getAction();
        String msg = "NO MSG";
        switch (intent_action){
            case Intent.ACTION_POWER_CONNECTED:
                msg = "POWER CONNECTED!";
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                msg = "POWER DISCONNECTED!";
                break;
            case ACTION_CUSTOM_BROADCAST:
                msg = "CUSTOM BROADCAST RECEIVED!";
                break;
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
