package com.trybe.acc.java.sistemadevotacao;

/** Classe que cria um eleitor. */
public class PessoaEleitora {
  private String nome;
  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
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

  public void voto(String cpf, int numero) {}
}
