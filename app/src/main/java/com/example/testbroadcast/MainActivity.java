package com.example.testbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    private MyReceiver m_rcv = new MyReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        this.registerReceiver(m_rcv, filter);
        LocalBroadcastManager.getInstance(this).registerReceiver(m_rcv, new IntentFilter(ACTION_CUSTOM_BROADCAST));
    }
    @Override
    protected void onDestroy(){
        this.unregisterReceiver(m_rcv);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(m_rcv);
        super.onDestroy();
    }

    public void send_custom_broadcast(View view) {
        Intent custom_intent = new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(custom_intent);

    }
}
