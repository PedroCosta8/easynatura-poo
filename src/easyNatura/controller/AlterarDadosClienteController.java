/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.AlterarDadosClienteHelper;
import easyNatura.exceptions.EmailInvalidoException;
import easyNatura.view.AlterarDadosCliente;
import easyNatura.model.Cliente;
import easyNatura.model.DAO.ClienteDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author igu
 */

public class AlterarDadosClienteController {
    
    private final AlterarDadosCliente view;
    private final AlterarDadosClienteHelper helper;
    
    public AlterarDadosClienteController(AlterarDadosCliente view){
        this.view = view;
        helper = new AlterarDadosClienteHelper(view);
    }
    
   public void listarClientes(){
       ClienteDAO clienteDAO = new ClienteDAO();
       ArrayList <Cliente> clientes = clienteDAO.retornaTodos();
       
       if(clientes != null){
            this.helper.preencherComboBoxCliente(clientes);
        }
   }
   
   public void alterarDadosCliente() throws EmailInvalidoException{
       ClienteDAO clienteDAO = new ClienteDAO();
       ArrayList <Cliente> clientes = clienteDAO.retornaTodos();
       //abaixo é feito uma conversão de item do combobox para um objeto cliente
       Cliente clienteJcBox = (Cliente) view.getjComboBoxCliente().getModel().getSelectedItem();
        if(clientes != null){
           for (int i = 0; i < clientes.size(); i++){
               //nova condição de verificação, utilizando o id
               if(clientes.get(i).getId() == clienteJcBox.getId()){
                  clientes.get(i).setNome(view.getjTextFieldNome().getText());
                  clientes.get(i).setTelefone(view.getjFormattedTextEdTel().getText());
                  clientes.get(i).setCep(view.getjFormattedTextFieldCEP().getText());
                  clientes.get(i).setEndereco(view.getjTextFieldEnd().getText());
                  clientes.get(i).setEmail(view.getjTextFieldEmail().getText());
                  boolean ver = clienteDAO.atualizar(clientes.get(i)); //metodo de persistencia de dados;
                  if(ver){
                      JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                      view.dispose();
                  }
                  else{
                      JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados");
                  }
                  break;
                }
            }
        }
   }
}
