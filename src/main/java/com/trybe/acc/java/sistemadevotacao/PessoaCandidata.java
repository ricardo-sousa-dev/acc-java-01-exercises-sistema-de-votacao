package com.trybe.acc.java.sistemadevotacao;

/** Classe que cria um candidato */
public class PessoaCandidata {
  private String nome;
  private int numero;
  private short votos;

  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public short getVotos() {
    return votos;
  }

  public void setVotos() {
    this.votos += votos;
  }
}
