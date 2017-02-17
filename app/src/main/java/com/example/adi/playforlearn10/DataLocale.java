package com.example.adi.playforlearn10;

import java.util.ArrayList;

/**
 * Created by Adi on 17/02/2017.
 */

public class DataLocale {
public static ArrayList<Utente> utenti;

    public DataLocale(ArrayList<Utente> utenti) {
        this.utenti = utenti;
    }

    public static ArrayList<Utente> getUtenti() {
        return utenti;
    }

    public static void setUtenti(ArrayList<Utente> utenti) {
        DataLocale.utenti = utenti;
    }

    public void aggiungiUtente(String nome, String cognome, String username, String password, String id_utente){
        utenti.add( new Utente("5","ciao","ciao","ciao","ciao"));
        utenti.add( new Utente("5","ciao","ciao","ciao","ciao"));
        utenti.add( new Utente("5","ciao","ciao","ciao","ciao"));
        utenti.add( new Utente("5","ciao","ciao","ciao","ciao"));
        utenti.add( new Utente("5","ciao","ciao","ciao","ciao"));
        utenti.add( new Utente("5","ciao","ciao","ciao","ciao"));
        utenti.add( new Utente("5","ciao","ciao","ciao","ciao"));
        utenti.add( new Utente("5","ciao","ciao","ciao","ciao"));

    }
}
