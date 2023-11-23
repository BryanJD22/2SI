package com.example.teatroapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.teatroapp.R;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public class AdapterObras extends RecyclerView.Adapter<AdapterObras.ObrasViewHolder> {


    private ArrayList<Obra> lstObras;
    public static class ObrasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView desc;


        public ObrasViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            desc = (TextView) v.findViewById(R.id.desc);
            //this.onFilmListener=onFilmListener;

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


        }

    }


    public AdapterObras(ArrayList<Obra> lstObras) {

        this.lstObras= lstObras;
    }

    public ObrasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v;

        v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_obras,
                        viewGroup, false);

        return new ObrasViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ObrasViewHolder viewHolder, int posFila) {

       /* Añadir URL para las imágenes
       String urlImage="http://192.0.0.0:8080/CinesAragon/images/"+

               lstFilms.get(posFila).getUrl()+".png";
       Picasso.get().load(urlImage).into(viewHolder.imagen);
      */
        //  viewHolder.imagen.setImageResource(lstFilms.get(posFila).getImagen());
        if (lstObras.get(posFila).getTituloObra() != null) {
            viewHolder.nombre.setText(lstObras.get(posFila).getTituloObra());
        } else {
            viewHolder.nombre.setText("Título no disponible");
        }
    }

    @Override
    public int getItemCount() {
        return lstObras.size();
    }


}
