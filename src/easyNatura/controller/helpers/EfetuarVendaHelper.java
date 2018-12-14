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
    
    
    public void preencherComboBoxQuantidade(ArrayList<Produto> produtos, Produto checar){
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxQuantidade().getModel();
        if(comboBoxModel != null){
            for(Produto produto : produtos){
                if(produto.equals(checar)){
                    for(int i = 1; i <= produto.getQuantidade(); i++){
                        comboBoxModel.addElement(i);
                    }
                }
            }
        }
    }
    
    public Venda getVenda(int qnt){
        Cliente cliente = (Cliente) view.getjComboBoxCliente().getModel().getSelectedItem();
        Produto produto = (Produto) view.getjComboBoxProduto().getModel().getSelectedItem();
        String data = view.getjFormattedTextField1().getText();
        Venda clone = new Venda(0, cliente, produto, data, qnt);
        return clone;
    }
    
    
}
