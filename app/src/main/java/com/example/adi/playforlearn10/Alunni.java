package com.example.adi.playforlearn10;

/**
 * Created by raffaeledellaporta on 11/02/2017.
 */

public class Alunni {
    String nome, punteggio;

    public Alunni(String nome, String punteggio) {
        this.nome = nome;
        this.punteggio = punteggio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getPunteggio() {
        return punteggio;
    }
}

//todo javadoc