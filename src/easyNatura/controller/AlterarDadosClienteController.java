/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.AlterarDadosClienteHelper;
import easyNatura.view.AlterarDados;
import easyNatura.model.Cliente;
import easyNatura.model.DAO.ClienteDAO;
import java.util.ArrayList;

/**
 *
 * @author igu
 */

public class AlterarDadosClienteController {
    
    private final AlterarDados view;
    private final AlterarDadosClienteHelper helper;
    
    public AlterarDadosClienteController(AlterarDados view){
        this.view = view;
        helper = new AlterarDadosClienteHelper(view);
    }
    
   public void listarClientes(){
       ClienteDAO clienteDAO = new ClienteDAO();
       ArrayList <Cliente> clientes = clienteDAO.retornaTodos();
       
       if(clientes != null){
            this.helper.preencherComboBoxProduto(clientes);
        }
       
       
   }
    
    
}
