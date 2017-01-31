package com.example.adi.playforlearn10;

/**
 * Created by raffaeledellaporta on 08/01/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);

        TextView t=(TextView)findViewById(R.id.textResult);

        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");

        bar.setRating(score);

        t.setText("Il tuo score è " + " " + score + ". Grazie per aver giocato.");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

    public void rigioca(View v){
        Intent i= new Intent(getApplicationContext(),QuizActivity.class);
        startActivity(i);
        finish();
    }
}
