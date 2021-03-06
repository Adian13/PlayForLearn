package com.example.adi.playforlearn10.Giochi;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.adi.playforlearn10.Alunno.HomeAlunno;
import com.example.adi.playforlearn10.R;
import com.example.adi.playforlearn10.Record.RecordPersonali;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.adi.playforlearn10.Alunno.HomeAlunno.GEOGRAFIA;
import static com.example.adi.playforlearn10.Alunno.HomeAlunno.INGLESE;
import static com.example.adi.playforlearn10.Alunno.HomeAlunno.ITALIANO;
import static com.example.adi.playforlearn10.Alunno.HomeAlunno.MATEMATICA;
import static com.example.adi.playforlearn10.Alunno.HomeAlunno.MATERIA;
import static com.example.adi.playforlearn10.Alunno.HomeAlunno.STORIA;

/**
 * Created by Adi on 18/01/2017.
 */

public class ActivityGiocoStoGioIng extends AppCompatActivity implements Serializable{
    private String nome, materia, classe;
    int errori, numEs, record;
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
        errori= getIntent().getIntExtra("errori", errori);
        record= getIntent().getIntExtra("record",errori);
        setContentView(R.layout.activity_gioco);
        bt2 = (Button) findViewById(R.id.bt2);
        bt1 = (Button) findViewById(R.id.bt1);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        giochiDaLanciare= new ArrayList<Gioco_StoGeoIng>();
        materia= getIntent().getStringExtra("MATERIA");
        Log.d("DEBUG", materia);
        //Gioco_StoGeoIng gioco= new Gioco_StoGeoIng(icona,  nome,  materia, classe, errori, immagine, soluzione,  opzione1, opzione2,  opzione3);

        if(materia.compareTo(STORIA)==0){
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.darenome_casa_lampada,"Lampada","Letto","Divano","Sedia"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.darenome_casa_letto,"Letto","Tavolo","Divano","Sedia"));}
        else if(materia.compareTo(GEOGRAFIA)==0){
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.piramide, "Piramide", "Pappagallo", "Nonno", "Barca"));

            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.montagna, "Montagna", "heidi", "capre", "fiume"));
        }
        else if(materia.compareTo(INGLESE)==0){
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.piramide, "Piramide", "Pappagallo", "Nonno", "Barca"));

            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.sole, "Sun", "Sardegna", "Sardina", "mamma"));
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.stelle, "Stars", "mappa", "cappa", "mamma"));

        } else if(materia.compareTo(MATEMATICA)==0){
            giochiDaLanciare.add(new Gioco_StoGeoIng(R.drawable.images, "15", "a", "d", "casa"));

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


        //   esercizi.add(esercizi di storia);
        //}
        makeBind();
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
            record++;
            avviaSuccessivoOFine();
            return  true;
        }else{
            errori++;
            avviaSuccessivoOFine();
            return false;
        }
    }
    public void avviaSuccessivoOFine() {
        if (numEs <= 7){
            Intent i = new Intent(this, ActivityGiocoStoGioIng.class);
            numEs++;
            i.putExtra("Indice", numEs);
            i.putExtra(MATERIA, materia);
            i.putExtra("errori", errori);
            i.putExtra("record", record);
            startActivity(i);
            finish();
        }else if (numEs >7){
            //salvaRecord(record);
            Intent i = new Intent(getApplicationContext(), FineGioco.class);
            i.putExtra("errori", errori);
            i.putExtra("record", record);
            i.putExtra("MATERIA",materia);
            i.putExtra("activity", "ActivityGiocoStoGioIng");
            startActivity(i);
            finish();
        }
    }

    /*public void fine(){
        Intent i = new Intent(getApplicationContext(), FineGioco.class);
        i.putExtra("errori", errori);
        i.putExtra("record", record);
    }*/



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i= new Intent(getApplicationContext(), HomeAlunno.class);
        startActivity(i);
        finish();
    }

    public void salvaRecord(int record){
        //TODO salvataggio
        /**
         * salvo il valore del record alla fine della giocata e lo salvo sul db
         */
        /*switch (materia){
            case ITALIANO:
                RecordPersonali.recorditaliano.add(record);
                break;
            case MATEMATICA:
                RecordPersonali.recordmatematica.add(record);
                break;
            case  INGLESE:
                RecordPersonali.recordinglese.add(record);
                break;
            case STORIA:
                RecordPersonali.recordstoria.add(record);
                break;
            case GEOGRAFIA:
                RecordPersonali.recordgeografia.add(record);
                break;
        }*/

    }
//todo javadoc
}
