/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.ListarProdutosHelper;
import easyNatura.model.DAO.ProdutoDAO;
import easyNatura.model.Produto;
import easyNatura.view.ListarProdutos;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class ListarProdutosController {
    
    private final ListarProdutos view;
    private final ListarProdutosHelper helper;

    public ListarProdutosController(ListarProdutos view) {
        this.view = view;
        this.helper = new ListarProdutosHelper(view);
    }
    
    public void atualizaTabela(){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<Produto> produtos = produtoDAO.retornaTodos();
        this.helper.preecherTabela(produtos);
    }
    
}
