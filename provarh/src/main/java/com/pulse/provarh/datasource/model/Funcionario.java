package com.pulse.provarh.datasource.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "funcionario")
public class Funcionario  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "nomeCompleto", nullable = false, unique = true )
    private String nomeCompleto;

    @Column(name = "cpf", nullable = false, unique = true)
    @CPF
    private String cpf;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "dataCriacao", nullable = false)
    @CreationTimestamp
    private Date datacadastro;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ponto> ponto;

    @SuppressWarnings("unused")
    public Funcionario() {

    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setNomeCompleto(final String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(final String senha) {
        this.senha = senha;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setDataNascimento(final Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(final String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(final String telefone) {
        this.telefone = telefone;
    }

    public void setDataCadastro(final Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public void setPonto(final List<Ponto> ponto) {
        this.ponto = ponto;
    }

    public long getId() {
        return this.id;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getEmail() {
        return this.email;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public Date getDatacadastro() {
        return this.datacadastro;
    }

    public List<Ponto> getPonto() {
        return this.ponto;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Funcionario)) {
            return false;
        }
        final Funcionario funcionario = (Funcionario) o;
        return id == funcionario.id && Objects.equals(nomeCompleto, funcionario.nomeCompleto) && Objects.equals(cpf, funcionario.cpf) && Objects.equals(senha, funcionario.senha) && Objects.equals(email, funcionario.email) && dataNascimento == funcionario.dataNascimento && Objects.equals(endereco, funcionario.endereco) && telefone == funcionario.telefone && Objects.equals(datacadastro, funcionario.datacadastro) && Objects.equals(ponto, funcionario.ponto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCompleto, cpf, senha, email, dataNascimento, endereco, telefone, datacadastro, ponto);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nomeCompleto='" + getNomeCompleto() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", senha='" + getSenha() + "'" +
            ", email='" + getEmail() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", datacadastro='" + getDatacadastro() + "'" +
            ", ponto='" + getPonto() + "'" +
            "}";
    }





}