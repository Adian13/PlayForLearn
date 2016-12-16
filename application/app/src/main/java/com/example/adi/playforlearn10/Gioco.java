package com.example.adi.playforlearn10;


import android.graphics.drawable.Drawable;

public class Gioco {
    private String nome, materia, classe;
    //private Drawable icona;

    public Gioco(String nome, String materia, String classe, Drawable icona) {
        this.nome = nome;
        this.materia = materia;
        this.classe = classe;
      //  this.icona = icona;
    }

    public String getNome() {
        return nome;
    }

    public String getMateria() {
        return materia;
    }

    public String getClasse() {
        return classe;
    }

    /*public Drawable getIcona() {
        return icona;
    }

    public void setIcona(Drawable icona) {
        this.icona = icona;
    }*/
}
