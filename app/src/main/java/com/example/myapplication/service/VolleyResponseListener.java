package com.example.myapplication.service;

import com.android.volley.VolleyError;


public interface VolleyResponseListener {

    void onError(VolleyError message);

    void onResponse(String response);

}
