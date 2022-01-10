package com.reecycle.reecycleapp.form.SlidePages.Artigos;


import android.graphics.drawable.Drawable;

public class ArtigosModel {
    private String titulo;
    private String conteudo;
    private Drawable color;

    ArtigosModel(String titulo, String conteudo, Drawable color) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.color = color;
    }

    String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


    public Drawable getColor() {
        return color;
    }

    public void setColor(Drawable color) {
        this.color = color;
    }
}
