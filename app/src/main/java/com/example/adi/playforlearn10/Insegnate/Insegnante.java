package com.example.adi.playforlearn10.Insegnate;

import com.example.adi.playforlearn10.Utente;

import java.util.ArrayList;

/**
 * Created by Adi on 17/02/2017.
 */

public class Insegnante extends Utente {
    ArrayList<String> materia, classe;

    public Insegnante(String id, String nome, String cognome, String password, String username, ArrayList<String> materia, ArrayList<String>classe) {
        super(id, nome, cognome, password, username);
        this.materia = materia;
        this.classe= classe;
    }

    public ArrayList<String> getMateria() {
        return materia;
    }

    public void setMateria(ArrayList<String> materia) {
        this.materia = materia;
    }

    public ArrayList<String> getClasse() {
        return classe;
    }

    public void setClasse(ArrayList<String> classe) {
        this.classe = classe;
    }
}
//TODO javadc