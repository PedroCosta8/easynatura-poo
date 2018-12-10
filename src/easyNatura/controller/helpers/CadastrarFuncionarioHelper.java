/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller.helpers;

import easyNatura.exceptions.EmailInvalidoException;
import easyNatura.exceptions.SenhaInvalidaException;
import easyNatura.model.Usuario;
import easyNatura.view.CadastrarFuncionario;

/**
 *
 * @author pedro
 */
public class CadastrarFuncionarioHelper {
    
    private final CadastrarFuncionario view;

    public CadastrarFuncionarioHelper(CadastrarFuncionario view) {
        this.view = view;
    }
    
    public Usuario getUsuario() throws SenhaInvalidaException, EmailInvalidoException{
        String nome = view.getjTextFieldNome().getText();
        String telefone = view.getjFormattedTel().getText();
        String email = view.getjTextFieldEmail().getText();
        String login = view.getjTextFieldLogin().getText();
        String senha = view.getjPasswordField1().getText();
        
        Usuario clone = new Usuario(0, nome, telefone, email, login, senha);
        return clone;
    }
}
