package com.example.adi.playforlearn10;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.adi.playforlearn10.Insegnate.AccountMaestra;

import java.util.HashMap;

/**
 * Created by raffaeledellaporta on 28/01/2017.
 */

public class RegUtente extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText us,pw,name,surname;
    private static final String REGISTER_URL ="http://172.19.51.169:80/webservice/addUtenteAlunno.php";
    private Button registrati;
    private RadioGroup radio;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrati);

        us=(TextInputEditText)findViewById(R.id.username);
        pw=(TextInputEditText)findViewById(R.id.password);
        name=(TextInputEditText)findViewById(R.id.nome);
        surname=(TextInputEditText)findViewById(R.id.cognome);
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                boolean keepOriginal = true;
                StringBuilder sb = new StringBuilder(end - start);
                for (int i = start; i < end; i++) {
                    char c = source.charAt(i);
                    boolean d=isCharAllowed(c);
                    if (d)
                        sb.append(c);
                    else
                        keepOriginal = false;
                }
                if (keepOriginal)
                    return null;
                else {
                    if (source instanceof Spanned) {
                        SpannableString sp = new SpannableString(sb);
                        TextUtils.copySpansFrom((Spanned) source, start, sb.length(), null, sp, 0);
                        return sp;
                    } else {
                        return sb;
                    }
                }
            }

            private boolean isCharAllowed(char c) {
                return Character.isLetter(c) || Character.isSpaceChar(c);
            }
        };
        name.setFilters(new InputFilter[]{filter});
        surname.setFilters(new InputFilter[]{filter});


        radio=(RadioGroup)findViewById(R.id.radio);
        registrati=(Button)findViewById(R.id.btOK);
        getSupportActionBar().setTitle("Registrazione Utente");

        registrati.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == registrati){
            if(us.getText().toString().equals("")|| name.getText().toString().equals("")|| surname.getText().toString().equals("")|| pw.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(),"Inserire tutti i campi!",Toast.LENGTH_SHORT).show();
            } else {
                registraUtente();
            }
        }
    }



    private void registraUtente() {
        String username = us.getText().toString().trim().toLowerCase();
        String nome = name.getText().toString().trim().toLowerCase();
        String cognome = surname.getText().toString().trim().toLowerCase();
        String password = pw.getText().toString().trim().toLowerCase();
        registra(username,nome,cognome,password);
    }

    private void registra(final String username, final String nome, final String cognome, final String password) {
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RegistrazioneUtenteClasse ruc = new RegistrazioneUtenteClasse();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegUtente.this, "Aspetta",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                 loading.dismiss();
                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegUtente.this, AccountMaestra.class);
                    startActivity(intent);
                    finish();
                }



            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("us",params[0]);
                data.put("name",params[1]);
                data.put("surname",params[2]);
                data.put("password",params[3]);
                String result = ruc.sendPostRequest(REGISTER_URL,data);

                return  result;
            }

        }

        RegisterUser ru = new RegisterUser();
        ru.execute(username,nome,cognome,password);
    }

    public void annulla(View v){
        us.setText("");
        pw.setText("");
        name.setText("");
        surname.setText("");
    }
}
