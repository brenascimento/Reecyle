package com.reecycle.reecycleapp.form.SlidePages.Reepontos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reecycle.reecycleapp.R;

import java.util.List;

public class PremiosAdapter extends RecyclerView.Adapter<PremiosAdapter.PremiosViewHolder> {
    private List<PremiosModel> premiosModels;

    public PremiosAdapter(List<PremiosModel> premiosModels) {
        this.premiosModels = premiosModels;
    }

    static class PremiosViewHolder extends  RecyclerView.ViewHolder{
        ImageView image;
        TextView titulo;
        TextView reepoints;

        public PremiosViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgPremio);
            titulo = itemView.findViewById(R.id.titulo);
            reepoints = itemView.findViewById(R.id.reepoints);
        }
    }

    private PremiosViewHolder aViewHolder;

    @NonNull
    @Override
    public PremiosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.premios_list, parent, false);
        aViewHolder = new PremiosViewHolder(view);
        return aViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PremiosViewHolder holder, int position) {
        holder.image.setImageResource(premiosModels.get(position).getItem());
        holder.titulo.setText(premiosModels.get(position).getTitulo());
        holder.reepoints.setText(premiosModels.get(position).getPontos());
    }

    @Override
    public int getItemCount() {
        return premiosModels.size();
    }
}
