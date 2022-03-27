package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

// Iniciar processo votação: nessa etapa é iniciado o processo de votação, em que foi solicitado, na
// demanda, um menu que ofereça as opções de votar, ver resultado parcial e finalizar a votação.
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> listaCandidatos = new ArrayList<PessoaCandidata>();

  public GerenciamentoVotacao() {}

  public ArrayList<PessoaCandidata> getListaCandidatos() {
    return listaCandidatos;
  }

  public void setListaCandidatos(String nome, short numero) {
    PessoaCandidata candidato = new PessoaCandidata(nome, numero);

    for (PessoaCandidata pessoa : listaCandidatos) {
      if (pessoa.getNumero() == numero) {
        System.out.println("Número já cadastrado!");
        return;
      }
    }
    listaCandidatos.add(candidato);
  }
}
