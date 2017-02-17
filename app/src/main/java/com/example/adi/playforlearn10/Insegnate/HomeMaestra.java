package com.example.adi.playforlearn10.Insegnate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.adi.playforlearn10.R;
import com.example.adi.playforlearn10.Record.RecordTop10;
import com.example.adi.playforlearn10.SezioneClassi;

/**
 * Created by raffaeledellaporta on 28/01/2017.
 */

public class HomeMaestra extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_maestra);

        getSupportActionBar().setTitle("Home Maestra");
    }

    public void italiano(View v){
        Intent i = new Intent(getApplicationContext(),SezioneClassi.class);
        startActivity(i);
        finish();
    }

    public void matematica(View v){
        Intent i = new Intent(getApplicationContext(),SezioneClassi.class);
        startActivity(i);
        finish();
    }

    public void inglese(View v){
        Intent i = new Intent(getApplicationContext(),SezioneClassi.class);
        startActivity(i);
        finish();
    }

    public void storia_e_geografia(View v){
        Intent i = new Intent(getApplicationContext(),SezioneClassi.class);
        startActivity(i);
        finish();
    }

    public void account(View v){
        Intent i = new Intent(getApplicationContext(),AccountMaestra.class);
        startActivity(i);
        finish();
    }

    public void notifica(View v){
        //TODO da vedere bene
        // Intent i = new Intent(getApplicationContext(),NotificaAccettazioneUtente.class);
       // startActivity(i);
        //finish();
    }

    public void top10(View v){
        Intent i = new Intent(getApplicationContext(), RecordTop10.class);
        startActivity(i);
        finish();
    }
    //TODO javadoc
}
