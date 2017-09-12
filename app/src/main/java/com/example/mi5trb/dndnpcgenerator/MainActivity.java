package com.example.mi5trb.dndnpcgenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                txt_rand1.setText(String.valueOf(new Random().nextInt(11)));
                txt_rand2.setText(String.valueOf(new Random().nextInt(11)));
                txt_rand3.setText(String.valueOf(new Random().nextInt(11)));
            }
        });
    }
}