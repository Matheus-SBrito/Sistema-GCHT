import java.util.Scanner;

import func.login;
import func.menu_gerente;
import func.menu_subalterno;
import fun.dados_pessoais;

import config.classes.Sessao;
import config.classes.Gerente;
import config.classes.SubAlterno;

public class app{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Sessao session = login.innit(scanner);
        String opc = "-";

        if (session != null){
            
            do{
                if (session.getUsuario() instanceof Gerente && opc.equals("-")){
                    opc = menu_gerente.innit(scanner);

                } else if (session.getUsuario() instanceof SubAlterno && opc.equals("-")){
                    opc = menu_subalterno.innit(scanner);}

                if (opc.equals("0")){
                    opc = 

                }


            }while (opc.equals("0"));


            
        }

    }
}