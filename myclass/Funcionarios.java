package myclass;

public class Funcionarios{

    protected String NDF;
    private String cpf;
    private String nome;
    private String sobrenome;
    private int idade;

    private String setor;
    private boolean emAtividade;
    

    protected Funcionarios(
        String cpf,
        String nome,
        String sobrenome,
        int idade,

        String setor,
        boolean emAtividade
    ){

        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;

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
    protected String montadorNDF(){return "1";}

    public String getCPF(){return this.cpf;}

    public boolean getEmAtividade(){return this.emAtividade;}
    public void setterEmAtividade(boolean emAtividade){this.emAtividade = emAtividade;}
    
}