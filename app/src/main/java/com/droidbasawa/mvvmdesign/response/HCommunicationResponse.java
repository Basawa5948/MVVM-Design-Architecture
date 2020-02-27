package com.droidbasawa.mvvmdesign.response;

import java.util.ArrayList;

public class HCommunicationResponse {

    private int totalhits;
    private ArrayList<HCommunicationResponseModel> hits;

    public int getTotalhits() {
        return totalhits;
    }

    public ArrayList<HCommunicationResponseModel> getHits() {
        return hits;
    }
}
