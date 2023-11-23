package com.example.teatroapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teatroapp.R;
import com.example.teatroapp.beans.Obra;

import java.util.ArrayList;

public class AdapterObras extends RecyclerView.Adapter<AdapterObras.ObrasViewHolder> {


    private ArrayList<Obra> lstObras;
    private LayoutInflater inflater;

    public AdapterObras(Context context, ArrayList<Obra> lstObras){
        this.lstObras = lstObras;
        this.inflater = LayoutInflater.from(context);
    }

    //MÉTODOS
    @NonNull
    @Override
    public AdapterObras.ObrasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.obras_row, parent, false);
        return new ObrasViewHolder(view);
    }




    @Override
    public void onBindViewHolder(AdapterObras.ObrasViewHolder holder, int posfila) {
        Obra obra = lstObras.get(posfila);

        holder.tituloObra.setText(lstObras.get(posfila).getTituloObra());

        //holder.imagen.setimagelstObras.get(posfila).getImagenObra();

        holder.desc.setText(lstObras.get(posfila).getDescripcionObra());


       /* Añadir URL para las imágenes
       String urlImage="http://192.0.0.0:8080/CinesAragon/images/"+

               lstFilms.get(posFila).getUrl()+".png";
       Picasso.get().load(urlImage).into(viewHolder.imagen);
      */
        //  viewHolder.imagen.setImageResource(lstFilms.get(posFila).getImagen());

    }


    public static class ObrasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        // Campos respectivos de un item
       // public ImageView imagen;
        public TextView tituloObra;
        public TextView desc;


        public ObrasViewHolder(View obra) {
            super(obra);
            //imagen = (ImageView) obra.findViewById(R.id.imagen);
            tituloObra = (TextView) obra.findViewById(R.id.tituloObra);
            desc = (TextView) obra.findViewById(R.id.desc);
            //this.onFilmListener=onFilmListener;

            obra.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


        }

    }


    /*public AdapterObras(ArrayList<Obra> lstObras) {

        this.lstObras= lstObras;
    }*/

    /*public ObrasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v;

        v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_obras,
                        viewGroup, false);

        return new ObrasViewHolder(v);
    }*/


    @Override
    public int getItemCount() {
        return lstObras.size();
    }


}
