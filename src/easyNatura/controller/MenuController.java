/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.view.AlterarDados;
import easyNatura.view.CadastrarCliente;
import easyNatura.view.CadastrarFuncionario;
import easyNatura.view.CadastrarProduto;
import easyNatura.view.EfetuarVenda;
import easyNatura.view.ListarProdutos;
import easyNatura.view.ListarVendas;
import easyNatura.view.Menu;

/**
 *
 * @author pedro
 */
public class MenuController {
    
    private final Menu view;

    public MenuController(Menu view) {
        this.view = view;
    }
    
    public void inciaCadFunc(){ // incia view do cadastro de funcionarios 
        CadastrarFuncionario cadFunc = new CadastrarFuncionario();
        cadFunc.setVisible(true);
    }
    
    public void iniciaCadCliente(){
        CadastrarCliente cadCli = new CadastrarCliente();
        cadCli.setVisible(true);
    }
    
    public void iniciaAltDados(){
        AlterarDados altDa = new AlterarDados();
        altDa.setVisible(true);
    }
    
    public void iniciaEfetuarVenda(){
        EfetuarVenda eftVenda = new EfetuarVenda();
        eftVenda.setVisible(true);
    }
    
    public void iniciaListarVendas(){
        ListarVendas listarV = new ListarVendas();
        listarV.setVisible(true);
    }
    
    public void iniciaCadProduto(){
        CadastrarProduto cadProd = new CadastrarProduto();
        cadProd.setVisible(true);
    }
    
    public void iniciaListarProdutos(){
        ListarProdutos listarP = new ListarProdutos();
        listarP.setVisible(true);
    }
}
