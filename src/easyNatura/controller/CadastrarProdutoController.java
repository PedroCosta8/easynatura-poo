/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.CadastrarProdutoHelper;
import easyNatura.model.DAO.Banco;
import easyNatura.model.DAO.ProdutoDAO;
import easyNatura.model.Produto;
import easyNatura.view.CadastrarProduto;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class CadastrarProdutoController {
    
    private final CadastrarProduto view;
    private final CadastrarProdutoHelper helper;

    public CadastrarProdutoController(CadastrarProduto view) {
        this.view = view;
        helper = new CadastrarProdutoHelper(view);
    }
    
    public void cadastrar(){
        Produto produto = helper.getProduto();
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.inserir(produto);
//        ArrayList<Produto> listaProdutos = Banco.produtos;
//
//              for(int i = 0; i < listaProdutos.size(); i++){
//                  
//                System.out.println(listaProdutos.get(i).getId());
//                System.out.println(listaProdutos.get(i).getNome());
//                System.out.println(listaProdutos.get(i).getValor());
//                System.out.println(listaProdutos.get(i).getQuantidade()
//                );
//              }
//        System.out.println(listaProdutos.size;
        view.dispose();
    }
    
}
