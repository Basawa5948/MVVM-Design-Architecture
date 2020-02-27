package com.droidbasawa.mvvmdesign.networkCall;

public interface HCommunicationListener {
    void onStarted(String initiating_request);
    void onSuccess(String response);
    void onFailed(String no_response_from_the_api);
}
