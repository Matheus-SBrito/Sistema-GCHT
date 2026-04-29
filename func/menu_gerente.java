package func;
import java.util.Scanner;

public class menu_gerente {
    
    public static void innit (Scanner scanner){
        
        String opc;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(
                "================ Menu - Gerente ================\n" +
                "|"+ "1 - Marcar o Inicio do Trabalho +-------------|" +"\n"+
                "|"+ "2 - Marcar Tempo de Intervalo do Trabalho +---|" +"\n"+
                "|"+ "3 - Marcar Fim do Expediente +----------------|" +"\n"+
                "|"+ "4 - Consultar Salário Vigente +---------------|" +"\n"+
                "|"+ "----------------------------------------------|" +"\n"+
                "|"+ "5 - Vizualizar Usuarios Cadastrados +---------|" +"\n"+
                "|"+ "6 - Tabela de Carga Horária Semanal +---------|" +"\n"+
                "|"+ "7 - Tabela de Carga Horária Mensal +----------|" +"\n"+
                "|"+ "8 - Tabela de Faltas +------------------------|" +"\n"+
                "|"+ "9 - Tabela de Horas extras +------------------|" +"\n"+
                "|"+ "0 - Deslogar do sistema +---------------------|" +"\n"+
                "================================================"
            );

            System.out.println("Digite um dos números citador acima:");
            opc = scanner.nextLine();
        
        }while (!opc.matches("[0-9]"));


    }
}
