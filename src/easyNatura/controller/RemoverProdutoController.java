/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.RemoverProdutoHelper;
import easyNatura.model.DAO.ProdutoDAO;
import easyNatura.model.Produto;
import easyNatura.view.RemoverProduto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class RemoverProdutoController {
    
    private final RemoverProduto view;
    private final RemoverProdutoHelper helper;

    public RemoverProdutoController(RemoverProduto view) {
        this.view = view;
        helper = new RemoverProdutoHelper(view);
    }
    
    public void listarProdutos(){
       ProdutoDAO produtoDAO = new ProdutoDAO();
       ArrayList <Produto> produtos = produtoDAO.retornaTodos();
       
       if(produtos != null){
            this.helper.preencherComboBoxProdutos(produtos);
        }
    }
    
    public void removerProduto(){
       ProdutoDAO produtoDAO = new ProdutoDAO();
       ArrayList <Produto> produtos = produtoDAO.retornaTodos();
       //abaixo é feito uma conversão de item do combobox para um objeto cliente
       Produto produtoJcCombobox = (Produto) view.getjComboBoxProdutos().getModel().getSelectedItem();
        if(produtos != null){
           for (int i = 0; i < produtos.size(); i++){
               //nova condição de verificação, utilizando o id
               if(produtos.get(i).getId() == produtoJcCombobox.getId()){
                   boolean ver = produtoDAO.deletar(produtos.get(i));
                  if(ver){
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
