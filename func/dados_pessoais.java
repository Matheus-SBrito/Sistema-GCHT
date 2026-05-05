package func;
import config.classes.Sessao;
import config.classes.SubAlterno;
import config.classes.Funcionarios;
import config.classes.Gerente;

public class dados_pessoais {
    
    public static String innit (Sessao session){

        String opc = "";
        Funcionarios perfil = session.getUsuario();

        do{
            try {
                if (session.getEstado_login() == false){
                    opc = "0";

                } else {
                    System.out.println(
                    "================ Dados pessoais ================\n" +
                    "Nome: " + perfil.getNome() + "\n" +
                    "Sobrenome: " + perfil.getNome() + "\n" +
                    "Idade: " + perfil.getNome() + "\n" +
                    "Setor: " + perfil.getNome() + "\n" +
                    "Nome: " + perfil.getNome() + "\n" +

                    );
                }
            } catch (Exception e) {
                opc = "0";
                System.out.println(e.getMessage());
            }
        }while (!opc.equals("0") || !opc.equals("-"));

        return opc;
    }
}
