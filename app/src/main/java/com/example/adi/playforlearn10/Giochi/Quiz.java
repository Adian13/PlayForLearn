package com.example.adi.playforlearn10.Giochi;

/**
 * Created by raffaeledellaporta on 19/12/2016.
 */
public class Quiz {
    private String testo;
    private boolean risposta;
    private boolean counted;

    public Quiz(String str, boolean risposta) {
        testo = str;
        this.risposta = risposta;
        counted = false;
    }

    public String getTesto() {
        return testo;
    }

    public boolean getRisposta() {
        return risposta;
    }

    public void setRisposta(boolean risposta) {
        this.risposta = risposta;
    }
}


