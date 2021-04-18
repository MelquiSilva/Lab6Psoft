package main;

import controllers.GovernoController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome, cpf, endereco, numeroCartaoSus, email, telefone, profissao;
        ArrayList<String> comorbidades;
        int idade;

        GovernoController governo = new GovernoController();
        HashSet<String> comorbidadesValidas, profissoesValidas;

        String validacao, atributo, novoValor, opcaoStatus;
        System.out.println(menu());

        String operacao = sc.nextLine();

        while (!operacao.equals("X")) {
            switch (operacao) {
                case "C":
                    System.out.println("Digite seu nome:");
                    nome = sc.nextLine();
                    System.out.println("Digite seu cpf");
                    cpf = sc.nextLine();
                    System.out.println("Digite seu endereço");
                    endereco = sc.nextLine();
                    System.out.println("Digite seu numero de cartão do sus");
                    numeroCartaoSus = sc.nextLine();
                    System.out.println("Digite seu email");
                    email = sc.nextLine();
                    System.out.println("Digite seu telefone:");
                    telefone = sc.nextLine();
                    System.out.println("Digite sua profissão");
                    profissao = sc.nextLine();
                    System.out.println("Digite uma lista de suas comorbidades. Separe-as por virgula");
                    comorbidades = new ArrayList<>(Arrays.asList(sc.nextLine().split(", ")));
                    System.out.println("Digite sua idade:");
                    idade = Integer.parseInt(sc.nextLine());
                    governo.cadastrarPessoas(nome, cpf, endereco, numeroCartaoSus, email, telefone, profissao, comorbidades, idade);
                    break;
                case "A":
                    System.out.println("Digite seu cpf");
                    cpf = sc.nextLine();

                    System.out.println(menuAlteracoes());
                    atributo = sc.nextLine();
                    if (atributo.equals("7")) {
                        System.out.println("Digite uma lista de suas comorbidades. Separe-as por virgula");
                        comorbidades = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
                        governo.alterarComorbidadesPessoa(cpf, comorbidades);
                    } else if(Integer.parseInt(atributo) < 1 || Integer.parseInt(atributo) > 7){
                        System.out.println("Opção Inválida");
                    }
                    else {
                        System.out.println("Atualize o valor para a alteração");
                        novoValor = sc.nextLine();
                        governo.alterarPessoa(cpf, atributo, novoValor);
                    }
                    break;
                case "V":
                    System.out.println(menuValidacoes());
                    validacao = sc.nextLine();
                    if (validacao.equals("C")) {
                        System.out.println("Digite as comorbidades válidas, separadas por vírgulas");
                        comorbidadesValidas = new HashSet<>(Arrays.asList(sc.nextLine().split(", ")));
                        governo.alterarComorbidadesValidas(comorbidadesValidas);
                    } else if (validacao.equals("P")) {
                        System.out.println("Digite as profissões válidas, separadas por vírgulas");
                        profissoesValidas = new HashSet<>(Arrays.asList(sc.nextLine().split(", ")));
                        governo.alterarProfissoesValidas(profissoesValidas);
                    } else if (validacao.equals("I")){
                        System.out.println("Digite a idade mínima válida:");
                        idade = Integer.parseInt(sc.nextLine());
                        governo.setIdadeValida(idade);
                    } else{
                        System.out.println("Opção Inválida");
                    }

                    break;
                case "S":
                    System.out.println("Digite seu cpf");
                    cpf = sc.nextLine();
                    System.out.println(menuStatus());
                    opcaoStatus = sc.nextLine();

                    if (opcaoStatus.equals("A")) {
                        System.out.println(governo.atualizarStatus(cpf));

                    } else {
                        System.out.println(governo.retornarStatusPessoa(cpf));
                    }
                    break;
                case "R":
                    System.out.println(governo.getComorbidadesValidas());
                    System.out.println(governo.getProfissoesValidas());
                    System.out.println(governo.getIdadeValida());
                    break;

                default:
                    System.out.println("Opção Inválida");

            }
            System.out.println(menu());
            operacao = sc.nextLine();

        }

    }

    private static String menu() {
        return "(C)Cadastrar pessoa" + "\n" +
                "(A)Alterar pessoa" + "\n" +
                "(V)Alterar Validações Para Vacina" + "\n" +
                "(R)Retornar Validações Para Vacina" + "\n" +
                "(S)Status de vacinação da Pessoa" + "\n" +
                "(X)Sair";
    }

    private static String menuValidacoes() {
        return "(C)Alterar Comorbidades Validas" + "\n" +
                "(P)Alterar Profissoes Validas" + "\n" +
                "(I)Alterar Idade Valida";
    }

    private static String menuStatus() {
        return "(C)Consultar status" + "\n" +
                "(A)Avançar status pessoa";
    }

    private static String menuAlteracoes() {
        return "(1)Endereco" + "\n" +
                "(2)NumeroCartaoSus" + "\n" +
                "(3)Email" + "\n" +
                "(4)Telefone" + "\n" +
                "(5)Profissao" + "\n" +
                "(6)idade" + "\n" +
                "(7)Comorbidades" + "\n";

    }
}
