package com.example.adi.playforlearn10.Alunno;

import android.content.Intent;

import com.example.adi.playforlearn10.Utente;

/**
 * Created by Adi on 17/02/2017.
 */

public class Alunno extends Utente {
    /**
     *
     */
    String classe;
    int record;

    public Alunno(String id, String nome, String cognome, String password, String username, int record, String classe) {
        super(id, nome, cognome, password, username);
        this.record = record;
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }
}
//TODO java doc