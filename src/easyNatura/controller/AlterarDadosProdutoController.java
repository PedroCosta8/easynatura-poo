/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.AlterarDadosProdutoHelper;
import easyNatura.model.DAO.ProdutoDAO;
import easyNatura.model.Produto;
import easyNatura.view.AlterarDadosProduto;
import easyNatura.exceptions.QuantidadeInvalidaException;
import easyNatura.exceptions.ValorInvalidoException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class AlterarDadosProdutoController {
    
    private final AlterarDadosProduto view;
    private final AlterarDadosProdutoHelper helper;
    
    public AlterarDadosProdutoController(AlterarDadosProduto view) throws QuantidadeInvalidaException,
            ValorInvalidoException {
        this.view = view;
        helper = new AlterarDadosProdutoHelper(view);
    }
    
   public void listarProdutos(){
       ProdutoDAO produtoDAO = new ProdutoDAO();
       ArrayList <Produto> produtos = produtoDAO.retornaTodos();
       
       if(produtos != null){
            this.helper.preencherComboBoxProduto(produtos);
        }
   }
   
   public void alterarDadosProduto() throws QuantidadeInvalidaException{
       ProdutoDAO produtoDAO = new ProdutoDAO();
       ArrayList <Produto> produtos = produtoDAO.retornaTodos();
       //abaixo é feito uma conversão de item do combobox para um objeto cliente
       Produto produtoJcBox = (Produto) view.getjComboBoxProdutos().getModel().getSelectedItem();
        if(produtos != null){
           for (int i = 0; i < produtos.size(); i++){
               //nova condição de verificação, utilizando o id
               if(produtos.get(i).getId() == produtoJcBox.getId()){
                  produtos.get(i).setNome(view.getjTextFieldNome().getText());
                  produtos.get(i).setValor(Double.parseDouble(view.getjTextFieldValor().getText()));
                  produtos.get(i).setQuantidade(Integer.parseInt(view.getjTextFieldQtd().getText()));
                  boolean ver = produtoDAO.atualizar(produtos.get(i)); //metodo de persistencia de dados;
                  if(ver){
                      view.dispose();
                  }
                  else{
                      JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados");
                  }
                }
            }
        }
   }
}
