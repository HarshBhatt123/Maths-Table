package com.example.mathstable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String>  tableList;
    ListView listView;


    public  void generate(int a){
        tableList = new ArrayList<String>();

        for(int i=1;i<=10;i++){
            String x = Integer.toString((a+2)*i);
            String y = Integer.toString(a+2)+" X "+Integer.toString(i)+" = "+x;
            tableList.add(y);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,tableList);
        listView.setAdapter(arrayAdapter);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        listView = findViewById(R.id.lv);

        seekBar.setMax(18);
        seekBar.setProgress(8);
        generate(8);




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               generate(progress);
                }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}