package com.droidbasawa.mvvmdesign.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.droidbasawa.mvvmdesign.R;
import com.droidbasawa.mvvmdesign.ViewModel.MyViewModel;
import com.droidbasawa.mvvmdesign.ViewModel.MyViewModelListener;
import com.droidbasawa.mvvmdesign.adapter.HCommunicationAdapter;
import com.droidbasawa.mvvmdesign.response.HCommunicationResponseModel;

import java.util.ArrayList;

public class HCommunication extends AppCompatActivity implements MyViewModelListener {

    private MyViewModel myViewModel;
    private String requestURL = "https://pixabay.com/api/?key=10977577-f0b29d91d6b843c7d6b5b7ecc";
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private HCommunicationAdapter hCommunicationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hcommunication);
        myViewModel = new MyViewModel();
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_httpCommunication);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        makeRequest();
    }

    public void makeRequest() {
        progressDialog.setTitle("Making Request");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
        myViewModel.executeRequest(requestURL,this);
    }

    @Override
    public void onHCommunicationStarted(String s) {
        //TODO
    }

    @Override
    public void onHCommunicationSuccess(ArrayList<HCommunicationResponseModel> response) {
        if(progressDialog.isShowing())
            progressDialog.dismiss();
        hCommunicationAdapter = new HCommunicationAdapter(response,HCommunication.this);
        recyclerView.setAdapter(hCommunicationAdapter);
    }

    @Override
    public void onHCommunicationFailure(String s) {
        if(progressDialog.isShowing())
            progressDialog.dismiss();
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
