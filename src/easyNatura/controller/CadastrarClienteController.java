/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.CadastrarClienteHelper;
import easyNatura.model.Cliente;
import easyNatura.model.DAO.Banco;
import easyNatura.model.DAO.ClienteDAO;
import easyNatura.view.CadastrarCliente;
import easyNatura.exceptions.EmailInvalidoException;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class CadastrarClienteController {
    
    private final CadastrarCliente view;
    private final CadastrarClienteHelper helper;

    public CadastrarClienteController(CadastrarCliente view) {
        this.view = view;
        this.helper = new CadastrarClienteHelper(view);
    }
    
    public void cadastrar() throws EmailInvalidoException {
        Cliente cliente = helper.getCliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.inserir(cliente);
        /*ArrayList<Cliente> listaClientes = Banco.cliente;;

              for(int i = 0; i < listaClientes.size(); i++){
                  
                System.out.println(listaClientes.get(i).getId());
                System.out.println(listaClientes.get(i).getNome());
                System.out.println(listaClientes.get(i).getTelefone());
                System.out.println(listaClientes.get(i).getEmail());
                System.out.println(listaClientes.get(i).getEndereco());
                System.out.println(listaClientes.get(i).getCep());
              }
        System.out.println(listaClientes.size());*/
        view.dispose();
    }
    
}
