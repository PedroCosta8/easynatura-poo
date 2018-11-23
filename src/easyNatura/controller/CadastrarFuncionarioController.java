/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.CadastrarFuncionarioHelper;
import easyNatura.model.DAO.Banco;
import easyNatura.model.DAO.UsuarioDAO;
import easyNatura.model.Usuario;
import easyNatura.view.CadastrarFuncionario;
import java.util.ArrayList;

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
    
    public void cadastrar(){ 
        Usuario usuario = helper.getUsuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        usuarioDAO.inserir(usuario);
        /*ArrayList<Usuario> listaUsuarios = Banco.usuario;;

              for(int i = 0; i < listaUsuarios.size(); i++){
                  
                System.out.println(listaUsuarios.get(i).getId());
                System.out.println(listaUsuarios.get(i).getNome());
                System.out.println(listaUsuarios.get(i).getTelefone());
                System.out.println(listaUsuarios.get(i).getEmail());
                System.out.println(listaUsuarios.get(i).getLogin());
                System.out.println(listaUsuarios.get(i).getSenha());
              }
        System.out.println(listaUsuarios.size());*/
        view.dispose();
    }
    
}
