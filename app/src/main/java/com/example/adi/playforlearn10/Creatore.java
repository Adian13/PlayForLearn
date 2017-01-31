/*
package com.example.adi.playforlearn10;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import static com.example.adi.playforlearn10.HomeAlunno.PRIMA;
import static com.example.adi.playforlearn10.HomeAlunno.STORIA;

*/
/**
 * Created by Adi on 12/01/2017.
 *//*


public class Creatore extends AppCompatActivity implements Serializable{
    static ArrayList<Gioco> giochiItaliano;
    static ArrayList<Gioco> giochiDaLanciare;
    static ArrayList<Gioco> giochiMatematica;
    static ArrayList<Gioco> giochiInglese;
    static ArrayList<Gioco>  giochi;
    TextView log;
    File file;
    static ArrayList<Gioco> giochiStoria;
    static ArrayList<Gioco> giochiGeografia;
    public static final String SESSIONECORRENTE = "sessioneCorrente";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.creatore);
        log = (TextView) findViewById(R.id.log);
        // Controllo se esiste il file. Se non esiste, crea tutto
        if(file.exists()) file.delete();
        if(!file.exists()){
            try{
                //TODO caricare i giochi
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(giochiDaLanciare);
                objectOutputStream.close();
                Toast.makeText(getApplicationContext(), "Ho creato il file con " + giochi.size() +" giochi " , Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(Creatore.this, "File no found. Impossibile creare/salvare il file", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(Creatore.this, "I/O. Impossibile creare/salvare il file", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "file esistente", Toast.LENGTH_LONG).show();
            //caricare i giochi
        }
    }
    private void caricaGiochi() {
        try {
            FileInputStream fileInputStream = new FileInputStream(getApplicationContext().openFileInput(SESSIONECORRENTE).getFD());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            giochiDaLanciare = (ArrayList<Gioco>) objectInputStream.readObject();
            objectInputStream.close();
            Toast.makeText(Creatore.this, "Ho caricato l'array", Toast.LENGTH_SHORT).show();
            Log.d("DEBUG Creatore", "Ho caricato l'array");
        } catch (FileNotFoundException e) {
            Toast.makeText(Creatore.this, "Impossibile trovare il file", Toast.LENGTH_SHORT).show();
            Log.d("DEBUG Creatore", "non trovo il file");
            e.printStackTrace();
        } catch (IOException e1){
            e1.printStackTrace();
            Toast.makeText(Creatore.this, "errore nel cast dell'array", Toast.LENGTH_SHORT).show();
            Log.d("DEBUG Creatore", "errore nel cast");
        }catch (ClassNotFoundException e2){
            Toast.makeText(Creatore.this, "classe non trovata vedi il cast", Toast.LENGTH_SHORT).show();
            Log.d("DEBUG Creatore", "classe non trovata vedi il cast");
            e2.printStackTrace();
        }
    }
    private int getNextIntRandom(int max){
        int n = ((int)Math.round(Math.random()*max)%max);
        if(n>0) Log.d("DEBUG","Il numero casuale scelto è " + n);
        return n>0?n:max-1;
    }

    private void creaGiochi(){
        Gioco gioco_storia= new Gioco_Storia(null,null,null,null,0,null,null,null,null,null);
        giochiDaLanciare= new ArrayList<Gioco>();
        //TODO creare i casi di gioco e aggiungerli all'array
        giochiDaLanciare.add(new Gioco_Storia(gioco_storia.getIcona(),"Riconoscimento",STORIA, PRIMA,0,R.drawable.darenome_casa_tavolo,"Tavolo","Scrivania","Sedia","Cucchiaio"));
        giochiDaLanciare.add(new Gioco_Storia(gioco_storia.getIcona(),"Riconoscimento",STORIA, PRIMA,0,R.drawable.darenome_casa_lampada,"Lampada","Letto","Divano","Sedia"));
        giochiDaLanciare.add(new Gioco_Storia(gioco_storia.getIcona(),"Riconoscimento",STORIA, PRIMA,0,R.drawable.darenome_casa_letto,"Letto","Tavolo","Divano","Sedia"));
        giochiDaLanciare.add(new Gioco_Storia(gioco_storia.getIcona(),"Riconoscimento",STORIA, PRIMA,0,R.drawable.darenome_casa_padella,"Padella","Piatto","Tavolo","Cucchiaio"));
        giochiDaLanciare.add(new Gioco_Storia(gioco_storia.getIcona(),"Riconoscimento",STORIA, PRIMA,0,R.drawable.darenome_casa_vasca,"Vasca","Water","Sedia","Scrivania"));

        //TODO Creazione dei file per le sessioni da completare e sessioni completate
        //TODO creare la sessione
        // salvaSessione(sessione corrente);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomeAlunno.class));
        finish();
        //TODO implementarlo ad ogni classe
    }

    private boolean salvaSessione(Sessione s){
        File file = new File(getApplicationContext().getFilesDir(), "risultati");
        try{
            FileOutputStream fileOutputStream= new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(s);
            objectOutputStream.close();
            Log.d("DEBUG Creatore", "Ho salvato la sessione");
            return true;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            Log.d("DEBUG Creatore", "file non trovato");
            return false;
        }catch (IOException e) {
            e.printStackTrace();
            Log.d("DEBUG Creatore", "cerca le sfere... non ho altre speranze");
            return false;
        }
    }
}
*/
