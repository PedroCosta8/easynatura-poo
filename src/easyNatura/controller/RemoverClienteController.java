/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.RemoverClienteHelper;
import easyNatura.model.Cliente;
import easyNatura.model.DAO.ClienteDAO;
import easyNatura.view.RemoverCliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class RemoverClienteController {
    
    private final RemoverCliente view;
    private final RemoverClienteHelper helper;

    public RemoverClienteController(RemoverCliente view) {
        this.view = view;
        helper = new RemoverClienteHelper(view);
    }
    
    public void listarClientes(){
       ClienteDAO clienteDAO = new ClienteDAO();
       ArrayList <Cliente> clientes = clienteDAO.retornaTodos();
       
       if(clientes != null){
            this.helper.preencherComboBoxCliente(clientes);
        }
    }
    
    public void removerCliente(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList <Cliente> clientes = clienteDAO.retornaTodos();
       //abaixo é feito uma conversão de item do combobox para um objeto cliente
       Cliente clienteJcBox = (Cliente) view.getjComboBoxCliente().getModel().getSelectedItem();
        if(clientes != null){
           for (int i = 0; i < clientes.size(); i++){
               //nova condição de verificação, utilizando o id
               if(clientes.get(i).getId() == clienteJcBox.getId()){
                   boolean ver = clienteDAO.deletar(clientes.get(i));
                  if(ver){
                      JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
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
