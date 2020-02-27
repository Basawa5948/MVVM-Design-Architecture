package com.droidbasawa.mvvmdesign.ViewModel;

import android.util.Log;

import com.droidbasawa.mvvmdesign.networkCall.HCommunicationCall;
import com.droidbasawa.mvvmdesign.networkCall.HCommunicationListener;
import com.droidbasawa.mvvmdesign.response.HCommunicationResponse;
import com.droidbasawa.mvvmdesign.response.HCommunicationResponseModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class MyViewModel implements HCommunicationListener {
    private String requestUrl;
    private MyViewModelListener modelListener;
    private HCommunicationListener hCommunicationListener;

    public void executeRequest(String url, MyViewModelListener myViewModelListener) {
        this.requestUrl = url;
        this.modelListener = myViewModelListener;
        this.hCommunicationListener = this;
        new HCommunicationCall(requestUrl,hCommunicationListener).execute();
    }

    @Override
    public void onStarted(String initiating_request) {
        modelListener.onHCommunicationStarted(initiating_request);
    }

    @Override
    public void onSuccess(String response) {
        if(!response.isEmpty()){
            Log.d("ViewModelData",response);
            ArrayList<HCommunicationResponseModel> finalList;
            Gson gson = new GsonBuilder().create();
            HCommunicationResponse model = gson.fromJson
                    (response, HCommunicationResponse.class);
            finalList = model.getHits();
            modelListener.onHCommunicationSuccess(finalList);
        }
    }

    @Override
    public void onFailed(String no_response_from_the_api) {
        modelListener.onHCommunicationFailure(no_response_from_the_api);
    }
}
