/*
package com.example.adi.playforlearn10;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

*/
/**
 * Created by raffaeledellaporta on 08/01/2017.
 *//*

public class AdapterListaGiochi extends ArrayAdapter<Gioco> {
    private Context mContext;
    private LayoutInflater inflater;
    private TextView nome;
    private ImageButton immagine;

    public AdapterListaGiochi(Context context, int resource, List objects) {
        super(context, resource, objects);
        mContext = context;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //TODO cambiare layout
        Gioco gioco=getItem(position);
        View v = View.inflate(mContext, R.layout.layout_gioco_gridview*/
/*(fragment_games)*//*
, null);

        immagine=(ImageButton) v.findViewById(R.id.ivIconaGioco);
        nome.setText(gioco.getNome());
        immagine.setImageDrawable(gioco.getIcona());

        immagine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), GiocoActivity.class);
            }
        });
        // TODO impostare icone e testo per la lista di giochi
        return v;
    }

}
*/
