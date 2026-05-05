package func;
import java.util.Scanner;
import config.classes.Sessao;
import config.Mediator;

public class login {

    public static Sessao init(Scanner scanner) {
        Sessao session = null;
        String ndf; String senha; String loop_log = "s";

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

            if (ndf.length() == 6 || ndf.length() == 7){
                session = (ndf.length() == 6)? 
                    new Sessao(Mediator.getDb_instancia_gerente(ndf)):
                    (ndf.length() == 7)? new Sessao(Mediator.getDb_instanciar_subalterno(ndf)): null;
                session = (session.getUsuario() == null)?null:
                            (session.getUsuario().getSenha().equals(senha))? session:null;
                if (session != null){loop_log = "n"; continue;}
            }
            
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("!!Senha Invalida!!");
            while (true) {
                System.out.println("Deseja efetuar o login novamente (s/n)?");
                loop_log = scanner.nextLine().trim();
                if ((loop_log.equals("s"))
                    || (loop_log.equals("n"))){break;}
                
            }
            
        }
        return session;
    }
    
}
