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
          System.out.println("Pessoa eleitora já votou!");
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

  public void mostrarResultado() {
    // DecimalFormat df = new DecimalFormat();
    // df.applyPattern("#,#0.0 %");

    String resultado = "";
    for (PessoaCandidata candidato : listaCandidatos) {
      resultado +=
          "Nome: "
              + candidato.getNome()
              + " - "
              + contagemVotos(candidato.getNumero())
              + " votos"
              + "( "
              + String.format(
                  "%.1f", (contagemVotos(candidato.getNumero()) * 100.0) / listaEleitores.size())
              + "%"
              + " )"
              + "\n";
    }
    System.out.println(resultado + "\n" + "Total de votos: " + votantes.size());
  }

  // public void setup() {
  // cadastrarPessoaCandidata("João", 1);
  // cadastrarPessoaCandidata("Maria", 2);
  // cadastrarPessoaCandidata("Pedro", 3);
  // cadastrarPessoaCandidata("Ana", 4);
  // cadastrarPessoaCandidata("José", 5);
  // cadastrarPessoaCandidata("Paulo", 6);
  // cadastrarPessoaCandidata("Júlia", 7);
  // cadastrarPessoaCandidata("Carla", 8);
  // cadastrarPessoaCandidata("Paula", 9);
  // cadastrarPessoaCandidata("Ana Paula", 10);

  // cadastrarPessoaEleitora("João", "123456789-0");
  // cadastrarPessoaEleitora("Maria", "987654321-1");
  // cadastrarPessoaEleitora("Pedro", "123456789-2");
  // cadastrarPessoaEleitora("Ana", "987654321-3");
  // cadastrarPessoaEleitora("José", "123456789-4");
  // cadastrarPessoaEleitora("Paulo", "987654321-5");
  // cadastrarPessoaEleitora("Júlia", "123456789-6");
  // cadastrarPessoaEleitora("Carla", "987654321-7");
  // cadastrarPessoaEleitora("Paula", "123456789-8");
  // cadastrarPessoaEleitora("Ana Paula", "987654321-9");

  // votar("123456789-0", 1);
  // votar("987654321-1", 1);
  // votar("123456789-2", 2);
  // votar("987654321-3", 2);
  // votar("123456789-4", 2);
  // votar("987654321-5", 3);
  // votar("123456789-6", 3);
  // votar("987654321-7", 3);
  // votar("123456789-8", 3);
  // votar("987654321-9", 4);
  // }
}
