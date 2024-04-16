package com.example.myapplication.service;

import android.annotation.SuppressLint;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class Volley_Singleton {

    @SuppressLint("StaticFieldLeak")
    private static Volley_Singleton mInstance;
    private RequestQueue mRequestQueue;
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    private Volley_Singleton(Context context){

        mContext = context;

        mRequestQueue = getRequestQueue();
    }

    public static synchronized Volley_Singleton getInstance(Context context){

        if(mInstance == null){
            mInstance = new Volley_Singleton(context);
        }

        return mInstance;
    }

    public RequestQueue getRequestQueue(){

        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }


        return mRequestQueue;
    }

    public<T> void addToRequestQueue(Request<T> request){

        getRequestQueue().add(request);
    }
}
