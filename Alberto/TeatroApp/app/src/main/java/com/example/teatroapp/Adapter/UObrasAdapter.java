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

public class UObrasAdapter extends RecyclerView.Adapter<UObrasAdapter.ViewHolder> {
    private ArrayList<Obra> lstObras;

    Context context;

    public UObrasAdapter(ArrayList<Obra> lstObras) {
        this.lstObras = lstObras;
    }

    @NonNull
    @Override
    public UObrasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_obra, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull UObrasAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //titleTxt = itemView.findViewById(R.id.titleTxt);
            //pic = itemView.findViewById(R.id.pic);
        }
    }
}
