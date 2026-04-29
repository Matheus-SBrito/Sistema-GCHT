import java.util.Scanner;

import func.login;
import func.menu_gerente;
import func.menu_subalterno;

import config.classes.Sessao;
import config.classes.Gerente;
import config.classes.SubAlterno;

public class app{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Sessao session = login.innit(scanner);

        if (session != null){

            if (session.getUsuario() instanceof Gerente){
                menu_gerente.innit(scanner);

            } else if (session.getUsuario() instanceof SubAlterno){
                menu_subalterno.innit(scanner);

            }
            
        }

    }
}