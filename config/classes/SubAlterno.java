package config.classes;

public class SubAlterno extends Funcionarios {

    public SubAlterno(
        String ndf,
        String cpf,
        String nome,
        String sobrenome,
        int idade,

        String senha,

        String setor,
        boolean emAtividade
    ){
        super(cpf, nome, sobrenome, idade, senha, setor, emAtividade);
        setterNDF(ndf);
    }

    public SubAlterno(
        String cpf,
        String nome,
        String sobrenome,
        int idade,

        String senha,

        String setor,
        boolean emAtividade,
        boolean ndf_creator
    ){
        super(cpf, nome, sobrenome, idade, senha, setor, emAtividade);
        if (ndf_creator == true) {this.NDF = montadorNDF(999);}
    }

    
}
