package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /** Iniciando o processo de votação. */
  public static void main(String[] args) {
    GerenciamentoVotacao votacao = new GerenciamentoVotacao();

    Scanner scanner = new Scanner(System.in);
    short cadastrarCandidato = 1;
    short cadastrarEleitor = 1;
    short votar = 1;

    // votacao.setup();

    try {
      while (cadastrarCandidato == 1) {
        System.out.println("\n");
        System.out.println("----------- Bem-vindo ao Sistema de Votação -----------\n");
        System.out.println("Cadastrar pessoa candidata?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.println("Entre com o número correspondente à opção desejada:\n");

        cadastrarCandidato = scanner.nextShort();
        System.out.println("\n");

        if (cadastrarCandidato == 1) {
          System.out.println("Entre com o nome da pessoa candidata:");
          String nome = scanner.next();
          System.out.println("Entre com o número da pessoa candidata:");
          short numero = scanner.nextShort();

          votacao.cadastrarPessoaCandidata(nome, numero);

        } else if (cadastrarCandidato != 1 && cadastrarCandidato != 2) {
          System.out.println("Opção inválida!");
          cadastrarCandidato = scanner.nextShort();
        }
      }

      while (cadastrarEleitor == 1) {
        System.out.println("\n\n");
        System.out.println("----------- Cadastre as pessoas eleitoras -----------\n");
        System.out.println("Cadastrar pessoa eleitora?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.println("Entre com o número correspondente à opção desejada:\n");

        cadastrarEleitor = scanner.nextShort();
        System.out.println("\n");

        if (cadastrarEleitor == 1) {
          System.out.println("Entre com o nome da pessoa eleitora:");
          String nome = scanner.next();
          System.out.println("Entre com o CPF da pessoa eleitora:");
          String cpf = scanner.next();

          votacao.cadastrarPessoaEleitora(nome, cpf);

        } else if (cadastrarEleitor != 1 && cadastrarEleitor != 2) {
          System.out.println("Opção inválida!");
          cadastrarEleitor = scanner.nextShort();
        }
      }

      while (votar == 1 || votar == 2) {
        System.out.println("\n\n");
        System.out.println("----------- Votação iniciada! -----------\n");
        System.out.println("Entre com o número correspondente à opção desejada:");
        System.out.println("1 - Votar");
        System.out.println("2 - Resultado Parcial");
        System.out.println("3 - Finalizar Votação");

        votar = scanner.nextShort();
        System.out.println("\n");

        if (votar == 1) {
          System.out.println("Entre com o CPF da pessoa eleitora:");
          String cpf = scanner.next();
          System.out.println("Entre com o número da pessoa candidata:");
          short numero = scanner.nextShort();

          votacao.votar(cpf, numero);

        } else if (votar == 2) {
          votacao.mostrarResultado();

        } else if (votar != 1 && votar != 2 && votar != 3) {
          System.out.println("Opção inválida!");
          // votar = scanner.nextShort();
        } else {
          votacao.mostrarResultado();
        }
      }
      scanner.close();
    } catch (Exception err) {
      System.out.println("Erro: " + err.getMessage());
    }
  }
}

// https://www.alura.com.br/conteudo/java-collections?gclid=CjwKCAjwloCSBhAeEiwA3hVo_YMJmU4NkaWKD6pRsZV7j9bmSUjrk5V8ucE54j2oRSNoGFlD0aEeahoCc2wQAvD_BwE
