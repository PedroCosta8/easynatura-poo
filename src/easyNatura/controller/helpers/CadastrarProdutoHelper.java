/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller.helpers;

import easyNatura.model.Produto;
import easyNatura.view.CadastrarProduto;

/**
 *
 * @author pedro
 */
public class CadastrarProdutoHelper {
    
    private final CadastrarProduto view;

    public CadastrarProdutoHelper(CadastrarProduto view) {
        this.view = view;
    }
    
    public Produto getProduto(){
        String nome = view.getjTextFieldNome().getText();
        double valor = Double.parseDouble(view.getjTextFieldValor().getText());
        int qtd = Integer.parseInt(view.getjTextFieldQuantidade().getText());
        
        Produto clone = new Produto(0, nome, valor, qtd);
        return clone;
    }
    
    public void setProduto(Produto clone){
        String nome = clone.getNome();
        double valor = clone.getValor();
        int qtd = clone.getQuantidade();
        
        view.getjTextFieldNome().setText(nome);
        view.getjTextFieldValor().setText(String.valueOf(valor));
        view.getjTextFieldQuantidade().setText(String.valueOf(qtd));
    }
    
    public void limparTela(){
        view.getjTextFieldNome().setText("");
        view.getjTextFieldValor().setText("");
        view.getjTextFieldValor().setText("");
    }
    
}
