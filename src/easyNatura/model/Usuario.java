/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model;

/**
 *
 * @author pedro
 */
public class Usuario extends Pessoa{
    
    private String login;
    private String senha;

    public Usuario(int id, String nome, String telefone, String email, String login, String senha) {
        super(id, nome, telefone, email);
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.getNome(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
