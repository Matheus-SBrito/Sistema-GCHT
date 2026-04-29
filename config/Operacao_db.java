package config;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.File;

import java.io.FileWriter;
import java.io.BufferedWriter;


public class Operacao_db {
    

    public static String leitor_arquivo (String path) throws IOException{
        String todos_dados = "";
        FileReader arquivo_lido = null;
        BufferedReader acelerador_leitura = null;

        try{
            arquivo_lido = new FileReader(path);
            acelerador_leitura = new BufferedReader(arquivo_lido);
            String linha_lida = acelerador_leitura.readLine();

            while (linha_lida != null) {
                todos_dados += linha_lida;
                linha_lida = acelerador_leitura.readLine();}

        }catch (IOException exception){
            System.out.println("Falha em leitura");

        }finally{
            if (acelerador_leitura != null){acelerador_leitura.close();}
            if (arquivo_lido != null){arquivo_lido.close();}

        }
        return todos_dados;
    }


    public static void criador_arquivos (
        String path,
        String titulo,
        String primeira_chave,
        String valor_chave
        
    ) throws IOException{
        FileWriter arquivo = null;
        BufferedWriter escritor = null;

        try {
            arquivo = new FileWriter(path);
            escritor = new BufferedWriter(arquivo);

            escritor.write(
                "============"+
                " Dados - "+ titulo +
                "============");
            escritor.newLine();
            escritor.write(primeira_chave + ": " + valor_chave);

        } catch (IOException exception) {
            System.out.println("Falha na abertura do arquivo.");

        } finally {
            if (escritor != null){escritor.close();}
            if (arquivo != null){arquivo.close();}
        }

    }


    public static void escritor_arquivos (
        String path,String chave,String valor) throws IOException{

        File memoria_arquivo = new File(path);
        FileWriter arquivo_criado = null;
        BufferedWriter escritor_percorredor = null;

        // Verificando se o arquivo ñ existe ou se ñ há nenhum conteudo.
        boolean verificador_existencia = 
            !memoria_arquivo.exists() || memoria_arquivo.length() == 0;
        
        try {
            arquivo_criado = new FileWriter(path, true);
            escritor_percorredor = new BufferedWriter(arquivo_criado);

            if (verificador_existencia == true){
                escritor_percorredor.write("============ Dados ============");
                escritor_percorredor.newLine();
            }
            if (!dado_in_db(path, chave)){
                escritor_percorredor.write(chave + ": " + valor);
                escritor_percorredor.newLine();
            }else{
                System.out.println("Não é possivel adicionar um dado já existente.");
            }

        } catch (IOException exception) {
            // TODO: handle exception
        } finally {
            if (escritor_percorredor != null){escritor_percorredor.close();}
            if (arquivo_criado != null){arquivo_criado.close();}}
    }


    public static boolean dado_in_db (String path,String chave)
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
                        if (linha_lida.contains(chave)){dado_encontrado = true;}

                    }while (linha_lida != null);

                } catch (Exception e) {
                    // TODO: handle exception
                } finally{
                    if (leitor != null){leitor.close();} 
                    if (arquivo != null){arquivo.close();}
                }
            }else {throw new IOException ("Erro. O arquivo de procura não existe.");}

            return dado_encontrado;}


    public static void alterador_dado_arquivo(String path, String chave, String valor)
        throws IOException{

            File file = new File (path);
            boolean verificador_existencia =
                !file.exists() || file.length() == 0;

            if (!verificador_existencia){
                
                if (!dado_in_db(path, chave)){throw new IOException("Dado não encontrado no arquivo.");}
                FileReader arquivo_lido = null;
                FileWriter arquivo_escrever = null;
                BufferedWriter escritor = null;
                BufferedReader leitor = null;
                
                try {
                    arquivo_lido = new FileReader  (path); leitor = new BufferedReader(arquivo_lido);
                    arquivo_escrever = new FileWriter(path + "_1", true); escritor = new BufferedWriter(arquivo_escrever);
                    String linha;
                    
                    do{
                        linha = leitor.readLine();
                        if (linha.contains(chave)){
                            escritor.write(chave + ": " + valor);
                        }
                        else{escritor.write(linha);}
                        escritor.newLine();                            
                    }while(linha != null);

                } catch (Exception e) {
                    // TODO: handle exception
                }
                finally{
                    if(escritor != null){escritor.close();}
                    if(arquivo_escrever != null){arquivo_escrever.close();}
                    if(leitor != null){leitor.close();}
                    if (arquivo_lido != null){arquivo_lido.close();}
                }
            }
            else{
                throw new IOException ("Erro. Impossibilidade de encontrar o arquivo ou não nenhum dado no arquivo.");
            }

            new File (path).delete();        
            new File(path + "_1").renameTo(new File(path));
    }

    public static String pesquisar_dado (String path, String chave)
    throws IOException{
        File file = new File (path);

        if (!file.exists() || file.length() == 0){
            throw new IOException("O arquivo não existe ou não tem conteudo");}
        if (!dado_in_db(path, chave)){
            throw new IOException("O dado pesquisado não existe.");}
        
        FileReader arquivo = null;
        BufferedReader leitor =null;
        String linha_lida = "";
        try {
            arquivo = new FileReader (path);
            leitor = new BufferedReader(arquivo);

            do{
                linha_lida = leitor.readLine();

            }while (!linha_lida.contains(chave));
            linha_lida = linha_lida.replace(chave + ":", "").trim();
            // A partir deste ponto a linha lida é o dado que queriamos encontrar.

        }catch(IOException exception){
            throw new IOException("Falha na leitura do arquivo.");
            
        }finally{
            if (leitor != null){leitor.close();}
            if (arquivo != null){arquivo.close();}
        }

        return linha_lida;
    }

}
