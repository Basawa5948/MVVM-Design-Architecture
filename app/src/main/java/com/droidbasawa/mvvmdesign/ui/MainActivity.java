package com.droidbasawa.mvvmdesign.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.droidbasawa.mvvmdesign.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button httpCommunication;
    private Button volley;
    private Button retroFit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpCommunication = findViewById(R.id.httpCommunication);
        volley = findViewById(R.id.volley);
        retroFit = findViewById(R.id.retrofit);

        httpCommunication.setOnClickListener(this);
        volley.setOnClickListener(this);
        retroFit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.httpCommunication:
                startActivity(new Intent(this,HCommunication.class));
        }
    }
}
