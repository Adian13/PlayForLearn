package com.example.adi.playforlearn10;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.sip.SipAudioCall;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import static com.example.adi.playforlearn10.HomeAlunno.PRIMA;
import static com.example.adi.playforlearn10.HomeAlunno.STORIA;

/**
 * Created by Adi on 18/01/2017.
 */

public class ActivityGiocoStoGioIng extends AppCompatActivity{
    private String nome, materia, classe;
    int errori=0, numEs=0, record=0;
    ArrayList<Gioco_StoGeoIng> giochiDaLanciare;
    private Drawable icona;
    Integer immagine;
    Gioco_StoGeoIng gioco;
    public Button bt1, bt2, bt3, bt4;

    public String soluzione,opzione1, opzione2, opzione3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numEs= getIntent().getIntExtra("Indice", 0);
        errori= getIntent().getIntExtra("errori", 0);
        record= getIntent().getIntExtra("record", 0);
        setContentView(R.layout.activity_gioco);
         bt2 = (Button) findViewById(R.id.bt2);
        bt1 = (Button) findViewById(R.id.bt1);
         bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        giochiDaLanciare= new ArrayList<Gioco_StoGeoIng>();


        //Gioco_StoGeoIng gioco= new Gioco_StoGeoIng(icona,  nome,  materia, classe, errori, immagine, soluzione,  opzione1, opzione2,  opzione3);
        materia=STORIA;
        if(materia.compareTo(STORIA)==0){
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.darenome_casa_lampada,"Lampada","Letto","Divano","Sedia"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.darenome_casa_letto,"Letto","Tavolo","Divano","Sedia"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.darenome_casa_padella,"Padella","Piatto","Tavolo","Cucchiaio"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.darenome_casa_vasca,"Vasca","Water","Sedia","Scrivania"));

        }
        gioco= giochiDaLanciare.get(numEs);
        ArrayList<String> opzioni = new ArrayList<String>(4);
        opzioni.add(gioco.getSoluzione());
        opzioni.add(gioco.getOpzione1());
        opzioni.add(gioco.getOpzione2());
        opzioni.add(gioco.getOpzione3());
        ArrayList<Button> pulsanti = new ArrayList<Button>(4);
        pulsanti.add(bt1);
        pulsanti.add(bt2);
        pulsanti.add(bt3);
        pulsanti.add(bt4);
        setOptions(opzioni, pulsanti);

        //   esercizi.add(esercizi di storia);
        //}
        makeBind();
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

    private void makeBind() {
        ImageView imageView = (ImageView) findViewById(R.id.ivImmagine);
        imageView.setImageResource((giochiDaLanciare.get(numEs)).getImmagine());
        //imageView.refreshDrawableState();

        MyOnClick myOnClick= new MyOnClick();
        bt1.setOnClickListener(myOnClick);
        bt2.setOnClickListener(myOnClick);
        bt3.setOnClickListener(myOnClick);
        bt4.setOnClickListener(myOnClick);
    }

    public  class MyOnClick implements View.OnClickListener {
        public void onClick(View v) {
            Button bt= (Button)v;
            checkSoluzione(giochiDaLanciare.get(numEs),bt.getText().toString());
           // numEs++;
            avviaSuccessivoOFine();
        }
    }
    //TODO controllo su quale layout caricare
    public boolean checkSoluzione(Gioco_StoGeoIng gioco, String opzione){
        if(opzione.compareTo(gioco.getSoluzione())==0){
            avviaSuccessivoOFine();
            record++;
            return  true;
        }else{
            errori++;
            return false;
        }
    }
    public void avviaSuccessivoOFine() {
        if (numEs < giochiDaLanciare.size()-1) {
            Intent i = new Intent(getApplicationContext(), FineGioco.class);
            i.putExtra("Indice", numEs+1);
            i.putExtra("errori", errori);
            i.putExtra("record", record);
            startActivity(i);
        } else fine();
    }

    public void fine(){
        Intent i = new Intent(getApplicationContext(), FineGioco.class);
        i.putExtra("errori", errori);
        i.putExtra("record", record);
    }

    private Integer getRandomInt(int max) {
        int n = ((int) Math.round(Math.random() * max) % max);
        if (n >= 0) Log.d("DEBUG", "Il numero casuale scelto è " + n);
        return n >= 0 ? n : max - 1;
    }

}
