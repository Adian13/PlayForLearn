package com.example.adi.playforlearn10.Alunno;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adi.playforlearn10.LoginActivity;
import com.example.adi.playforlearn10.R;

public class AccountAlunno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);
        TextView txNome = (TextView)findViewById(R.id.textNome);
        TextView txcognome = (TextView)findViewById(R.id.textCognome);
        TextView txUsername = (TextView)findViewById(R.id.textUsername);
        TextView txClasse = (TextView)findViewById(R.id.textClasse);
        // TODO da completare
        Button btLogout= (Button)findViewById(R.id.btLogout);
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
        //TODO Grafica
        //sharedpreference da inserire

    }
}
