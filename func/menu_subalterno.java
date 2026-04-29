package func;
import java.util.Scanner;

public class menu_subalterno {
    
    public static void innit (Scanner scanner){
        
       String opc;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(
                "================ Menu - Subalterno ================\n" +
                "|"+ "1 - Marcar o Inicio do Trabalho +-------------|" +"\n"+
                "|"+ "2 - Marcar Tempo de Intervalo do Trabalho +---|" +"\n"+
                "|"+ "3 - Marcar Fim do Expediente +----------------|" +"\n"+
                "|"+ "4 - Consultar Salário Vigente +---------------|" +"\n"+
                "|"+ "0 - Deslogar do sistema +---------------------|" +"\n"+
                "================================================"
            );
            System.out.println("Digite um dos números citador acima:");
            opc = scanner.nextLine();
        
        }while (!opc.matches("[0-6]"));


    }

}
