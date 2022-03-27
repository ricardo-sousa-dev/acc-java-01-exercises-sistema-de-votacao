package com.trybe.acc.java.sistemadevotacao;

// Cadastrar pessoas candidatas: nessa etapa, é preciso ter um menu para o cadastro de pessoas
// candidatas e, ao fim do cadastro de cada nova pessoa, deve-se oferecer a opção de cadastrar
// outra. Quando não houver mais pessoas candidatas para serem cadastradas, então se passa para a
// etapa de cadastro de pessoas eleitoras;
public class PessoaCandidata {
  private String nome;
  private short numero;

  public PessoaCandidata(String nome, short numero) {
    this.nome = nome;
    this.numero = numero;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public short getNumero() {
    return numero;
  }

  public void setNumero(short numero) {
    this.numero = numero;
  }
}
