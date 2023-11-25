package com.example.teatroapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teatroapp.ObrasActivity;
import com.example.teatroapp.R;
import com.example.teatroapp.beans.Obra;
import com.example.teatroapp.beans.Sala;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterSalas extends RecyclerView.Adapter<AdapterSalas.SalasViewHolder> {
    private ArrayList<Sala> lstsalas;
    private Context context;

    public AdapterSalas(ArrayList<Sala> lstsalas, Context context) {
        this.lstsalas = lstsalas;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterSalas.SalasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_salas,parent,false);
        return new SalasViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterSalas.SalasViewHolder holder, int position) {
        Sala sala = lstsalas.get(position);
        Picasso.get()
                .load(sala.getImgSala()) // Reemplaza con el método que obtiene la URL de la imagen
                .placeholder(R.drawable.pruebaimagentoji) // Reemplaza con tu recurso de imagen de carga
                .into(holder.imageSala);
        holder.nombreSala.setText(lstsalas.get(position).getIdSala());

        holder.cardView.setOnClickListener(e->{
            Intent intent = new Intent(context, ObrasActivity.class);
            intent.putExtra("id",position);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return lstsalas.size();
    }

    public class SalasViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageSala;
        TextView nombreSala;
        public SalasViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageSala = itemView.findViewById(R.id.imageView);
            nombreSala = itemView.findViewById(R.id.textView);



        }
    }
}
