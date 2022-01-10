package com.reecycle.reecycleapp.form.SlidePages.Reepontos;

import android.widget.ImageView;

public class PremiosModel {
    private int item;
    private String titulo;
    private int pontos;

    public PremiosModel(int item, String titulo, int pontos) {
        this.item = item;
        this.titulo = titulo;
        this.pontos = pontos;
    }


    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
