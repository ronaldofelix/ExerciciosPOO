package br.ufpb.systemfriend;

import java.util.List;

import javax.swing.JOptionPane;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) throws AmigoInexistenteException, AmigoJaExisteException {
        int maxMsg = Integer.parseInt(JOptionPane.showInputDialog("Número máximo de mensagens suportado?" ));
        SistemaAmigo sysAmigo = new SistemaAmigo(maxMsg);

        int maxAmigos = Integer.parseInt(JOptionPane.showInputDialog("Quantos participantes?"));
        for (int i = 0; i < maxAmigos; i++) {
            String nome = JOptionPane.showInputDialog("Qual nome do úsuario");
            String email = JOptionPane.showInputDialog("Qual o email?");
            sysAmigo.cadastraAmigo(nome, email);

        }
        List<Amigo> todosParticipantes = sysAmigo.todosParticipantes();
        for (Amigo a : todosParticipantes) {
            String emailAmigoSorteado = JOptionPane.showInputDialog("Qual amigo secreto de: " + a.getEmail());
            try {
                sysAmigo.configuraAmigoSecretoDe(a.getEmail(), emailAmigoSorteado);
            } catch (AmigoInexistenteException e) {
                JOptionPane.showMessageDialog(null, "Problema de configuração amigo secreto.");
                e.getStackTrace();
            }
        }

        String msg = JOptionPane.showInputDialog("Digite uma mensagem pra enviar: ");
        String mail = JOptionPane.showInputDialog("Digite seu email: ");
        String msgAnonima = JOptionPane.showInputDialog("Mensagem anonima? (S)sim ou (N) não ");
        boolean ehAnonima = false;

        if(msgAnonima.equalsIgnoreCase("s")){
            ehAnonima = true;
        } else if(msgAnonima.equalsIgnoreCase("n")){
            ehAnonima = false;
        }
        sysAmigo.enviarMensagemParaTodos(msg, mail, ehAnonima);

    }  
}
