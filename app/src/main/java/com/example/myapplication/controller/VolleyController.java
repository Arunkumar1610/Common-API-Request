package com.example.myapplication.controller;



import android.content.Context;

import com.android.volley.VolleyError;
import com.example.myapplication.view.VolleyView;

import java.util.Map;

public class VolleyController {

    private VolleyView mView;

    public VolleyController(VolleyView view) {
        this.mView = view;
    }

    public void performGetRequest(Context context, String url, final VolleyView.ResponseListener listener) {
        mView.makeGetRequest(context, url, new VolleyView.ResponseListener() {
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

    public void performPostRequest(Context context, String url, Map<String, String> params, final VolleyView.ResponseListener listener) {
        mView.makePostRequest(context, url, params, new VolleyView.ResponseListener() {
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

