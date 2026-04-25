package config.classes;
import java.time.LocalDate;


public class Gerente extends Funcionarios {
    
    private static int contador = 0;

    public Gerente(
        String cpf,
        String nome,
        String sobrenome,
        int idade,

        String setor,
        boolean emAtividade
    ){

        super(cpf, nome, sobrenome, idade, setor, emAtividade);
        this.NDF = montadorNDF();
    }

    protected String montadorNDF () throws RuntimeException{

        if (Gerente.contador == 99){
            throw new RuntimeException(
                "A classe tem um limite de 99 instancias. Limite alcançado");
        }

        int anoAtual = LocalDate.now().getYear();
        String ndf_expression = 
            (Gerente.contador < 10)? anoAtual + "0" + Gerente.contador:
                anoAtual + "" + Gerente.contador;

        Gerente.contador ++;
        

        return ndf_expression;
    }

}