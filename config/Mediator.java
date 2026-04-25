package config;
import config.Operacao_db;
import config.classes.Gerente;
import config.classes.SubAlterno;

public class Mediator {
    
    public static void setteDb_instancia_gerente 
    (Gerente obj){

        

    }

    public static void setteDb_instancia_subalterno 
    (SubAlterno obj){



    }

    public static Gerente getDb_instancia_gerente (String ndf){
        Gerente obj = new Gerente(null, null, null, 0, null, false);

        return obj;
    }

    public static SubAlterno getDb_instanciar_subalterno (String ndf){
        SubAlterno obj = new SubAlterno(null, null, null, 0, null, false);

        return obj;
    }

}
