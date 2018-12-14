/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package easyNatura.controller;

import easyNatura.exceptions.QuantidadeInvalidaException;
import easyNatura.exceptions.ValorInvalidoException;
import easyNatura.view.AlterarDadosCliente;
import easyNatura.view.AlterarDadosProduto;
import easyNatura.view.CadastrarCliente;
import easyNatura.view.CadastrarFuncionario;
import easyNatura.view.CadastrarProduto;
import easyNatura.view.EfetuarVenda;
import easyNatura.view.ListarClientes;
import easyNatura.view.ListarProdutos;
import easyNatura.view.ListarVendas;
import easyNatura.view.Menu;
import easyNatura.view.RemoverCliente;
import easyNatura.view.RemoverFuncionario;
import easyNatura.view.RemoverProduto;

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
    
    public void iniciaRemoveFunc(){
        RemoverFuncionario rmvFunc = new RemoverFuncionario();
        rmvFunc.setVisible(true);
    }
    
    public void iniciaCadCliente(){
        CadastrarCliente cadCli = new CadastrarCliente();
        cadCli.setVisible(true);
    }
    
    public void iniciaAltDadosCliente(){
        AlterarDadosCliente altDa = new AlterarDadosCliente();
        altDa.setVisible(true);
    }
    
    public void iniciaRemoveCliente(){
        RemoverCliente rmvCliente = new RemoverCliente();
        rmvCliente.setVisible(true);
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
    
    public void iniciaAltDadosProd() throws QuantidadeInvalidaException, ValorInvalidoException{
        AlterarDadosProduto altDp = new AlterarDadosProduto();
        altDp.setVisible(true);
    }
    
    public void iniciaRemoveProduto(){
        RemoverProduto rmvProduto = new RemoverProduto();
        rmvProduto.setVisible(true);
    }

    public void iniciaListarClientes() {
        ListarClientes listarC = new ListarClientes();
        listarC.setVisible(true);
    }
}
