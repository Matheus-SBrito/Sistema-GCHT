package config.classes;

public class Gerente extends Funcionarios {

    public Gerente(
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

    public Gerente(
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
        if (ndf_creator == true) {this.NDF = montadorNDF(99);}
    }

}