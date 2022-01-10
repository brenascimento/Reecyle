package com.reecycle.reecycleapp.form.SlidePages.Artigos;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.reecycle.reecycleapp.R;

import java.util.List;

public class ArtigosAdapter extends RecyclerView.Adapter<ArtigosAdapter.ArtigosViewHolder>{
    private List<ArtigosModel> artigos;
    private Context context;

    public ArtigosAdapter(List<ArtigosModel> artigos){
        this.artigos = artigos;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    static class ArtigosViewHolder extends RecyclerView.ViewHolder{
        MaterialToolbar toolbar;
        TextView titulo;
        TextView conteudo;


        ArtigosViewHolder(@NonNull View itemView) {
            super(itemView);
            toolbar = itemView.findViewById(R.id.toolbarArt);
            titulo = itemView.findViewById(R.id.titulo);
            conteudo = itemView.findViewById(R.id.conteudo);
        }
    }
    private ArtigosViewHolder aViewHolder;

    @NonNull
    @Override
    public ArtigosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artigos_list, parent, false);
        aViewHolder = new ArtigosViewHolder(view);
        return aViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtigosViewHolder holder, int position) {
        holder.toolbar.setBackground(artigos.get(position).getColor());
        holder.titulo.setText(artigos.get(position).getTitulo());
        holder.conteudo.setText(artigos.get(position).getConteudo());
    }

    @Override
    public int getItemCount() {
        return artigos.size();
    }

    public List<ArtigosModel> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<ArtigosModel> artigos) {
        this.artigos = artigos;
    }


}
