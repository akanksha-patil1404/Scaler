package com.example.scaler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText=findViewById(R.id.Name);
        EditText editText1=findViewById(R.id.Title);
        EditText editText2=findViewById(R.id.Email);
        EditText editText3=findViewById(R.id.Link);
        EditText editText4=findViewById(R.id.Date);
        EditText editText5=findViewById(R.id.Start);
        EditText editText6=findViewById(R.id.End);
        Button button=findViewById(R.id.Schedule);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=editText.getText().toString();
                String data1=editText1.getText().toString();
                String data2=editText2.getText().toString();
                String data3=editText3.getText().toString();
                String data4=editText4.getText().toString();
                String data5=editText5.getText().toString();
                String data6=editText6.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://10.1.41.138/SCALER-CRUD/create.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Success")){
                                    Toast.makeText(MainActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e( "Error",error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("Name", "data");
                        paramV.put("Title", "data1");
                        paramV.put("Email", "data2");
                        paramV.put("Link", "data3");
                        paramV.put("Date", "data4");
                        paramV.put("Start", "data5");
                        paramV.put("End", "data6");

                        return paramV;
                    }
                };
                queue.add(stringRequest);

            }
        });
    }
}