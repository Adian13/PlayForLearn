package com.example.adi.playforlearn10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Adi on 22/01/2017.
 */

public class RecordPersonali extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_personali);
        TextView txItaliano= (TextView)findViewById(R.id.txItaliano);
        TextView txMatematica= (TextView)findViewById(R.id.txMatematica);
        TextView txGeorafia= (TextView)findViewById(R.id.txGeografia);
        TextView txStoria= (TextView)findViewById(R.id.txInglese);
        TextView txInglese= (TextView)findViewById(R.id.txStoria);
    }
}
