/*
package com.example.adi.playforlearn10;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

*/
/**
 * Created by Adi on 12/01/2017.


public class GiocoActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button bt1, bt2, bt3, bt4;
    private Gioco_Storia gioco_storia;
    int errori;
    private ArrayList<Gioco> giochiLanciati;
    private MyOnClickListener myOnClickListener;
    private Sessione sessione;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioco);

        sessione=caricaSessione();

        //Inserimento dell'indietro solo se non è una sessione assegnata
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        // Gioco_Storia gioco_storia= new Gioco_Storia("STORIA","PRIMA",0,R.drawable.darenome_animali_panda,"Panda","Orso","Orca","Koala");
        gioco_storia = (Gioco_Storia) Creatore.giochiDaLanciare.get(getRandomInt(Creatore.giochiDaLanciare.size()));
        makeBind();
        ArrayList<String> opzioni = new ArrayList<String>(4);
        opzioni.add(gioco_storia.getSoluzione());
        opzioni.add(gioco_storia.getOpzione1());
        opzioni.add(gioco_storia.getOpzione2());
        opzioni.add(gioco_storia.getOpzione3());
        ArrayList<Button> pulsanti = new ArrayList<Button>(4);
        pulsanti.add(bt1);
        pulsanti.add(bt2);
        pulsanti.add(bt3);
        pulsanti.add(bt4);
        setOptions(opzioni, pulsanti);

    }
    private void makeBind() {
        imageView = (ImageView) findViewById(R.id.ivImmagine);
        imageView.setImageResource(gioco_storia.getImageView());
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);

        myOnClickListener = new MyOnClickListener();

        bt1.setOnClickListener(myOnClickListener);
        bt2.setOnClickListener(myOnClickListener);
        bt3.setOnClickListener(myOnClickListener);
        bt4.setOnClickListener(myOnClickListener);

    }
    private Integer getRandomInt(int max) {
        int n = ((int) Math.round(Math.random() * max) % max);
        if (n >= 0) Log.d("DEBUG", "Il numero casuale scelto è " + n);
        return n >= 0 ? n : max - 1;
    }
    private void setOptions(ArrayList<String> opzioni, ArrayList<Button> pulsanti) {
        int p = 0, o = 0;
        for (int i = 0; i < 4; i++) {
            p = getRandomInt(pulsanti.size());
            o = getRandomInt(opzioni.size());
            pulsanti.get(p).setText(opzioni.get(o));
            pulsanti.remove(p);
            opzioni.remove(o);
        }
    }
    private void checkSolution(String solution) {
        if (solution.compareToIgnoreCase(gioco_storia.getSoluzione()) != 0) {
            errori++;
        }
    }
    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            checkSolution(((Button) v).getText().toString());
            //Intent i = new Intent(getApplicationContext(), GiocoActivity.class);
            // startActivity(i);

            //   sessione.setGioco_base(Creatore.eserciziSelezionalibili.get(getRandomInt(6)));
            Log.d("DEBUG", "La sessione ha " + sessione.getGiochiSessione().size() + " elementi");

            giochiLanciati.addAll(sessione.getGiochiSessione());
            Gioco temp = giochiLanciati.get(sessione.getId());
            temp.setErrori(sessione.getErroriTotali() + 1);
            sessione.setErroriTotali(sessione.getErroriTotali() + temp.getErrori());
            sessione.setIndice(sessione.getIndice() + 1);
            salvaSessione(sessione);
            if (sessione.getIndice() > (sessione.getGiochiSessione().size() - 1)) {
                try {
                    fineSessione();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Gioco gioco = sessione.getGiochiSessione().get(sessione.getIndice());
                Intent esercizioCorrente;
                if (gioco instanceof Gioco_Storia) {
                    esercizioCorrente = new Intent(getApplicationContext(), Gioco_Storia.class);
                    startActivity(esercizioCorrente);
                    finish();
                } else
                    Log.d("DEBUG", "Impossibile trovare la classe dell'esercizio  " + gioco);
            }

        }

        public void fineSessione() {
            Log.d("DEBUG GSActivity", "sono in fine sessione");

            AlertDialog.Builder builder = new AlertDialog.Builder(GiocoActivity.this);
            builder.setCancelable(false);
            builder.setMessage("Complimenti, hai completato la sessione." + "\nCon " + sessione.getErroriTotali() + " errori totali in " + "s.");
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(getApplicationContext(), HomeAlunno.class));
                    finish();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        private void salvaSessione(Sessione sessione) {
            File file = new File(getFilesDir(), "risultati");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(sessione);
                objectOutputStream.close();
                Log.d("DEBUG GSActivity", "Ho salvato la sessione");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Log.d("DEBUG GSActivity", "file non trovato");
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("DEBUG GSActivity", "cerca le sfere... non ho altre speranze");
            }
        }
    }
    private Sessione caricaSessione(){
            Sessione s = null;
        */
/*if(!file.exists()){

        }*//*

            try {//TODO vedi questo metodo e rifai gli altri x output vai in creatore
                FileInputStream fileInputStream = new FileInputStream(getApplicationContext().openFileInput(Creatore.SESSIONECORRENTE).getFD());
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                s = (Sessione)objectInputStream.readObject();
                // Log.d("DEBUG","s=" + (s==null?"null":s.getIdSess()));
                objectInputStream.close();
                return s;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            //Log.d("DEBUG","Il valore di sessione dovrebbe essere null. Infatti è " + (s==null?"null":s.getIdSess()));
            return s;
        }

    }*/
