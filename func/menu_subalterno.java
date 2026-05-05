package func;
import java.util.Scanner;

public class menu_subalterno {
    
    public static String innit (Scanner scanner){
        
       String opc;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(
                "================ Menu - Subalterno ================\n" +
                "|"+ "1 - Vizualizar Informações Pessoais +---------|" +"\n"+
                "|"+ "2 - Marcar o Inicio do Trabalho +-------------|" +"\n"+
                "|"+ "3 - Marcar Tempo de Intervalo do Trabalho +---|" +"\n"+
                "|"+ "4 - Marcar Fim do Expediente +----------------|" +"\n"+
                "|"+ "5 - Consultar Salário Vigente +---------------|" +"\n"+
                "|"+ "0 - Deslogar do sistema +---------------------|" +"\n"+
                "================================================"
            );
            System.out.println("Digite um dos números citador acima:");
            opc = scanner.nextLine();
        
        }while (!opc.matches("[0-6]"));

        return opc;


    }

}
