/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.CadastrarProdutoHelper;
import easyNatura.exceptions.QuantidadeInvalidaException;
import easyNatura.exceptions.ValorInvalidoException;
import easyNatura.model.DAO.ProdutoDAO;
import easyNatura.model.Produto;
import easyNatura.view.CadastrarProduto;
import javax.swing.JOptionPane;

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
    
    public void cadastrar() throws QuantidadeInvalidaException, ValorInvalidoException, 
            NumberFormatException{
//        try{
            Produto produto = helper.getProduto();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.inserir(produto);
            view.dispose(); 
//        } catch (QuantidadeInvalidaException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        } catch (ValorInvalidoException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(null, "Dados inválidos");
//        }
        
    }
    
}
