package com.example.myapplication.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.myapplication.R;
import com.example.myapplication.controller.VolleyController;
import com.example.myapplication.view.VolleyView;

public class MainActivity extends AppCompatActivity implements VolleyView.ResponseListener{
    private VolleyController mController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mController = new VolleyController(new VolleyView());
        String url = "https://nexsan.one/api/history_status?status_param=success";
        mController.performGetRequest(this, url, this);
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