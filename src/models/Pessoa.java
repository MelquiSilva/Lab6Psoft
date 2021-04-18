package models;

import estados.Estado;
import estados.NaoHabilitado;

import java.util.ArrayList;

public class Pessoa {

    private String nome;
    private String cpf;
    private String endereco;
    private String numeroCartaoSUS;
    private String email;
    private String telefone;
    private String profissao;
    private ArrayList<String> comorbidades;
    private int idade;
    private Estado estado;


    public Pessoa(String nome, String cpf, String endereco, String numeroCartaoSUS,
                  String email, String telefone, String profissao, ArrayList<String> comorbidades, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numeroCartaoSUS = numeroCartaoSUS;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        this.comorbidades = comorbidades;
        this.estado = new NaoHabilitado();
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroCartaoSUS() {
        return numeroCartaoSUS;
    }

    public void setNumeroCartaoSUS(String numeroCartaoSUS) {
        this.numeroCartaoSUS = numeroCartaoSUS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public ArrayList<String> getComorbidades() {
        return comorbidades;
    }

    public void setComorbidades(ArrayList<String> comorbidades) {
        this.comorbidades = comorbidades;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
