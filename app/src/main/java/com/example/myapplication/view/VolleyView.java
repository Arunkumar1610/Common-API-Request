package com.example.myapplication.view;


import android.content.Context;

import com.android.volley.VolleyError;
import com.example.myapplication.model.VolleyRequestModel;
import com.example.myapplication.service.VolleyResponseListener;

import java.util.Map;

public class VolleyView {
    public interface ResponseListener {
        void onError(VolleyError error);
        void onResponse(String response);
    }

    public void makeGetRequest(Context context, String url, final ResponseListener listener) {
        VolleyRequestModel model = new VolleyRequestModel();
        model.get(context, url, new VolleyResponseListener() {
            @Override
            public void onError(VolleyError error) {
                listener.onError(error);
            }

            @Override
            public void onResponse(String response) {
                listener.onResponse(response);
            }
        });
    }

    public void makePostRequest(Context context, String url, Map<String, String> params, final ResponseListener listener) {
        VolleyRequestModel model = new VolleyRequestModel();
        model.post(context, url, params, new VolleyResponseListener() {
            @Override
            public void onError(VolleyError error) {
                listener.onError(error);
            }

            @Override
            public void onResponse(String response) {
                listener.onResponse(response);
            }
        });
    }
}

