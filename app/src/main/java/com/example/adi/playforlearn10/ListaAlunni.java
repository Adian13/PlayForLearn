package com.example.adi.playforlearn10;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;


import com.example.adi.playforlearn10.Insegnante.HomeMaestra;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ListaAlunni è una classe che rappresenta la lista degli alunni della classe "Prima" con i rispettivi record. La classe
 * viene gestita dal json che è un semplice formato per lo scambio di dati. Il json restituirà alla fine l'username e il
 * record del singolo utente.
 */


public class ListaAlunni extends AppCompatActivity {
    private static ArrayList<Alunni> alunni;
    public EditText edit;
    Alunni alunno;
    ArrayList<Alunni> alunniDaVisualizzare;
    AlunniListAdapter customAdapter, cercati;
    AlertDialog.Builder miaAlert;
    private boolean trovato=false;
    ImageButton lente;
    String str="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_alunni);
        edit=(EditText)findViewById(R.id.edit);
        String str=edit.getText().toString();
        getSupportActionBar().setTitle("Lista Alunni");
        miaAlert = new AlertDialog.Builder(this);
        lente= (ImageButton)findViewById(R.id.lente);
        lente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ricerca(edit.getText().toString());
            }
        });
        popola();
    }

  public boolean ricerca(String str){
      str=edit.getText().toString();
      int i=0, k=0;
      int j= str.length()+i;
      for(i=0;i<str.length();i++){
          if(j<str.length()){
              alunno= alunni.get(k);
              if(alunno.getNome().substring(i,j).compareToIgnoreCase(str)==0){
                  trovato=true;
                  alunniDaVisualizzare.add(alunni.get(i));
              }else trovato=false;
          }k++;
          j++;
          return trovato;
      }

      return trovato;
  }
    private void setTextLista() {
        ListView ll = (ListView) findViewById(R.id.lista);
        customAdapter=new AlunniListAdapter(ListaAlunni.this, R.layout.lista_row, alunni);
        ll.setAdapter(customAdapter);
        Log.d("DEBUG_alunni", String.valueOf(alunni.size()));
    }


    private void popola() {
        new AsyncTask<Object, Object, Object>() {

            @Override
            protected void onPreExecute() {
                alunni = new ArrayList<Alunni>(10);
            }

            @Override
            protected Object doInBackground(Object... params) {
                String nome, record;
                try {
                    String ip = LoginActivity.INDIRIZZO;
                    int porta = 80;
                    String nomeFile = "webservice/lista.php";
                    URL url = new URL("http", ip, porta, nomeFile);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    Scanner scanner = new Scanner(connection.getInputStream());
                    String response = "";
                    JSONObject obj = null;
                    while (scanner.hasNext()) {
                        response = scanner.nextLine();
                        obj = new JSONObject(response);
                        Log.d("DEBUG_response",response);
                        nome = obj.getString("fk_username");
                        record = obj.getString("record");
                        alunni.add(new Alunni(nome,record));

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                setTextLista();
            }
        }.execute();
    }

    public void onBackPressed() {
        //super.onBackPressed();
        Intent i= new Intent(getApplicationContext(), HomeMaestra.class);
        startActivity(i);
        finish();
    }
}