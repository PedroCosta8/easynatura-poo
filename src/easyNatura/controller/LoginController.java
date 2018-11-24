/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.LoginHelper;
import easyNatura.model.DAO.UsuarioDAO;
import easyNatura.model.Usuario;
import easyNatura.view.Login;
import easyNatura.view.Menu;

/**
 *
 * @author pedro
 */
public class LoginController {
    
    private final Login view;
    private final LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarSistema(){
        Usuario usuario = helper.getUsuario();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorLoginESenha(usuario);
        if(usuarioAutenticado != null){
            Menu menu = new Menu();
            menu.setVisible(true);
            this.view.dispose();
        }
        else{
            this.view.mostraMensagem("Usuário ou Senha inválidos");
        }
    }
    
    
    
}