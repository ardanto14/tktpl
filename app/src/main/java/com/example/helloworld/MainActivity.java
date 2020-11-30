package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    WifiManager wifiManager;
    RequestQueue queue;


    BroadcastReceiver wifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent intent) {
            boolean success = intent.getBooleanExtra(
                    WifiManager.EXTRA_RESULTS_UPDATED, false);
            if (success) {
                scanSuccess();
            } else {
                // scan failure handling
                scanFailure();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this);



        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        getApplicationContext().registerReceiver(wifiScanReceiver, intentFilter);

        boolean success = wifiManager.startScan();
        if (!success) {
            // scan failure handling
            scanFailure();
        }

        Log.v("testuy", "ready");

    }


    private void scanSuccess() {
        List<ScanResult> results = wifiManager.getScanResults();

        Log.v("testuy", results.get(0).BSSID);

        String url ="https://enmw49ho1q27.x.pipedream.net";
        JSONArray array = new JSONArray();
        for (int i = 0; i < results.size(); i++) {
            JSONObject obj = new JSONObject();
            try {
                obj.put("SSID", results.get(i).SSID);
                obj.put("BSSID", results.get(i).BSSID);
                obj.put("Frequency", Integer.toString(results.get(i).frequency));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            array.put(obj);
        }

        JSONObject ret = new JSONObject();
        try {
            ret.put("result", array);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Request a string response from the provided URL.
        JsonRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url, ret,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Display the first 500 characters of the response string.
                        Log.v("testuy", "send data success");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("testuy", error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(jsonRequest);


        Log.v("testuy", "success");
    }

    private void scanFailure() {
        // handle failure: new scan did NOT succeed
        // consider using old scan results: these are the OLD results!
        List<ScanResult> results = wifiManager.getScanResults();

        Log.v("testuy", "failed");
    }

}