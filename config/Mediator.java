package config;
import java.io.IOException;
import config.Operacao_db;
import config.classes.Gerente;
import config.classes.SubAlterno;

public class Mediator {
    
    public static void setteDb_instancia_gerente 
    (Gerente obj){

        

    }

    public static void setteDb_instancia_subalterno 
    (SubAlterno obj){



    }

    public static Gerente getDb_instancia_gerente (String ndf){
        Gerente obj = null;
        try{
                
                String cpf = Operacao_db.pesquisar_dado(
                "config/db/gerentes/" + ndf + ".txt", "Cpf");

                String nome = Operacao_db.pesquisar_dado(
                "config/db/gerentes/" + ndf + ".txt", "Nome");

                String sobrenome = Operacao_db.pesquisar_dado(
                "config/db/gerentes/" + ndf + ".txt", "Sobrenome");

                int idade = Integer.parseInt(Operacao_db.pesquisar_dado(
                "config/db/gerentes/" + ndf + ".txt", "Idade"));

                String setor = Operacao_db.pesquisar_dado(
                "config/db/gerentes/" + ndf + ".txt", "Setor");

                String senha = Operacao_db.pesquisar_dado(
                "config/db/gerentes/" + ndf + ".txt", "Senha");

                boolean emAtividade = Boolean.parseBoolean(Operacao_db.pesquisar_dado(
                "config/db/gerentes/" + ndf + ".txt", "Em_atividade"));

            obj = new Gerente(ndf, cpf, nome, sobrenome, idade, senha, setor, emAtividade);
            
        }catch(IOException error){
            System.out.println(error.getMessage());
        }
        return obj;
    }

    public static SubAlterno getDb_instanciar_subalterno (String ndf){
        SubAlterno obj = null;
        try{
                
                String cpf = Operacao_db.pesquisar_dado(
                "config/db/subalternos/" + ndf + ".txt", "Cpf");

                String nome = Operacao_db.pesquisar_dado(
                "config/db/subalternos/" + ndf + ".txt", "Nome");

                String sobrenome = Operacao_db.pesquisar_dado(
                "config/db/subalternos/" + ndf + ".txt", "Sobrenome");

                int idade = Integer.parseInt(Operacao_db.pesquisar_dado(
                "config/db/subalternos/" + ndf + ".txt", "Idade"));

                String setor = Operacao_db.pesquisar_dado(
                "config/db/subalternos/" + ndf + ".txt", "Setor");

                String senha = Operacao_db.pesquisar_dado(
                "config/db/subalternos/" + ndf + ".txt", "Senha");

                boolean emAtividade = Boolean.parseBoolean(Operacao_db.pesquisar_dado(
                "config/db/subalternos/" + ndf + ".txt", "Em_atividade"));

            obj = new SubAlterno(ndf, cpf, nome, sobrenome, idade, senha, setor, emAtividade);
            
        }catch(IOException error){
            System.out.println(error.getMessage());
        }
        return obj;
    }

}
