package com.example.adi.playforlearn10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Adi on 22/01/2017.
 */

public class RecordPersonali extends AppCompatActivity implements Serializable{
   static ArrayList<Integer> recorditaliano, recordmatematica, recordinglese, recordstoria, recordgeografia;

    public ArrayList<Integer> getRecorditaliano() {
        return recorditaliano;
    }

    public void setRecorditaliano(ArrayList<Integer> recorditaliano) {
        this.recorditaliano = recorditaliano;
    }

    public ArrayList<Integer> getRecordmatematica() {
        return recordmatematica;
    }

    public void setRecordmatematica(ArrayList<Integer> recordmatematica) {
        this.recordmatematica = recordmatematica;
    }

    public ArrayList<Integer> getRecordinglese() {
        return recordinglese;
    }

    public void setRecordinglese(ArrayList<Integer> recordinglese) {
        this.recordinglese = recordinglese;
    }

    public ArrayList<Integer> getRecordstoria() {
        return recordstoria;
    }

    public void setRecordstoria(ArrayList<Integer> recordstoria) {
        this.recordstoria = recordstoria;
    }

    public ArrayList<Integer> getRecordgeografia() {
        return recordgeografia;
    }

    public void setRecordgeografia(ArrayList<Integer> recordgeografia) {
        this.recordgeografia = recordgeografia;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_personali);
        TextView txItaliano= (TextView)findViewById(R.id.txItaliano);
        TextView txMatematica= (TextView)findViewById(R.id.txMatematica);
        TextView txGeorafia= (TextView)findViewById(R.id.txGeografia);
        TextView txStoria= (TextView)findViewById(R.id.txInglese);
        TextView txInglese= (TextView)findViewById(R.id.txStoria);
        recordgeografia= new ArrayList<Integer>();
        recordinglese= new ArrayList<Integer>();
        recorditaliano= new ArrayList<Integer>();
        recordmatematica= new ArrayList<Integer>();
        recordstoria= new ArrayList<Integer>();

        txGeorafia.setText(getMax(recordgeografia)+"");
        txInglese.setText(getMax(recordinglese)+"");
        txItaliano.setText(getMax(recorditaliano)+"");
        txMatematica.setText(getMax(recordmatematica)+"");
        txStoria.setText(getMax(recordstoria)+"");

    }
    private int getMax(ArrayList<Integer>  arrayList){
        int max=0;
        for (int i : arrayList) {
            if(arrayList.get(i)< arrayList.get(i+1))
                max= arrayList.get(i+1);
            else max= arrayList.get(i);
        }
        return max;
    }
}
