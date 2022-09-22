package br.ufpb.systemfriend;

public class Amigo {

  private String nome;
  private String email;
  private String emailAmigoSorteado;

  public Amigo() {
    this.nome = "";
    this.email = "";
    this.emailAmigoSorteado = "";
  }

  public Amigo(String nome, String email, String emailAmigoSorteado) {
    this.nome = nome;
    this.email = email;
    this.emailAmigoSorteado = emailAmigoSorteado;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmailAmigoSorteado() {
    return emailAmigoSorteado;
  }

  public void setEmailAmigoSorteado(String emailAmigoSorteado) {
    this.emailAmigoSorteado = emailAmigoSorteado;
  }
}
