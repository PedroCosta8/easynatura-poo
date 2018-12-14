/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.CadastrarFuncionarioHelper;
import easyNatura.exceptions.SenhaInvalidaException;
import easyNatura.model.DAO.UsuarioDAO;
import easyNatura.model.Usuario;
import easyNatura.view.CadastrarFuncionario;
import easyNatura.exceptions.EmailInvalidoException;
import javax.swing.JOptionPane;


/**
 *
 * @author pedro
 */
public class CadastrarFuncionarioController {
    
    private final CadastrarFuncionario view;
    private final CadastrarFuncionarioHelper helper;

    public CadastrarFuncionarioController(CadastrarFuncionario view) {
        this.view = view;
        helper = new CadastrarFuncionarioHelper(view);
    }
    
    public void cadastrar() throws SenhaInvalidaException, EmailInvalidoException { 
        Usuario usuario = helper.getUsuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO(); 
        usuarioDAO.inserir(usuario);
        JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso");
        view.dispose();
    }
    
}
