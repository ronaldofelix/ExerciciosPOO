package br.ufpb.dcx.amigosecreto;

public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos(
            String texto,
            String emailRemetente,
            Boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    public String getTextoCompletoAExibir() {
        if (super.ehAnonima()) {
            return ("Mensagem para todos. " + getEmailRemetente() + " Texto: " + getTexto());
        } else {
            return ("Mensagem de: " +
                    getEmailRemetente() +
                    " Para todos. Texto: " +
                    getTexto());
        }
    }
}