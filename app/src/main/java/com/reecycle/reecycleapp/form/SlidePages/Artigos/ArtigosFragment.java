package com.reecycle.reecycleapp.form.SlidePages.Artigos;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.reecycle.reecycleapp.R;

import java.util.ArrayList;
import java.util.List;

public class ArtigosFragment extends Fragment {
    private FloatingActionButton fab;
    private RecyclerView rv;
    private ArtigosAdapter artigosAdapter;
    private Context context;

    public ArtigosFragment() {

    }

    public static ArtigosFragment newInstance(){
        return new ArtigosFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_artigos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab = view.findViewById(R.id.fab);
        rv = view.findViewById(R.id.rv);
        context = this.getContext();


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        String loremIpsun = getResources().getString(R.string.artigo1);
        String artigon2 = getResources().getString(R.string.artigo2);
        String artigon3 = getResources().getString(R.string.artigo3);
        int cor1 = getResources().getColor(R.color.colorPrimary);
        Drawable drb = getResources().getDrawable(R.drawable.shapeartigos);
        drb.setColorFilter(new PorterDuffColorFilter(cor1, PorterDuff.Mode.MULTIPLY));
        List<ArtigosModel> artigosModels = new ArrayList<>();
        ArtigosModel artigoTeste = new ArtigosModel("Dicas de principiante", loremIpsun, drb);
        ArtigosModel artigo2 = new ArtigosModel("Entendendo o que reciclar", artigon2, drb);
        ArtigosModel artigo3 = new ArtigosModel("Tip of the day: Porta Lápis de Garrafa Pet", artigon3, drb);
        artigosModels.add(artigoTeste);
        artigosModels.add(artigo2);
        artigosModels.add(artigo3);
        artigosAdapter = new ArtigosAdapter(artigosModels);
        artigosAdapter.setContext(this.getContext());
        rv.setAdapter(artigosAdapter);
        rv.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
    }
}
