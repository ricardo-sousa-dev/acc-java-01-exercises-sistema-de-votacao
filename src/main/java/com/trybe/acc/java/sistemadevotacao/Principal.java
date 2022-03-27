package com.trybe.acc.java.sistemadevotacao;

import java.util.*;

public class Principal {

  /** Iniciando o processo de votação */
  public static void main(String[] args) {
    GerenciamentoVotacao votacao = new GerenciamentoVotacao();

    Scanner scanner = new Scanner(System.in);
    short cadastrarCandidato = 1;

    try {
      while (cadastrarCandidato == 1) {
        System.out.println("\n");
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

          votacao.setListaCandidatos(nome, numero);

        } else if (cadastrarCandidato == 2) {
          scanner.close();

        } else if (cadastrarCandidato != 1 && cadastrarCandidato != 2) {
          System.out.println("Opção inválida!");
          cadastrarCandidato = scanner.nextShort();
          scanner.close();
        }
      }
    } catch (Exception err) {
      System.out.println("Erro: " + err.getMessage());
    }
  }
}

// https://www.alura.com.br/conteudo/java-collections?gclid=CjwKCAjwloCSBhAeEiwA3hVo_YMJmU4NkaWKD6pRsZV7j9bmSUjrk5V8ucE54j2oRSNoGFlD0aEeahoCc2wQAvD_BwE
