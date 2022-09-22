package br.ufpb.systemfriend;

import java.util.List;

public class TestaSistemaAmigo {

  public static void main(String[] args) throws AmigoNaoSorteadoException, AmigoJaExisteException {
    SistemaAmigo sistema = new SistemaAmigo();
    sistema.cadastraAmigo("José", "josé@gmail.com");
    sistema.cadastraAmigo("Maria", "Maria@gmail.com");

    try {
      sistema.configuraAmigoSecretoDe("josé@gmail.com", "Maria@gmail.com");
      sistema.configuraAmigoSecretoDe("Maria@gmail.com", "josé@gmail.com");
      System.out.println("Amigos configurados com sucesso");
    } catch (AmigoInexistenteException e) {
      System.out.println(e.getMessage());
    }

    sistema.enviarMensagemParaAlguem(
      "Olá",
      "josé@gmail.com",
      "maria@gmail.com",
      true
    );
    sistema.enviarMensagemParaTodos("Eai galerinha", "josé@gmail.com", true);

    List<Mensagem> mensagens = sistema.pesquisaMensagensAnonimas();

    for (Mensagem m : mensagens) {
      System.out.println(m.getTextoCompletoAExibir());
    }

    try {
      sistema.pesquisaAmigoSecretoDe("josé@gmail.com");
      System.out.println("OK");
    } catch (AmigoInexistenteException e) {
      System.out.println(e.getMessage());
    }
  }
}
