package test.arquivo_class;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.File;

import java.io.FileWriter;
import java.io.BufferedWriter;


public class Operacao_txt {
    
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


    public static void criador_arquivos (String path, String nome_arquivo) throws IOException{

        FileWriter arquivo = null;

        try {
            
            arquivo = new FileWriter(path + "/" + nome_arquivo + ".txt", true);

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
        String valor,

        String nome_objeto
    ) throws IOException{

        File endereco_arquivo = new File(path);

        FileWriter arquivo = null;
        BufferedWriter acelerador_escrita = null;


        // Verifica se o arquivo existe ou se o arquivo está vázio
        boolean verificador_arquivo =   !endereco_arquivo.exists() 
                                        ||
                                        endereco_arquivo.length() == 0;

        
        try {

            arquivo = new FileWriter(path, true);
            acelerador_escrita = new BufferedWriter(arquivo);            


            if(verificador_arquivo){
                acelerador_escrita.write(
                    "===="+
                    nome_objeto +
                    "===="
                );
                acelerador_escrita.newLine();
                
            }


            acelerador_escrita.write(chave + ": " + valor);
            acelerador_escrita.newLine();
            
            
        } catch (IOException exception) {
            System.out.println("Falha na arbetura do arquivo.");
        } finally {

            if (arquivo != null){arquivo.close();}
            if (acelerador_escrita != null){acelerador_escrita.close();}
            
        }

        
    }


}
