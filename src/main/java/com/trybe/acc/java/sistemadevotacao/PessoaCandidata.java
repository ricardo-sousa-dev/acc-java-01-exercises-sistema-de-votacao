package com.trybe.acc.java.sistemadevotacao;

// Cadastrar pessoas candidatas: nessa etapa, é preciso ter um menu para o cadastro de pessoas
// candidatas e, ao fim do cadastro de cada nova pessoa, deve-se oferecer a opção de cadastrar
// outra. Quando não houver mais pessoas candidatas para serem cadastradas, então se passa para a
// etapa de cadastro de pessoas eleitoras;
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
