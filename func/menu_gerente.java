package func;
import java.util.Scanner;

public class menu_gerente {
    
    public static String init (Scanner scanner){
        
        String opc;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(
                "================ Menu - Gerente ================\n" +
                "|"+ "1 - Vizualizar Informações Pessoais +---------|" +"\n"+
                "|"+ "2 - Marcar o Inicio do Trabalho +-------------|" +"\n"+
                "|"+ "3 - Marcar Tempo de Intervalo do Trabalho +---|" +"\n"+
                "|"+ "4 - Marcar Fim do Expediente +----------------|" +"\n"+
                "|"+ "5 - Consultar Salário Vigente +---------------|" +"\n"+
                "|"+ "----------------------------------------------|" +"\n"+
                "|"+ "6 - Vizualizar Usuarios Cadastrados +---------|" +"\n"+
                "|"+ "7 - Tabela de Carga Horária Semanal +---------|" +"\n"+
                "|"+ "8 - Tabela de Carga Horária Mensal +----------|" +"\n"+
                "|"+ "9 - Tabela de Faltas +------------------------|" +"\n"+
                "|"+ "10 - Tabela de Horas extras +------------------|" +"\n"+
                "|"+ "0 - Deslogar do sistema +---------------------|" +"\n"+
                "================================================"
            );

            System.out.println("Digite um dos números citador acima:");
            opc = scanner.nextLine();
        
        }while (!opc.matches("^(10|[0-9]$)"));

        return opc;


    }
}
