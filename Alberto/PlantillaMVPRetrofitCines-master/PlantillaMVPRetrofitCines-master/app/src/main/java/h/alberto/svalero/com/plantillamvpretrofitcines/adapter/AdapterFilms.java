package h.alberto.svalero.com.plantillamvpretrofitcines.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import h.alberto.svalero.com.plantillamvpretrofitcines.R;
import h.alberto.svalero.com.plantillamvpretrofitcines.beans.Film;


public class AdapterFilms
        extends
        RecyclerView.Adapter<AdapterFilms.FilmViewHolder> {

    private ArrayList<Film> lstFilms;
    //private FilmViewHolder.OnFilmListener onFilmListener;


    public static class FilmViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;


        public FilmViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            visitas = (TextView) v.findViewById(R.id.visitas);
            //this.onFilmListener=onFilmListener;

            //v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


        }

    }

    public AdapterFilms(ArrayList<Film> lstFilms) {
        this.lstFilms= lstFilms;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v;

          v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.film_row,
                        viewGroup, false);

        return new FilmViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder viewHolder, int posFila) {

       /* Añadir URL para las imágenes
       String urlImage="http://192.0.0.0:8080/CinesAragon/images/"+

               lstFilms.get(posFila).getUrl()+".png";
       Picasso.get().load(urlImage).into(viewHolder.imagen);
      */
       //  viewHolder.imagen.setImageResource(lstFilms.get(posFila).getImagen());
        viewHolder.nombre.setText(lstFilms.get(posFila).getTitulo());
        viewHolder.visitas.setText("Visitas:"+
               String.valueOf(lstFilms.get(posFila).getnVotos()));
    }

    @Override
    public int getItemCount() {
        return lstFilms.size();
    }
}

