package config.classes;
import config.classes.*;

public class Sessao {

    private boolean estado_login;
    private Funcionarios usuario = null;

    public Sessao (Funcionarios usuario) {
        this.estado_login = true;
        this.usuario = usuario;
    
    }

    public boolean getEstado_login(){return this.estado_login;}
    public Funcionarios getUsuario (){return this.usuario;}
}