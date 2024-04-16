package com.example.myapplication.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.myapplication.R;
import com.example.myapplication.controller.VolleyController;
import com.example.myapplication.view.VolleyView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements VolleyView.ResponseListener{
    private VolleyController mController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mController = new VolleyController(new VolleyView());
        String url = "get url";
        mController.performGetRequest(this, url, this);

        String postUrl = "post_url";
        Map<String, String> postParams = new HashMap<>();
        postParams.put("param1", "value1");
        postParams.put("param2", "value2");
        mController.performPostRequest(this, postUrl, postParams, this);
    }

    @Override
    public void onError(VolleyError error) {
        System.out.println("ERROR     "+error.toString());
    }

    @Override
    public void onResponse(String response) {
        System.out.println("RESPONSE     "+response);
    }
}