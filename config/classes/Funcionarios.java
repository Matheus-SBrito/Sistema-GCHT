package config.classes;
import config.Operacao_db;
import java.io.IOException;
import java.time.LocalDate;

public class Funcionarios{

    protected String NDF;
    private String cpf;
    private String nome;
    private String sobrenome;
    private int idade;

    private String setor;
    private boolean emAtividade;
    private String senha;
    

    protected Funcionarios(
        String cpf,
        String nome,
        String sobrenome,
        int idade,

        String senha,

        String setor,
        boolean emAtividade
    ){

        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;

        this.senha = senha;

        this.setor = setor;
        this.emAtividade = emAtividade;     
    }

    public String getNome (){return this.nome;}
    public void setterNome (String nome){this.nome = nome;}

    public String getSobrenome (){return this.sobrenome;}
    public void setterSobrenome (String sobrenome){this.sobrenome = sobrenome;}
    
    public int getIdade (){return idade;}
    public void setterIdade (int idade){this.idade = idade;}

    public String getSetor (){return this.setor;}
    public void setter (String setor){this.setor = setor;}

    public String getNDF (){return this.NDF;}
    public void setterNDF (String ndf){this.NDF = ndf;}
    protected String montadorNDF (int tamanho_cond_contador) throws RuntimeException{

        String dados_gerais = "config/db/qtd_instancias.txt";
        int contador = 0;
        String conversor;
        String ndf_expression = null;
        String dado_alterado = (tamanho_cond_contador == 99)?
                                    "Quantidade_gerentes":
                                        (tamanho_cond_contador == 999)?
                                        "Quantidade_": 
                                        "";

        try {
            int ano_atual = LocalDate.now().getYear();
            verificador_ano_Db_Ndf(ano_atual);
            
            
            Operacao_db.alterador_dado_arquivo(
                "config/db/qtd_instancias.txt", "Quantidade_gerentes", "" + contador);

            conversor = Operacao_db.pesquisar_dado(
                dados_gerais, "Quantidade_gerentes");
            if (!conversor.matches("[0-9]+")){
                throw new RuntimeException("Falha na consulta do dado, dado consultado de forma incorreta.");}
            contador = Integer.parseInt(conversor);
            
            if (contador == tamanho_cond_contador){
                throw new RuntimeException(
                    "A classe tem um limite de 99 instancias. Limite alcançado");
            }
            
            if (tamanho_cond_contador == 99){
                ndf_expression = 
                    (contador < 10)? ano_atual + "0" + contador:
                        ano_atual + "" + contador;}
            else if (tamanho_cond_contador == 999){
                ndf_expression = 
                    (contador < 10)? 
                        ano_atual + "00" + contador
                        : (contador < 99)? 
                            ano_atual + "0" + contador
                            :
                            ano_atual + "" + contador;
            }

            contador ++;

            Operacao_db.alterador_dado_arquivo(
                dados_gerais,
                dado_alterado,
                "" + contador);
        }
        catch(IOException erro){System.out.println(erro.getMessage());}
        catch (Exception erro) {System.out.println(erro.getMessage());}
        

        return ndf_expression;}

    public String getCPF(){return this.cpf;}

    public boolean getEmAtividade(){return this.emAtividade;}
    public void setterEmAtividade(boolean emAtividade){this.emAtividade = emAtividade;}

    public String getSenha (){return this.senha;}
    public void setterSenha (String senha){this.senha = senha;}

    protected void verificador_ano_Db_Ndf (int ano_atual)
    throws IOException{

        String dados_gerais = "config/db/qtd_instancias.txt";
        String[] chaves = {"Ano_atual", "Quantidade_gerentes","Quantidade_"};
        
        int ano_registrado = Integer.parseInt(
            Operacao_db.pesquisar_dado(
                dados_gerais,
                chaves[0]));
        
        if (ano_registrado != ano_atual){
            Operacao_db.alterador_dado_arquivo(
                dados_gerais,
                chaves[0],
                "" + ano_atual
            );

            Operacao_db.alterador_dado_arquivo(
                dados_gerais,
                chaves[1],
                "0");

            Operacao_db.alterador_dado_arquivo(
                dados_gerais,
                chaves[2],
                "0");
        }
    }

    public void getTabela_dados (){
        System.out.println(this.cpf);
        System.out.println(this.NDF);
        System.out.println(this.nome);
        System.out.println(this.sobrenome);
        System.out.println(this.idade);
        System.out.println(this.senha);
        System.out.println(this.setor);
        System.out.println(this.emAtividade);
    }
    
}