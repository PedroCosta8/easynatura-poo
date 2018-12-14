/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.RemoverFuncionarioHelper;
import easyNatura.model.DAO.UsuarioDAO;
import easyNatura.model.Usuario;
import easyNatura.view.RemoverFuncionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class RemoverFuncionarioController {
    
    private final RemoverFuncionario view;
    private final RemoverFuncionarioHelper helper;

    public RemoverFuncionarioController(RemoverFuncionario view) {
        this.view = view;
        helper = new RemoverFuncionarioHelper(view);
    }
    
    public void listarFuncionarios(){
       UsuarioDAO usuarioDAO = new UsuarioDAO();
       ArrayList <Usuario> usuarios = usuarioDAO.retornaTodos();
       
       if(usuarios != null){
            helper.preencherComboBoxFuncionarios(usuarios);
        }
    }
    
    public void removerFuncionario(){
       UsuarioDAO usuarioDAO = new UsuarioDAO();
       ArrayList <Usuario> usuarios = usuarioDAO.retornaTodos();
       //abaixo é feito uma conversão de item do combobox para um objeto cliente
       Usuario usuarioJcBox = (Usuario) view.getjComboBoxFuncionarios().getModel().getSelectedItem();
        if(usuarios != null){
           for (int i = 0; i < usuarios.size(); i++){
               //nova condição de verificação, utilizando o id
               if(usuarios.get(i).getId() == usuarioJcBox.getId()){
                   boolean ver = usuarioDAO.deletar(usuarios.get(i));
                  if(ver){
                      JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso");
                      view.dispose();
                  }
                  else{
                      JOptionPane.showMessageDialog(null, "Não foi possível remover o cliente");
                  }
                  break;
                }
            }
        }
    }
}
