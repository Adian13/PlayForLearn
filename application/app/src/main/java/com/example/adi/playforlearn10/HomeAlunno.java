package com.example.adi.playforlearn10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeAlunno extends AppCompatActivity {

    public static final String ITALIANO = "ITALIANO";
    public static final String MATEMATICA = "MATEMATICA";
    public static final String MATERIA = "MATERIA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_alunno);

        getSupportActionBar().setTitle("Home alunno");

        Button account = (Button) findViewById(R.id.btAccount);
        Button btItaliano =(Button)findViewById(R.id.btItaliano);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AccountAlunno.class);
                startActivity(i);
                finish();
            }
        });
        btItaliano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Games.class);
                i.putExtra(MATERIA,ITALIANO);
                startActivity(i);
                finish();
            }
        });
        Button btMatematica = (Button)findViewById(R.id.btMatematica);
        btMatematica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Games.class);
                i.putExtra(MATERIA,MATEMATICA);
                startActivity(i);
                finish();
            }
        });
    }
}
