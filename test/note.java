package test;
import test.arquivo_class.Operacao_db;
import java.io.IOException;

public class note {
    

    public static void main(String[] args) {

        try{
        //Operacao_db.criador_arquivos("test/db", "2026000");        
        //Operacao_db.leitor_arquivo("test/db/2026000.txt");
        Operacao_db.escritor_arquivos("test/db/2026000.txt", "Ndf", "32534");

        }catch(IOException exception){
            System.out.println("Falha em leitura.");
        }

    }


}
