import func.login;
import java.util.Scanner;
import config.classes.*;

public class app{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Sessao session = login.innit(scanner);

        if (session.getEstado_login()){
            
        }

    }
}