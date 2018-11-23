/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller.helpers;

import easyNatura.model.Cliente;
import easyNatura.model.Produto;
import easyNatura.model.Venda;
import easyNatura.view.EfetuarVenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author pedro
 */
public class EfetuarVendaHelper {
    
    private final EfetuarVenda view;

    public EfetuarVendaHelper(EfetuarVenda view) {
        this.view = view;
    }
    
    public void preencherComboBoxCliente(ArrayList<Cliente> clientes){
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxCliente().getModel();
        if(comboBoxModel != null){
            for(Cliente cliente : clientes){
                comboBoxModel.addElement(cliente);
            }
        }
        
    }
    
    public void preencherComboBoxProduto(ArrayList<Produto> produtos){
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxProduto().getModel();
        if(comboBoxModel != null){
            for(Produto produto : produtos){
                comboBoxModel.addElement(produto);
            }
        }
    }
    
    public Venda getVenda(){
        Cliente cliente = (Cliente) view.getjComboBoxCliente().getModel().getSelectedItem();
        Produto produto = (Produto) view.getjComboBoxProduto().getModel().getSelectedItem();
        String data = view.getjTextFieldData().getText();
        Venda clone = new Venda(0, cliente, produto, data);
        return clone;
    }
    
    
}
