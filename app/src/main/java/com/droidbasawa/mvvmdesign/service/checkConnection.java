package com.droidbasawa.mvvmdesign.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class checkConnection extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public checkConnection(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Bundle extras = intent.getExtras();
        boolean isNetworkConnected = extras.getBoolean("isNetworkConnected");
        if(!isNetworkConnected)
            Toast.makeText(this,"Please Connect to Internet",Toast.LENGTH_LONG).show();
    }
}
