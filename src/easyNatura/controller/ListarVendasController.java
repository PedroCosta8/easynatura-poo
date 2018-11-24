/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.ListarVendasHelper;
import easyNatura.model.DAO.VendaDAO;
import easyNatura.model.Venda;
import easyNatura.view.ListarVendas;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class ListarVendasController {
    
    private final ListarVendas view;
    private final ListarVendasHelper helper;

    public ListarVendasController(ListarVendas view) {
        this.view = view;
        this.helper = new ListarVendasHelper(view);
    }
    
    public void atualizaTabela(){
        VendaDAO vendaDAO = new VendaDAO();
        ArrayList<Venda> vendas = vendaDAO.retornaTodos();
        helper.preencherTabela(vendas);
    }
    
}
