package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

// Iniciar processo votação: nessa etapa é iniciado o processo de votação, em que foi solicitado, na
// demanda, um menu que ofereça as opções de votar, ver resultado parcial e finalizar a votação.
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> listaCandidatos = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> listaEleitores = new ArrayList<PessoaEleitora>();
  private ArrayList<String> votantes = new ArrayList<String>();
  private ArrayList<Integer> votos = new ArrayList<Integer>();

  public GerenciamentoVotacao() {}

  public ArrayList<PessoaCandidata> getListaCandidatos() {
    return listaCandidatos;
  }

  public ArrayList<PessoaEleitora> getListaEleitores() {
    return listaEleitores;
  }

  public void cadastrarPessoaCandidata(String nome, int numero) {
    PessoaCandidata candidato = new PessoaCandidata(nome, numero);

    for (PessoaCandidata pessoa : listaCandidatos) {
      if (pessoa.getNumero() == numero) {
        System.out.println("Número já cadastrado!");
        return;
      }
    }
    listaCandidatos.add(candidato);
  }

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    PessoaEleitora eleitor = new PessoaEleitora(nome, cpf);

    for (PessoaEleitora pessoa : listaEleitores) {
      if (pessoa.getCpf().equals(cpf)) {
        System.out.println("CPF já cadastrado!");
        return;
      }
    }
    listaEleitores.add(eleitor);
  }

  public void votar(String cpf, int numero) {
    for (PessoaEleitora pessoa : listaEleitores) {
      if (pessoa.getCpf().equals(cpf)) {
        if (votantes.contains(cpf)) {
          System.out.println("Você já votou!");
          return;
        }
        for (PessoaCandidata pessoaCandidata : listaCandidatos) {
          if (pessoaCandidata.getNumero() == numero) {
            votantes.add(cpf);
            votos.add(numero);
            pessoa.voto(cpf, numero);
            return;
          }
        }
      }
    }
    System.out.println("CPF ou número inválido!");
  }

  public void mostrarResultado() {
    System.out.println("Resultado da votação:");
    for (PessoaCandidata pessoa : listaCandidatos) {
      System.out.println("Candidato " + pessoa.getNumero() + ": " + pessoa.getNome());
    }
  }
}
