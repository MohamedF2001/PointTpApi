package com.farid.lespoints;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.farid.lespoints.Adapter.AdapterRecycler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lst_data;
    private LinearLayoutManager layoutManager;
    private List<ItemObject> itemObjects;
    private AdapterRecycler adapterRecycler;
    private TextView txtTotalHarga;

    Integer total = 0;

    String url ="https://restoapp11.herokuapp.com/resto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Casting Object
        lst_data = (RecyclerView) findViewById(R.id.lst_data);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        lst_data.setLayoutManager(layoutManager);
        lst_data.setHasFixedSize(true);

        itemObjects = new ArrayList<>();
        //itemObjects.add(new ItemObject("Sepatu", "3000", "3000", "3000", "3000", "3000", "3000"));
        //itemObjects.add(new ItemObject("Sandal", "5000", "3000", "3000", "3000", "3000", "3000"));

// Instantiate the RequestQueue.

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray jArray = object.getJSONArray("restos");
                            for (int i = 0; i < jArray.length(); i++) {
                                JSONObject json_data = jArray.getJSONObject(i);
                                itemObjects.add(new ItemObject(
                                        json_data.getString("resto"),
                                        json_data.getString("detail"),
                                        json_data.getString("adresse"),
                                        json_data.getString("frozen"),
                                        json_data.getString("num"),
                                        json_data.getString("detail"),
                                        json_data.getString("_id")));
                            }
                            //Toast.makeText(MainActivity.this, ""+itemObjects.get(4).description, Toast.LENGTH_SHORT).show();

                            adapterRecycler = new AdapterRecycler(getApplicationContext(), itemObjects);
                            lst_data.setAdapter(adapterRecycler);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
        //itemObjects.add(stringRequest);
    }

}
