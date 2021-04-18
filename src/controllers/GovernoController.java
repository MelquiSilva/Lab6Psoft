package controllers;

import models.Pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GovernoController {

    private HashSet<String> comorbidadesValidas;
    private HashSet<String> profissoesValidas;
    private int idadeValida;

    private HashMap<String, Pessoa> pessoas;

    public GovernoController() {
        comorbidadesValidas = new HashSet<>();
        comorbidadesValidas.add("cardiaco");
        profissoesValidas = new HashSet<>();
        profissoesValidas.add("medico");
        profissoesValidas.add("enfermeiro");
        idadeValida = 70;
        pessoas = new HashMap<>();
    }

    public void cadastrarPessoas(String nome, String cpf, String endereco, String numeroCartaoSUS,
                                 String email, String telefone, String profissao, ArrayList<String> comorbidades, int idade){

        Pessoa pessoaCadastrada = new Pessoa(nome, cpf, endereco, numeroCartaoSUS, email,
                                            telefone, profissao, comorbidades, idade);
        pessoas.put(cpf, pessoaCadastrada);
        checar(pessoas.get(cpf));

    }

    public void alterarPessoa(String cpf, String atributo, String novoValor) {
        if(pessoas.get(cpf) !=null) {
            switch (atributo) {
                case "1":
                    pessoas.get(cpf).setEndereco(novoValor);
                    break;
                case "2":
                    pessoas.get(cpf).setNumeroCartaoSUS(novoValor);
                    break;
                case "3":
                    pessoas.get(cpf).setEmail(novoValor);
                    break;
                case "4":
                    pessoas.get(cpf).setTelefone(novoValor);
                    break;
                case "5":
                    pessoas.get(cpf).setProfissao(novoValor);
                    break;
                case "6":
                    pessoas.get(cpf).setIdade(Integer.parseInt(novoValor));
            }
            checar(pessoas.get(cpf));
        }
    }
    public void alterarComorbidadesPessoa(String cpf, ArrayList<String> novaComorbidade){
        pessoas.get(cpf).setComorbidades(novaComorbidade);
        checar(pessoas.get(cpf));
    }

    public void alterarComorbidadesValidas(HashSet<String> novasComorbidadesValidas){
        this.comorbidadesValidas = novasComorbidadesValidas;
        checarAtualiazacoesValidas();
    }

    public void alterarProfissoesValidas(HashSet<String> novasProfissoesValidas){
        this.profissoesValidas = novasProfissoesValidas;
        checarAtualiazacoesValidas();
    }
    
   public int getIdadeValida() {
        return idadeValida;
    }

    public void setIdadeValida(int idadeValida) {
        this.idadeValida = idadeValida;
        checarAtualiazacoesValidas();
    }

    public Set<String> getComorbidadesValidas() {
        return comorbidadesValidas;
    }

    public Set<String> getProfissoesValidas() {
        return profissoesValidas;
    }

    public HashMap<String, Pessoa> getPessoas() {
        return pessoas;
    }

    public String retornarStatusPessoa(String cpf){
        if(pessoas.get(cpf) !=null) {
            return pessoas.get(cpf).getEstado().getStatus();
        }
        else{
            return "pessoa não cadastrada";
        }
    }

    public String atualizarStatus(String cpf){
        if(pessoas.get(cpf) !=null) {
            return pessoas.get(cpf).getEstado().avancarStatus(pessoas.get(cpf));
        }
        else{
            return "pessoa não cadastrada";
        }
    }


    private void checar(Pessoa pessoa) {
        pessoa.getEstado().checar(this, pessoa);
    }

    private void checarAtualiazacoesValidas(){
        for(Pessoa pessoa: pessoas.values()){
            checar(pessoa);
        }
    }



}
