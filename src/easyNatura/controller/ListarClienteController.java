/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package easyNatura.controller;

import easyNatura.controller.helpers.ListarClientesHelper;
import easyNatura.model.Cliente;
import easyNatura.model.DAO.ClienteDAO;
import easyNatura.view.ListarClientes;
import java.util.ArrayList;

/**
 *
 * @author igu
 */

public class ListarClienteController {
    
    private final ListarClientes view;
    private final ListarClientesHelper helper;
    
    public ListarClienteController(ListarClientes view){
        this.view = view;
        this.helper = new ListarClientesHelper(view);
    }
    
    public void atualizaTabela(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.retornaTodos();
        helper.preencherTabela(clientes);
    }
}
