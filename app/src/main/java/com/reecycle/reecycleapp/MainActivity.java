package com.reecycle.reecycleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.reecycle.reecycleapp.form.ReeUsersCadastroFragment;
import com.reecycle.reecycleapp.form.ReeUsersFragment;

public class MainActivity extends AppCompatActivity {
    private static final String SHOW_CADASTRAR_KEY = "Show Cadastrar";

    private ReeUsersFragment formFragment;
    private ReeUsersCadastroFragment cadastroFragment;
    private boolean isShowingCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        restoreFragments(savedInstanceState);

        if (savedInstanceState != null) {
            if(savedInstanceState.getBoolean(SHOW_CADASTRAR_KEY)){
                showCadastro();
            } else {
                showLogin();
            }
        } else {
            showLogin();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        //formFragment.getView().setOnClickListener(new ReeUsersFragment().onClick());

    }

    private void restoreFragments(Bundle savedInstanceState){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if(savedInstanceState != null){
            formFragment = (ReeUsersFragment) manager.getFragment(savedInstanceState, formFragment.TAG);
            cadastroFragment = (ReeUsersCadastroFragment) manager.getFragment(savedInstanceState, cadastroFragment.TAG);
        }
        if(formFragment == null){
            formFragment = new ReeUsersFragment();
            transaction.add(R.id.mainTela, formFragment, formFragment.TAG);
        }
        if(cadastroFragment == null){
            cadastroFragment = new ReeUsersCadastroFragment();
            transaction.add(R.id.mainTela, cadastroFragment, cadastroFragment.TAG);
        }

        transaction.commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SHOW_CADASTRAR_KEY, isShowingCadastrar);

        FragmentManager manager = getSupportFragmentManager();
        manager.putFragment(outState, formFragment.TAG, formFragment);
    }

    private void showCadastro(){
        isShowingCadastrar = true;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(formFragment)
                .show(cadastroFragment)
                .commit();
    }

    public boolean isShowingCadastrar() {
        return isShowingCadastrar;
    }

    private void showLogin(){
        isShowingCadastrar = false;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(cadastroFragment)
                .show(formFragment)
                .commit();
    }

    private boolean handleCadastroTxtSelect(TextView txt){
        if(txt.getId() == R.id.tvCad){
            showCadastro();
            return true;
        } else {
            return false;
        }
    }
}