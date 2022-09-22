package br.ufpb.dcx.amigosecreto;

public class MensagemParaAlguem extends Mensagem {

    private String emailDestinatario;

    public MensagemParaAlguem(
            String texto,
            String emailRemetente,
            String emailDestinatario,
            Boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir() {
        if (super.ehAnonima()) {
            return ("Mensagem para " + getEmailDestinatario() + ". Texto: " + getTexto());
        } else {
            return ("Mensagem de: " +
                    getEmailRemetente() +
                    " Para " +
                    getEmailDestinatario() +
                    " Texto: " +
                    getTexto());
        }
    }
}
