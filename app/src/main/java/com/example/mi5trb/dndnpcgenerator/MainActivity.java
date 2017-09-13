package com.example.mi5trb.dndnpcgenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Members
        Button btn_generate_npc = (Button) findViewById(R.id.btn_generate_npc);
        final TextView txt_rand1 = (TextView) findViewById(R.id.txt_rand1);
        final TextView txt_rand2 = (TextView) findViewById(R.id.txt_rand2);
        final TextView txt_rand3 = (TextView) findViewById(R.id.txt_rand3);

        //int test = R.attr.Races.


        //Methods
        btn_generate_npc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream fis = getResources().openRawResource(R.raw.traits);
                try {
                    StringBuilder str = new StringBuilder();
                    BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                    while (in.ready()) {
                        str.append(in.readLine());
                    }
                    JSONObject jdata = new JSONObject(str.toString());
                    JSONArray appearances = jdata.getJSONArray("appearances");
                    JSONArray bonds = jdata.getJSONArray("bonds");
                    JSONArray races = jdata.getJSONArray("races");

                    Random r = new Random();
                    int index = r.nextInt(appearances.length());
                    txt_rand1.setText(appearances.getString(index));

                    index = r.nextInt(bonds.length());
                    txt_rand2.setText(bonds.getString(index));

                    index = r.nextInt(races.length());
                    txt_rand3.setText(races.getString(index));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}