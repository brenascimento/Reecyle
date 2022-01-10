package com.reecycle.reecycleapp.form;

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

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.reecycle.reecycleapp.R;


public class ReeUsersCadastroFragment extends Fragment {

    public static final String TAG = ReeUsersCadastroFragment.class.getSimpleName();
    //public static final String TAG = "cadastroFragment";
    private TextInputEditText nome;
    private TextInputEditText sobrenome;
    private TextInputEditText telefone;
    private TextInputEditText email;
    private TextInputEditText senha;
    private TextInputEditText confSenha;
    private MaterialButton btnCadastrar;
    private TextView tvTest1;
    private TextView tvTest2;
    private ReeUsersDAO dao;
    private boolean auth;

    static ReeUsersCadastroFragment newInstance() {
        return new ReeUsersCadastroFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cadastro_fragment, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nome = view.findViewById(R.id.txtNome);
        sobrenome = view.findViewById(R.id.txtSobrenome);
        telefone = view.findViewById(R.id.txtTelefone);
        email = view.findViewById(R.id.txtEmail);
        senha = view.findViewById(R.id.txtSenha);
        confSenha = view.findViewById(R.id.txtConfirmarSenha);
        btnCadastrar = view.findViewById(R.id.btnCadastrar);
        tvTest1 = view.findViewById(R.id.test1);
        tvTest2 = view.findViewById(R.id.test2);
        dao = new ReeUsersDAO(this.getContext());
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDados();
                if(nome.getError() != null && sobrenome.getError() != null && email.getError() != null && telefone.getError() != null && auth){
                    getChildFragmentManager().popBackStack();
                    Toast.makeText(getContext(), "Cadastrado com sucesso", Toast.LENGTH_LONG).show();
                    cadastrar();
                } else {
                    Toast.makeText(getContext(), "Não foi possível fazer o cadastro", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void cadastrar(){
        ReeUsers reeUsers = new ReeUsers();
        reeUsers.setNome(nome.toString());
        reeUsers.setSobrenome(sobrenome.toString());
        reeUsers.setTelefone(telefone.toString());
        reeUsers.setEmail(email.toString());
        reeUsers.setSenha(senha.toString());
        reeUsers.setConfSenha(confSenha.toString());
        dao.insertReeUser(reeUsers);
    }

    private boolean isEmpty(TextInputEditText inputEditText){
        CharSequence str = inputEditText.toString();
        return TextUtils.isEmpty(str);
    }

    private boolean isEmail(TextInputEditText inputEditText){
        CharSequence email = inputEditText.toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    private void checkDados(){
        if(isEmpty(nome)){
            nome.setError("*Campo obrigatório");
        }else{
            nome.setError(null);
        }

        if(isEmpty(sobrenome)) {
            sobrenome.setError("*Campo obrigatório");
        } else {
            sobrenome.setError(null);
        }

        if(isEmpty(email)) {
            email.setError("*Campo obrigatório");
        } else{
            if(isEmail(email)) {
                email.setError("Insira um e-mail válido");
            }else {
                email.setError(null);
            }
        }

        if(isEmpty(senha)) {
            senha.setError("*Campo obrigatório");
        }else {
            senha.setError(null);
        }

        if(isEmpty(confSenha)) {
            confSenha.setError("*Campo obrigatório");
        }else{
            confSenha.setError(null);
        }

    }




}
