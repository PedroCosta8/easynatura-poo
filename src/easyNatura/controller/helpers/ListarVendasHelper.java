/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller.helpers;

import easyNatura.model.Venda;
import easyNatura.view.ListarVendas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedro
 */
public class ListarVendasHelper {
    
    private final ListarVendas view;

    public ListarVendasHelper(ListarVendas view) {
        this.view = view;
    }
    
    public void preencherTabela(ArrayList<Venda> vendas){
       DefaultTableModel tableModel = (DefaultTableModel) view.getjTable1().getModel();
       tableModel.setRowCount(0);
       
       if(vendas != null){
           for(Venda venda : vendas){
               tableModel.addRow(new Object[]{
                   venda.getId(),
                   venda.getCliente(),
                   venda.getProduto(),
                   venda.getDataFormatada(),
                   venda.getQuantidade()
               });
           }
       }
       
    }
    
}
