package com.example.adi.playforlearn10;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Adi on 18/01/2017.
 */
public class FineGioco extends AppCompatActivity{
   public TextView txErr, txRec;
    int errori;
    int record;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fine_gioco);
        errori= getIntent().getIntExtra("errori", 0);
        record= getIntent().getIntExtra("record", 0);
        txErr= (TextView)findViewById(R.id.txerrori);
        //txErr.setText("errori");
        txErr.setText(errori+"");
        txRec= (TextView)findViewById(R.id.record);
        txRec.setText(record+"");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i= new Intent(getApplicationContext(), HomeAlunno.class);
        startActivity(i);
        finish();
    }
}
