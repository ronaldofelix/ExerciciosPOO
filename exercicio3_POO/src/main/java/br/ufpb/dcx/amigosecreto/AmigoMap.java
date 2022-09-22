package br.ufpb.dcx.amigosecreto;

public class AmigoMap {

    private String nome;
    private String email;
    private String emailAmigoSorteado;

    public AmigoMap() {
        this.nome = "";
        this.email = "";
        this.emailAmigoSorteado = "";
    }

    public AmigoMap(String nome, String email, String emailAmigoSorteado) {
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
