package br.ufpb.dcx.amigosecreto;

import java.util.LinkedList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;
    private int maxMSG;

    public static final int MAX_MSG = 999;

    public SistemaAmigo(int maxMSG) {
        this.mensagens = new LinkedList<>();
        this.amigos = new LinkedList<>();
        this.maxMSG = maxMSG;
    }

    public SistemaAmigo() {
        this(MAX_MSG);
    }

    public int getMaxMSG() {
        return this.maxMSG;
    }

    public List<Amigo> getAmigo() {
        return this.amigos;
    }

    public void cadastraAmigo(String nome, String email) throws AmigoJaExisteException {
        Amigo amigo = new Amigo(nome, email, email);
        if (amigo.getEmail().equalsIgnoreCase(email)) {
            this.amigos.add(amigo);
        }
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        for (Amigo amigos : this.amigos) {
            if (amigos.getEmail().equalsIgnoreCase(email))
                ;
            return amigos;
        }
        throw new AmigoInexistenteException("Amigo não existe.");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, Boolean ehAnonima) {
        this.mensagens.add(new MensagemParaTodos(texto, emailRemetente, ehAnonima));
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario,
            Boolean ehAnonima) {
        this.mensagens.add(new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima));
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        LinkedList mensagensAnonimas = new LinkedList<>();
        for (Mensagem m : this.mensagens) {
            if (m.ehAnonima()) {
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado)
            throws AmigoInexistenteException {
        for (Amigo amigos : this.amigos) {
            if (amigos.getEmail().equals(emailDaPessoa)) {
                amigos.setEmailAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoInexistenteException("não existe pessoa no sistema com email" + emailDaPessoa);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for (Amigo a : amigos) {
            if (a.getEmail().equalsIgnoreCase(emailDaPessoa)) {
                if (a.getEmailAmigoSorteado() == null) {
                    throw new AmigoNaoSorteadoException("Amigo não está configurado");

                } else {
                    return a.getEmailAmigoSorteado();
                }
            }
        }
        throw new AmigoInexistenteException("Não existe amigo");
    }

    public List<Amigo> todosParticipantes() {
        List<Amigo> Participantes = new LinkedList<Amigo>();
        Participantes.addAll(amigos);
        return Participantes;
    }

}
