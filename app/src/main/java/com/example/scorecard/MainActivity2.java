package com.example.scorecard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<String> code = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> score = new ArrayList<>();
    ArrayList<String> id = new ArrayList<>();

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toast t=Toast.makeText(this,"Further part of task had errors,therefore displaying this much",Toast.LENGTH_LONG);
        t.show();

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        try {
            JSONObject obj = new JSONObject(loadJson());
            JSONArray userArray = obj.getJSONArray("data");
            for (int i = 0; i < userArray.length(); i++) {

            }
            for (int i = 0; i < userArray.length(); i++) {
                JSONObject detail = userArray.getJSONObject(i);
                code.add(detail.getString("code"));
                name.add(detail.getString("name"));
                score.add(detail.getString("score"));
                id.add(detail.getString("id"));
            }


            //for(int i=0;i< userArray.length();i++) {
            //Collections.sort(, new); {
                // @Override
                // public int compare(Integer o1, Integer o2) {
                //     if(o1.getscores[i]<)
                //     return 0;
                //   }
            //}
            //}


            /*Collections.sort(score, new Comparator<JSONObject>() {
                @Override
                public int compare(JSONObject a,JSONObject b) {
                    String A=new String();
                    String B=new String();

                    try {
                        A = (String) a.get("score");
                        B = (String) b.get("score");
                    }
                    catch(JSONException e){
                        Log.e("LOG_TAG","JSONException in sort",e);

                    }
                    return A.compareTo(B);
                }
            });*/





        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapter customAdapter = new CustomAdapter(code, name, score, id, MainActivity2.this);
        rv.setAdapter(customAdapter);
    }

    private String loadJson() {
        String json;
        try {
            InputStream is = getAssets().open("a.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }



    }






