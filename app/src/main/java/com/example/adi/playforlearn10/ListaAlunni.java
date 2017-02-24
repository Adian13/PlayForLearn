package com.example.adi.playforlearn10;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by raffaeledellaporta on 29/01/2017.
 */

/**
 * Created by raffaeledellaporta on 29/01/2017.
 */

public class ListaAlunni extends AppCompatActivity {
    private static ArrayList<Alunni> alunni;
    AlunniListAdapter customAdapter;
    AlertDialog.Builder miaAlert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_alunni);
        getSupportActionBar().setTitle("Lista Alunni");
        miaAlert = new AlertDialog.Builder(this);
        popola();
    }

    private void setTextLista() {
        ListView ll = (ListView) findViewById(R.id.lista);
        customAdapter=new AlunniListAdapter(ListaAlunni.this, R.layout.lista_row, alunni);
        ll.setAdapter(customAdapter);
        ll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Alunni a1=customAdapter.getItem(position);
                miaAlert.setMessage(a1.getNome());
                miaAlert.setTitle("Vuoi davvero cancellare");
                miaAlert.setCancelable(false);
                miaAlert.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    //   RimuoviUtente rimuovi=new RimuoviUtente();
                      //  rimuovi.rimuoviUtente();
                       // customAdapter.remove(customAdapter.getItem(position));
                    }
                });

                miaAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = miaAlert.create();
                alert.show();
            }
        });
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
                    String ip = LoginActivityAndroidIda.INDIRIZZO;
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
                        nome = obj.getString("username");
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
}