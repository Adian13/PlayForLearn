package com.example.adi.playforlearn10.Record;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.adi.playforlearn10.Alunno.HomeAlunno;
import com.example.adi.playforlearn10.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Adi on 22/01/2017.
 */

public class RecordPersonali extends AppCompatActivity {

    private static Record record;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_personali);
        // TODO Controlla se il file esiste
        // TODO Se il file non esiste si deve creare una struttura vuota e quindi creare il file
    }

    public static void aggiornaRecord(String materia,String classe, int newRecord){
        // TODO Non so se si dovrebbe fare la distinzione fra le classi
        switch (materia.toUpperCase()){
            case HomeAlunno.ITALIANO:
                if(record.getRecordItaliano() < newRecord){
                    record.setRecordItaliano(newRecord);
                    salvaRecordSuFile(record);
                }
                break;
            case HomeAlunno.GEOGRAFIA:
                // TODO Fare la stessa cosa di Italiano per le altre materie
                break;
            case HomeAlunno.INGLESE:
                break;
            case HomeAlunno.MATEMATICA:
                break;
            case HomeAlunno.STORIA:
                break;
        }
    }

    private static void salvaRecordSuFile(Record record){
        // TODO salvare il record passato in input su file
    }

    private class Record implements Serializable{
        int recordItaliano, recordStoria, recordInglese, recordMatematica, recordGeografia;

        public Record(int recordItaliano, int recordStoria, int recordInglese, int recordMatematica, int recordGeografia) {
            this.recordItaliano = recordItaliano;
            this.recordStoria = recordStoria;
            this.recordInglese = recordInglese;
            this.recordMatematica = recordMatematica;
            this.recordGeografia = recordGeografia;
        }

        public int getRecordItaliano() {
            return recordItaliano;
        }

        public int getRecordStoria() {
            return recordStoria;
        }

        public int getRecordInglese() {
            return recordInglese;
        }

        public int getRecordMatematica() {
            return recordMatematica;
        }

        public int getRecordGeografia() {
            return recordGeografia;
        }

        public void setRecordItaliano(int recordItaliano) {
            this.recordItaliano = recordItaliano;
        }

        public void setRecordStoria(int recordStoria) {
            this.recordStoria = recordStoria;
        }

        public void setRecordInglese(int recordInglese) {
            this.recordInglese = recordInglese;
        }

        public void setRecordMatematica(int recordMatematica) {
            this.recordMatematica = recordMatematica;
        }

        public void setRecordGeografia(int recordGeografia) {
            this.recordGeografia = recordGeografia;
        }
    }
}
