package com.droidbasawa.mvvmdesign.ViewModel;

import com.droidbasawa.mvvmdesign.response.HCommunicationResponseModel;

import java.util.ArrayList;

public interface MyViewModelListener {

    void onHCommunicationStarted(String s);

    void onHCommunicationSuccess(ArrayList<HCommunicationResponseModel> response);

    void onHCommunicationFailure(String s);
}
