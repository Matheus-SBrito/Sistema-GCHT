package test.arquivo_class;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.File;

import java.io.FileWriter;
import java.io.BufferedWriter;


public class Operacao_db {
    

    public static void leitor_arquivo (String path) throws IOException{
        
        FileReader arquivo_lido = null;
        BufferedReader acelerador_leitura = null;

        try{

            arquivo_lido = new FileReader(path);
            acelerador_leitura = new BufferedReader(arquivo_lido);

            String linha_lida = acelerador_leitura.readLine();

            while (linha_lida != null) {

                System.out.println(linha_lida);
                linha_lida = acelerador_leitura.readLine();
                
            }

        }catch (IOException exception){
            
            System.out.println("Falha em leitura");

        }finally{

            if (acelerador_leitura != null){
                acelerador_leitura.close();
            }

            if (arquivo_lido != null){
                arquivo_lido.close();
            }

        }

    }


    public static void criador_arquivos (String path) throws IOException{

        FileWriter arquivo = null;

        try {
            
            arquivo = new FileWriter(path, true);

        } catch (IOException exception) {

            System.out.println("Falha na leitura.");

        } finally {

            if (arquivo != null){
                arquivo.close();
            }
        }


    }


    public static void escritor_arquivos (
        String path,

        String chave,
        String valor
        ) throws IOException{

        File memoria_arquivo = new File(path);

        FileWriter arquivo_criado = null;
        BufferedWriter escritor_percorredor = null;


        // Verificando se o arquivo ñ existe ou se ñ há nenhum conteudo.
        boolean verificador_existencia = 
            !memoria_arquivo.exists() 
            || 
            memoria_arquivo.length() == 0;
        
        
        try {
            
            arquivo_criado = new FileWriter(path, true);
            escritor_percorredor = new BufferedWriter(arquivo_criado);

            if (verificador_existencia == true){
                escritor_percorredor.write(
                    "============ Dados ============"
                );
                escritor_percorredor.newLine();
            }

            if (!dado_in_db(path, chave)){
                escritor_percorredor.write(chave + ": " + valor);
                escritor_percorredor.newLine();
            }
            else{
                System.out.println("Não é possivel adicionar um dado já existente.");
            }



            
        } catch (IOException exception) {
            // TODO: handle exception

        } finally {

            if (escritor_percorredor != null){
                escritor_percorredor.close();
            }

            if (arquivo_criado != null){
                arquivo_criado.close();
            }

            
        }
        
    }


    public static boolean dado_in_db (
        String path,
        String chave)
        throws IOException{

            boolean verificador_existencia =
                (new File(path)).exists();
            boolean dado_encontrado = false;


            if (verificador_existencia){

                FileReader arquivo = null;
                BufferedReader leitor = null;

                try {
                    
                    arquivo = new FileReader(path);
                    leitor = new BufferedReader(arquivo);
                    String linha_lida = "";

                    do{
                        
                        linha_lida = leitor.readLine();
                        
                        if (linha_lida.contains(chave)){
                            dado_encontrado = true;
                        }

                    }while (linha_lida != null);

                    
                } catch (Exception e) {
                    // TODO: handle exception

                } finally{
                    if (leitor != null){leitor.close();} 
                    if (arquivo != null){arquivo.close();}
                }

            }else {

                throw new IOException ("Erro. O arquivo de procura não existe.");
            }

            return dado_encontrado;

        }

}
