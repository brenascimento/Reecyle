package com.reecycle.reecycleapp.form;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.reecycle.reecycleapp.R;
import com.reecycle.reecycleapp.form.SlidePages.InAppActivity;

import java.util.List;


public class ReeUsersFragment extends Fragment{
    public static final String TAG = ReeUsersFragment.class.getSimpleName();
    //FormHandleHelper mDbHelper = new FormHandleHelper(getContext());
    /*SQLiteDatabase mDb = mDbHelper.getWritableDatabase();
    ContentValues values = new ContentValues();*/
    private TextInputEditText email;
    private TextInputEditText senha;
    private MaterialButton btnEntrar;
    private TextView txtCadastro;
    ReeUsersDAO dao;


    public static ReeUsersFragment newInstance() {
        return new ReeUsersFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.form_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email = view.findViewById(R.id.txtEmail);
        senha = view.findViewById(R.id.txtSenha);
        txtCadastro = view.findViewById(R.id.tvCad);
        btnEntrar = view.findViewById(R.id.btnEntrar);

        /*TextInputEditText txtEmail = view.findViewById(R.id.txtEmail);
        TextInputEditText txtSenha = view.findViewById(R.id.txtSenha);
        MaterialButton btnEntrar = view.findViewById(R.id.btnEntrar);
        TextView tvTest = view.findViewById(R.id.teste);
        TextView tvCad = view.findViewById(R.id.tvCad);
        tvCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertCadastroFragment();
            }
        });*/
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dao = new ReeUsersDAO(this.getContext());

        txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getChildFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_open_exit);
                transaction.replace(R.id.loginFragment, ReeUsersCadastroFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailStr = email.toString();
                String senhaStr = senha.toString();
                ReeUsers reeConta = new ReeUsers();
                reeConta.setEmail(emailStr);
                reeConta.setSenha(senhaStr);
                checkErros();
                /*if(confirmarReeuser(reeConta) != null){
                    Toast.makeText(getContext(), "Entrou com sucesso!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Esses dados não existem", Toast.LENGTH_LONG).show();
                }*/
                Intent i = new Intent(getContext(), InAppActivity.class);
                startActivity(i);
            }
        });
    }


    private ReeUsers confirmarReeuser(ReeUsers users){
        return dao.pickReeUser(users);
    }

    private boolean isEmpty(TextInputEditText inputEditText){
        CharSequence str = inputEditText.toString();
        return TextUtils.isEmpty(str);
    }

    private boolean isEmail(TextInputEditText inputEditText){
        CharSequence email = inputEditText.toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public void onClick(View view){
        //mViewModel.setReeUserDefinido(reeUsers);
        //mViewModel.checkEmail(reeUsers.getEmail());

    }

    private void checkErros(){
        if(isEmpty(email)){
            email.setError("*Por favor, preencha o campo");
        } else {
            email.setError(null);
        }

        if(isEmpty(senha)){
            senha.setError("*Por favor, preencha o campo");
        } else {
            senha.setError(null);
        }

        if(isEmail(email)){
            email.setError("*Preencha um e-mail válido");
        } else {
            email.setError(null);
        }
    }

}