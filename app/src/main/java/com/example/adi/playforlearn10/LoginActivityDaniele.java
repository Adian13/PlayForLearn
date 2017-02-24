package com.example.adi.playforlearn10;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.adi.playforlearn10.Alunno.HomeAlunno;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class LoginActivityDaniele extends AppCompatActivity {

    // TODO: 18/02/2017  il layout fa schifo, ma basta adattare il codice al nuovo layout
    // TODO: 18/02/2017 non so come farai a gestire l'alunno e la maestra quindi ho chiamato direttamente la HomeAlunno 
    // TODO: 18/02/2017 Modificare l'onBackPressed della classe che verrà lanciata se vanno bene le credenziali 

    private EditText etUsername, etPassword;
    private String username, password, tipologia;
    private ImageButton ibAlunno, ibMaestra;
    public static Utente utenteLoggato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_daniele);
        getSupportActionBar().setTitle("Login");

        etUsername = (EditText)findViewById(R.id.etUsername);
        etUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginSuccess();
            }
        });
        etPassword = (EditText)findViewById(R.id.etPassword);

        ibAlunno = (ImageButton)findViewById(R.id.ibAlunno);
        ibMaestra = (ImageButton)findViewById(R.id.ibMaestra);

    }
    public void changeBackground(View view) {
        // TODO: 19/02/2017 Aggiustare il layout e i colori
        ((View) view.getParent()).setBackgroundColor(Color.GREEN);
        if(ibAlunno == view){
            // TODO: 19/02/2017 Settare la variabile da mandare al file php
            tipologia="alunno";
            ((View)ibMaestra.getParent()).setBackgroundColor(Color.TRANSPARENT);
        }else if(ibMaestra == view){
            // TODO: 19/02/2017 Settare la variabile da mandare al file php
            tipologia= "insegnante";
            ((View)ibAlunno.getParent()).setBackgroundColor(Color.TRANSPARENT);
        }
    }

    public void entra(View view){
        if(checkEmpty()){
            return;
        }

        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        // Chiamata al database con una query che restituisce l'utente che ha username e password corrispondenti
        new AsyncTask<Object,Boolean,Object>(){

            @Override
            protected void onProgressUpdate(Boolean... values) {
                if(values[0]){
                    loginSuccess();
                }else{
                    loginFailed();
                }
            }

            @Override
            protected Object doInBackground(Object... params) {
                try {
                    // TODO: 18/02/2017 Attenzione all'ip che può cambiare
                    String ip = "192.168.1.20", nomeFile="webservice/login.php";
                    int porta = 80;
                    URL url = new URL("http",ip, porta, nomeFile);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);

                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
                    bufferedWriter.write("username=" + username + "&password=" + password);
                    bufferedWriter.close();

                    Scanner scanner = new Scanner(connection.getInputStream());
                    String line = scanner.nextLine();
                    if(line.length() < 2){
                        publishProgress(false);
                        this.cancel(true);
                    }else{
                        JSONArray jsonObject = new JSONArray(line);
                        // TODO: 18/02/2017 Attenzione ci sono dei campi che non ha utente quindi si dovrebbe modificare o la query o il db 
                        // la stringa è formattata nel seguente modo: username, nome, cognome, password
                        utenteLoggato = new Utente("",jsonObject.getString(1),jsonObject.getString(2),jsonObject.getString(3), jsonObject.getString(0));
                        publishProgress(true);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    private void loginSuccess(){
        // TODO si dovrebbero salvare le informazioni dell'utente in un bundle
        Intent intent = new Intent(getApplicationContext(), HomeAlunno.class);
        intent.putExtra("utenteLoggato", utenteLoggato);
        startActivity(intent);
        finish();
    }

    private void loginFailed(){
        // TODO: 18/02/2017 Mettere qualcosa di più sfizioso
        Toast.makeText(this, "Credenziali non valide", Toast.LENGTH_SHORT).show();
    }

    public void registrati(View view){
        // TODO: 18/02/2017 Implementare
        Toast.makeText(this, "Non ancora implementato", Toast.LENGTH_SHORT).show();
        Intent i= new Intent(getApplicationContext(), Registrazione.class);
        i.putExtra("tipologia", tipologia);
        startActivity(i);
        finish();
    }

    /**
     * Controlla se i campi sono vuoti
     * @return true se entrambi NON sono vuoti
     */
    private boolean checkEmpty(){
        etUsername.setError(null);
        etPassword.setError(null);
        if(etUsername.getText().length()==0){
            etUsername.setError("Questo campo è obbligatorio");
            return true;
        }
        if(etPassword.getText().length()==0){
            etPassword.setError("Questo campo è obbligatorio");
            return true;
        }
        return false;
    }

}
