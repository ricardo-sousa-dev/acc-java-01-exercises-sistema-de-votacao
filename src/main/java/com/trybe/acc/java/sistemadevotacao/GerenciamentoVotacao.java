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

  public ArrayList<Integer> getListaCandidatos() {
    ArrayList<Integer> candidatos = new ArrayList<Integer>();

    for (PessoaCandidata pessoaCandidata : listaCandidatos) {
      candidatos.add(pessoaCandidata.getNumero());
    }
    return candidatos;
  }

  public ArrayList<String> getListaEleitores() {
    ArrayList<String> eleitores = new ArrayList<String>();

    for (PessoaEleitora pessoaEleitora : listaEleitores) {
      eleitores.add(pessoaEleitora.getCpf());
    }
    return eleitores;
  }

  public void cadastrarPessoaCandidata(String nome, int numero) {
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);

    for (PessoaCandidata pessoa : listaCandidatos) {
      if (pessoa.getNumero() == numero) {
        System.out.println("Número já utilizado!");
        return;
      }
    }
    listaCandidatos.add(pessoaCandidata);
  }

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    PessoaEleitora eleitor = new PessoaEleitora(nome, cpf);

    for (PessoaEleitora pessoa : listaEleitores) {
      if (pessoa.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrado!");
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
            pessoaCandidata.setVotos();
            return;
          }
        }
      }
    }
    System.out.println("CPF ou número inválido!");
  }

  public Integer contagemVotos(int numero) {
    Integer votos = 0;

    for (Integer voto : this.votos) {
      if (voto == numero) {
        votos++;
      }
    }
    return votos;
  }

  public void resultadoParcial() {
    String resultado = "";
    for (PessoaCandidata candidato : listaCandidatos) {
      resultado +=
          "Nome: "
              + candidato.getNome()
              + " - "
              + contagemVotos(candidato.getNumero())
              + " votos"
              + "( "
              + (contagemVotos(candidato.getNumero()) / votantes.size()) * 100
              + "%"
              + " )"
              + "\n";
    }
    System.out.println(resultado + "\n" + "Total de votos: " + votantes.size());
  }

  public void mostrarResultado() {
    System.out.println("Resultado da votação:");
    for (PessoaCandidata pessoa : listaCandidatos) {
      System.out.println("Candidato " + pessoa.getNumero() + ": " + pessoa.getNome());
    }
  }
}
