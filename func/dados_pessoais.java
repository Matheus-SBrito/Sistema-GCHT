package func;

import java.util.Scanner;

import config.classes.Sessao;
import config.classes.SubAlterno;
import config.classes.Funcionarios;
import config.classes.Gerente;

public class dados_pessoais {
    
    public static String init (Scanner scanner,Sessao session){

        String opc = "";
        SubAlterno perfil_subalterno = null;
        Gerente perfil_gerente = null;

        while (true) {
            try {

                if (session.getEstado_login() == false){
                    opc = "0";
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    if (session.getUsuario() instanceof Gerente){
                        perfil_gerente = (Gerente) session.getUsuario();
                        exibir_dados_gerente(perfil_gerente);
                    } else if (session.getUsuario() instanceof SubAlterno){
                        perfil_subalterno = (SubAlterno) session.getUsuario();
                        exibir_dados_subalterno(perfil_subalterno);
                    }

                    System.out.print(
                        "Digite um dos seguintes caracteres:\n" +
                        "0 - Deslogar do sistema.\n" +
                        "< - Voltar ao menu.\n" +
                        "Opção: "
                    );
                    opc = scanner.nextLine();
                 
                }

            } catch (Exception e) {
                opc = "0";
                System.out.println(e.getMessage());
            }finally{
                
                if (opc.equals("0") || opc.equals("<")){return opc;}
            }
        }
    }


    private static void exibir_dados_gerente(Gerente perfil){


        System.out.println(
            "================ Dados Pessoais ================" + "\n" +
            "Ndf: " + perfil.getNDF() + "\n" +
            "Cpf: " + perfil.getCPF() + "\n" +
            "Nome: " + perfil.getNome() + "\n" +
            "Sobrenome: " + perfil.getSobrenome() + "\n" +
            "Idade: " + perfil.getIdade() + "\n" +
            "Setor: " + perfil.getSetor() + "\n" +
            "-------------------------------------------------\n"
        );
    }

    private static void exibir_dados_subalterno(SubAlterno perfil){

        System.out.println(
            "================ Dados Pessoais ================" + "\n" +
            "Ndf: " + perfil.getNDF() + "\n" +
            "Cpf: " + perfil.getCPF() + "\n" +
            "Nome: " + perfil.getNome() + "\n" +
            "Sobrenome: " + perfil.getSobrenome() + "\n" +
            "Idade: " + perfil.getIdade() + "\n" +
            "Setor: " + perfil.getSetor() + "\n" +
            "-------------------------------------------------\n"
            
        );

    }

}
