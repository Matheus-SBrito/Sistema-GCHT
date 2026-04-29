package func;
import java.util.Scanner;
import config.classes.Sessao;
import config.Mediator;

public class login {

    public static Sessao innit(Scanner scanner) {
        Sessao session = null;
        String ndf; String senha;String loop_log = "s";

        while (loop_log.equals("s")) {
            System.out.println(
                "================ Login ================\n"+
                "*Por favor informe seu Ndf e sua Senha.\n" +
                "*Após isso você poderá utilizar o Sistema.\n\n"
            );
                System.out.print("Digite seu NDF (Número Idendificador): ");
                ndf = scanner.nextLine().trim();
                while (!(ndf.length() == 6 || ndf.length() == 7) && ndf.matches("[0-9]+")){
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("!!Por favor Digite um ndf válido.!!");
                    System.out.print("Digite seu NDF (Número Idendificador): ");
                    ndf = scanner.nextLine().trim();
                }

            System.out.print("Digite sua senha de usuario: ");
            senha = scanner.nextLine().trim();

            System.out.println("----------------------------------------");

            if (ndf.length() == 6){
                session = new Sessao(Mediator.getDb_instancia_gerente(ndf));
                session = (session.getUsuario() == null)?null:session;
            } else if (ndf.length() == 7){
                session = new Sessao(Mediator.getDb_instanciar_subalterno(ndf));
                session = (session.getUsuario() == null)?null:session;
            }
            if (session != null){
                if (session.getUsuario().getSenha().equals(senha)){loop_log = "n";}}
            
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("!!Senha Invalida, deseja efetuar o login novamente (s/n)?");
            do {loop_log = scanner.nextLine();} 
            while (!loop_log.equals("s") || !loop_log.equals("n"));
            
        }
        return session;
    }
    
}
