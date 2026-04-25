package config.classes;
import java.time.LocalDate;

public class SubAlterno extends Funcionarios {

    private static int contador = 0;

    public SubAlterno (
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

        if (SubAlterno.contador == 999){
            throw new RuntimeException (
                "A classe tem um limite de 999 instâncias. Limite alcançado."
            );
        }

        int ano_atual = LocalDate.now().getYear();

        String create_ndf = 
        (SubAlterno.contador < 10)? 
            ano_atual + "00" + SubAlterno.contador
            : (SubAlterno.contador < 99)? 
                ano_atual + "0" + SubAlterno.contador
                :
                ano_atual + "" + SubAlterno.contador;

                
        SubAlterno.contador ++;


        return create_ndf;

    }
    
}
