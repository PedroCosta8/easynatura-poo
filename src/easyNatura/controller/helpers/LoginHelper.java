/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller.helpers;

import easyNatura.model.Usuario;
import easyNatura.view.Login;

/**
 *
 * @author pedro
 */
public class LoginHelper {
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario getUsuario(){
        String login = view.getLogin().getText();
        String senha = view.getSenha().getText();
        
        Usuario clone = new Usuario(0,"null", "", "", login, senha);
        return clone;
    }
    
    public void setUsuario(Usuario clone){
        String login = clone.getLogin();
        String senha = clone.getSenha();
        
        view.getLogin().setText(login);
        view.getSenha().setText(senha);
    }
    
    public void limparTela(){
        view.getLogin().setText("");
        view.getSenha().setText("");
    }
}
