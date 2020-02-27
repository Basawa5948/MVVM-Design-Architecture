package com.droidbasawa.mvvmdesign.networkCall;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HCommunicationCall extends AsyncTask<Void,Void,Void> {

    private String requestURL;
    private String response;
    private HCommunicationListener listener;

    public HCommunicationCall(String url, HCommunicationListener hCommunicationListener) {
        this.requestURL = url;
        this.listener = hCommunicationListener;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            response = makeHttpRequest(requestURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(!response.isEmpty())
            listener.onSuccess(response);
        else
            listener.onFailed("No response from the API");

    }

    private String makeHttpRequest(String requestURL) throws IOException {
        listener.onStarted("Initiating Request");
        String apiResponse = "";
        URL url = new URL(requestURL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        apiResponse =  properJsonResponse(inputStream);
        return apiResponse;
    }

    private String properJsonResponse(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
            try {
                while ((line = bufferedReader.readLine())!=null){
                    stringBuilder.append(line).append('\n'); }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringBuilder.toString();
    }
}
