/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller.helpers;

import easyNatura.model.Produto;
import easyNatura.view.ListarProdutos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedro
 */
public class ListarProdutosHelper {
    
    private final ListarProdutos view;

    public ListarProdutosHelper(ListarProdutos view) {
        this.view = view;
    }
    
    public void preecherTabela(ArrayList<Produto> produtos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTable1().getModel();
        tableModel.setRowCount(0);
        
        //percorrer a lista preenchendo o tableModel
        if(produtos != null){
            for(Produto produto : produtos){
                tableModel.addRow(new Object[]{
                    produto.getId(),
                    produto.getNome(),
                    produto.getValor(),
                    produto.getQuantidade()
                });
            }
        }
    }
    
}
