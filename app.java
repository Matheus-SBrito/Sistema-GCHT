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
                if (session.getUsuario() instanceof Gerente){
                    if (opc.equals("<")){
                        opc = menu_gerente.init(scanner);
                    } else if (opc.equals("6")){
                        
                    } else if (opc.equals("7")){
                    
                    } else if (opc.equals("8")){
                    
                    } else if (opc.equals("9")){
                    
                    } else if (opc.equals("10")){
                    
                    }
                }

                if (session.getUsuario() instanceof SubAlterno && opc.equals("<")){
                    opc = menu_subalterno.init(scanner);
                } 
                
                if (opc.equals("1")) {
                    opc = dados_pessoais.init(scanner, session);
                } else if (opc.equals("2")){

                } else if (opc.equals("3")){
                    
                } else if (opc.equals("4")){
                    
                } else if (opc.equals("5")){
                    
                } else {
                    opc = "<";
                }


            }while (!opc.equals("0"));

            session = null;


            
        }

    }
}