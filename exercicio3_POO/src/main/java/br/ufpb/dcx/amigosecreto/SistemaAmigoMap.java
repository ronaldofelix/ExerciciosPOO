package br.ufpb.dcx.amigosecreto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {
    private Map<String, Amigo> amigos;
    private List<Mensagem> mensagens;
    private int maxMSG;

    public static final int MAX_MSG = 999;

    public SistemaAmigoMap(int maxMSG) {
        this.mensagens = new LinkedList<>();
        this.amigos = new HashMap<>();
        this.maxMSG = maxMSG;
    }

    public SistemaAmigoMap() {
        this(MAX_MSG);
    }

    public int getMaxMSG() {
        return this.maxMSG;
    }

    public Map<String, Amigo> getAmigo() {
        return this.amigos;
    }

    public void cadastraAmigo(String nome, String email) throws AmigoJaExisteException {
        Amigo amigo = new Amigo(nome, email, email);
        if (amigo.getEmail().equalsIgnoreCase(email)) {
            this.amigos.put(email, amigo);
        }
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        for (Amigo amigos : this.amigos.values()) {
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
        List<Mensagem> mensagensAnonimas = new LinkedList<Mensagem>();
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
        for (Amigo amigos : this.amigos.values()) {
            if (amigos.getEmail().equals(emailDaPessoa)) {
                amigos.setEmailAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoInexistenteException("não existe pessoa no sistema com email" + emailDaPessoa);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for (Amigo a : amigos.values()) {
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

    public Map<String, Amigo> todosParticipantes() {
        Map<String, Amigo> Participantes = new HashMap<String, Amigo>();
        Participantes.putAll(amigos);
        return Participantes;
    }

}
