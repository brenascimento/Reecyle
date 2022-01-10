package com.reecycle.reecycleapp.form.SlidePages.Reepontos;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reecycle.reecycleapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PremiosFragment extends Fragment {
    private RecyclerView rv;
    private PremiosAdapter premiosAdapter;
    private Context context;

    public PremiosFragment() {
        // Required empty public constructor
    }

    public static PremiosFragment newInstance(){
        return new PremiosFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_premios, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.premios);
        context = this.getContext();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        String item1 = getResources().getString(R.string.item1);
        String item2 = getResources().getString(R.string.item2);
        String item3 = getResources().getString(R.string.item3);
        String item4 = getResources().getString(R.string.item4);
        List<PremiosModel> premiosList = new ArrayList<>();
        PremiosModel itemN1 = new PremiosModel(R.drawable.sonyusb, item1, R.string.reepoints1);
        PremiosModel itemN2 = new PremiosModel(R.drawable.aagoogleplay, item2, R.string.reepoints2);
        PremiosModel itemN3 = new PremiosModel(R.drawable.aamarvelavengers, item3, R.string.reepoints3);
        PremiosModel itemN4 = new PremiosModel(R.drawable.aadcbatman, item4, R.string.reepoints4);
        premiosList.add(itemN1);
        premiosList.add(itemN2);
        premiosList.add(itemN3);
        premiosList.add(itemN4);
        premiosAdapter = new PremiosAdapter(premiosList);
        rv.setAdapter(premiosAdapter);
        rv.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));


    }
}
