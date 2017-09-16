package com.example.mi5trb.dndnpcgenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Members
    Button btn_generate_npc;
    TextView appearance_txt;
    TextView mannerism_txt;
    TextView race_txt;
    TextView low_txt;
    TextView high_txt;
    TextView interactions_txt;
    TextView backgrounds_txt;
    TextView bond_txt;
    TextView flaws_txt;
    TextView ideal_txt;
    TextView talent_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_generate_npc = (Button) findViewById(R.id.btn_generate_npc);
        appearance_txt = (TextView) findViewById(R.id.appearance_txt);
        mannerism_txt = (TextView) findViewById(R.id.mannerism_txt);
        race_txt = (TextView) findViewById(R.id.race_txt);
        low_txt = (TextView) findViewById(R.id.low_ability_txt);
        high_txt = (TextView) findViewById(R.id.high_ability_txt);
        interactions_txt = (TextView) findViewById(R.id.interactions_txt);
        backgrounds_txt = (TextView) findViewById(R.id.background_txt);
        bond_txt = (TextView) findViewById(R.id.bond_txt);
        flaws_txt = (TextView) findViewById(R.id.flaw_txt);
        ideal_txt = (TextView) findViewById(R.id.ideal_txt);
        talent_txt = (TextView) findViewById(R.id.talent_txt);

        //Methods
        btn_generate_npc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generate();
            }
        });
    }

    private String getTrait(JSONArray data) {
        Random r = new Random();
        String value;
        try {
            value = data.getString(r.nextInt(data.length()));
        } catch (JSONException e) {
            value = "";
            e.printStackTrace();
        }

        return value;
    }

    private void generate() {
        InputStream fis = getResources().openRawResource(R.raw.traits);
        try {
            StringBuilder str = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            while (in.ready()) {
                str.append(in.readLine());
            }
            JSONObject jdata = new JSONObject(str.toString());
            JSONArray appearances = jdata.getJSONArray("appearances");
            JSONArray mannerism = jdata.getJSONArray("mannerisms");
            JSONArray races = jdata.getJSONArray("races");
            JSONArray low = jdata.getJSONArray("low_abilities");
            JSONArray high = jdata.getJSONArray("high_abilities");
            JSONArray interactions = jdata.getJSONArray("interactions");
            JSONArray backgrounds = jdata.getJSONArray("backgrounds");
            JSONArray bonds = jdata.getJSONArray("bonds");
            JSONArray flaws = jdata.getJSONArray("flaws_secrets");
            JSONArray ideals = jdata.getJSONArray("ideals");
            JSONArray talents = jdata.getJSONArray("talents");

            appearance_txt.setText(getTrait(appearances));
            mannerism_txt.setText(getTrait(mannerism));
            race_txt.setText(getTrait(races));
            low_txt.setText(getTrait(low));
            high_txt.setText(getTrait(high));
            interactions_txt.setText(getTrait(interactions));
            backgrounds_txt.setText(getTrait(backgrounds));
            bond_txt.setText(getTrait(bonds));
            flaws_txt.setText(getTrait(flaws));
            ideal_txt.setText(getTrait(ideals));
            talent_txt.setText(getTrait(talents));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}