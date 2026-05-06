import java.util.Scanner;

import func.login;
import func.menu_gerente;
import func.menu_subalterno;
import func.dados_pessoais;

import config.classes.Sessao;
import config.classes.Gerente;
import config.classes.SubAlterno;

public class app{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Sessao session = login.init(scanner);
        String opc = "<";

        if (session != null){
            
            do{
                if (session.getUsuario() instanceof Gerente && opc.equals("<")){
                    opc = menu_gerente.init(scanner);

                } else if (session.getUsuario() instanceof SubAlterno && opc.equals("<")){
                    opc = menu_subalterno.init(scanner);}

                if (opc.equals("1")){
                    opc = dados_pessoais.init(scanner, session);
                }


            }while (!opc.equals("0"));

            session = null;


            
        }

    }
}