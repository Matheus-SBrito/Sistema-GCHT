package test;
import test.arquivo_class.Operacao_txt;
import java.io.IOException;

public class note {
    

    public static void main(String[] args) {

        try{
        Operacao_txt.leitor_arquivo("test/db/2026001.txt");
        
        
        Operacao_txt.escritor_arquivos("test/db/2026002.txt", "Ndf", "2026002", "Subalternos");

        }catch(IOException exception){
            System.out.println("Falha em leitura.");
        }

    }


}
