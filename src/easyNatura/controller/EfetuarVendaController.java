/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.view.EfetuarVenda;
import easyNatura.controller.helpers.EfetuarVendaHelper;
import easyNatura.exceptions.QuantidadeInvalidaException;
import easyNatura.model.Cliente;
import easyNatura.model.DAO.ClienteDAO;
import easyNatura.model.DAO.ProdutoDAO;
import easyNatura.model.DAO.VendaDAO;
import easyNatura.model.Produto;
import easyNatura.model.Venda;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author pedro
 */
public class EfetuarVendaController {
    
    private final EfetuarVenda view;
    private final EfetuarVendaHelper helper;

    public EfetuarVendaController(EfetuarVenda view) {
        this.view = view;
        helper = new EfetuarVendaHelper(view);
    }
    
    public void atualizaCliente(){
       //buscar clientes do banco de dados
       ClienteDAO clienteDAO = new ClienteDAO();
       ArrayList <Cliente> clientes = clienteDAO.retornaTodos();
       
       //exibir clietes no combobox clientes
       //for(Cliente cliente : clientes){;
       if(clientes != null){
           this.helper.preencherComboBoxCliente(clientes);
       }
       //} 
    }
    
    public void atualizaProduto(){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<Produto> produtos = produtoDAO.retornaTodos();
        
        if(produtos != null){
            this.helper.preencherComboBoxProduto(produtos);
        }
    }
    
    public void efetuarVenda() throws QuantidadeInvalidaException{
        Venda venda = helper.getVenda();
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.inserir(venda);
        JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso");
        view.dispose();
    }
    
    public void getValorUnitario(Produto produtojcBox){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<Produto> produtos = produtoDAO.retornaTodos();
        if(produtos != null){
            for(int i = 0; i < produtos.size(); i++){
                if(produtos.get(i).getId() == produtojcBox.getId()){
                    view.getjTextValorUnitario().setText("R$: "+ produtos.get(i).getValor());    
                }
            }
        }
    }
}
