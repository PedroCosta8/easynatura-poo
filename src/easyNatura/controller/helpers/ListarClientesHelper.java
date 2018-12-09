/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller.helpers;

import easyNatura.model.Cliente;
import easyNatura.view.ListarClientes;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author igu
 */

public class ListarClientesHelper {
    
    private final ListarClientes view;
    
    public ListarClientesHelper(ListarClientes view){
        this.view = view;
    }
    
    public void preencherTabela(ArrayList<Cliente> clientes){
       DefaultTableModel tableModel = (DefaultTableModel) view.getJTableC().getModel();
       tableModel.setRowCount(0);
       
       if(clientes != null){
           for(Cliente cliente : clientes){
               tableModel.addRow(new Object[]{
                   cliente.getNome(),
                   cliente.getTelefone(),
                   cliente.getEndereco(),
                   cliente.getCep(),
                   cliente.getEmail(),
               });
           }
       }
    }   
}
