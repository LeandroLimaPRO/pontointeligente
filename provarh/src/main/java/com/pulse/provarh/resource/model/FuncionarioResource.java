package com.pulse.provarh.resource.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FuncionarioResource {
    @JsonProperty
    private long funcionario;
    @JsonProperty
    private String nomecompleto;
    @JsonProperty
    private String cpf;
    @JsonProperty
    private String email;
    @JsonProperty
    private String senha;


    @JsonProperty
    private Date dataNascimento;
    @JsonProperty
    private String endereco;
    @JsonProperty
    private String telefone;
    @JsonProperty
    private String datacadastro;

    @SuppressWarnings("unused")
    public FuncionarioResource() {

    }
    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public long getIdfuncionario() {
        return this.funcionario;
    }

    public void setIdfuncionario(final long idfuncionario) {
        this.funcionario = idfuncionario;
    }

    public String getNomecompleto() {
        return this.nomecompleto;
    }

    public void setNomecompleto(final String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Date getdataNascimento() {
        return this.dataNascimento;
    }

    public void setdataNascimento(final Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(final String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(final String telefone) {
        this.telefone = telefone;
    }

    public String getDatacadastro() {
        return this.datacadastro;
    }

    public void setDatacadastro(final String datacadastro) {
        this.datacadastro = datacadastro;
    }
    
}