package com.trybe.acc.java.sistemadevotacao;

// Cadastrar pessoas eleitoras: aqui é preciso ter um menu que possibilite o cadastro de pessoas
// eleitoras, similar ao menu do cadastro de pessoas candidatas. Finalizado o cadastro, deve-se
// voltar ao estado inicial do menu de cadastro de pessoas eleitoras para oferecer a oportunidade de
// cadastrar uma nova pessoa. Quando não houver mais pessoas eleitoras para serem cadastradas, o
// sistema deve seguir para a etapa de votação;

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
