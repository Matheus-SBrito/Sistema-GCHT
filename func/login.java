package func;
import java.util.Scanner;
import config.classes.Sessao;

public class login {

    public static Sessao innit(Scanner scanner) {

        String ndf;
        String senha;

        while (true) {
            System.out.println(
                "================" +
                " Login "+
                "================\n"+
                "*Por favor informe seu Ndf e sua Senha.\n" +
                "*Após isso você poderá utilizar o Sistema.\n\n"

            );
        
                
                System.out.print("Digite seu NDF (Número Idendificador): ");
                ndf = scanner.nextLine();

                while (true){
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("!!Por favor Digite um ndf válido.!!");
                    System.out.println("Digite seu NDF (Número Idendificador): ");
                    ndf = scanner.nextLine();
                    if ((ndf.length() == 6 || ndf.length() == 7) && ndf.matches("[0-9]+")){
                        break;
                    }
                }

                System.out.print("Digite sua senha de usuario: ");
                senha = scanner.nextLine();

            System.out.println(
                "---------------"+
                "---------------"+
                "----------"
            );

            
            

        }
    }
    
}
