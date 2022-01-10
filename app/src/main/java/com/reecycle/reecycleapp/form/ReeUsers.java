package com.reecycle.reecycleapp.form;


public class ReeUsers{
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String confSenha;
    private String municipio;
    private String telefone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    String getNome() {
        return nome;
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    String getSobrenome() {
        return sobrenome;
    }

    void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getSenha() {
        return senha;
    }

    void setSenha(String senha) {
        this.senha = senha;
    }

    String getConfSenha() {
        return confSenha;
    }

    void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }

    String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    String getTelefone() {
        return telefone;
    }

    void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}


