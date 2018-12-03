/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller.helpers;

import easyNatura.model.Cliente;
import easyNatura.view.CadastrarCliente;

/**
 *
 * @author pedro
 */
public class CadastrarClienteHelper {
    
    private final CadastrarCliente view;

    public CadastrarClienteHelper(CadastrarCliente view) {
        this.view = view;
    }
    
    public Cliente getCliente(){
        String nome = view.getjTextFieldNome().getText();
        String telefone = view.getjTextFieldTelefone().getText();
        String email = view.getjTextFieldEmail().getText();
        String endereco = view.getjTextFieldEndereco().getText();
        String cep = view.getjTextFieldCep().getText();
        
        Cliente clone = new Cliente(0, nome, telefone, email, endereco, cep);
        return clone;
    }
    
    public void setCliente(Cliente clone){
        String nome = clone.getNome();
        String telefone = clone.getTelefone();
        String email = clone.getEmail();
        String endereco = clone.getEndereco();
        String cep = clone.getCep();
        
        view.getjTextFieldNome().setText(nome);
        view.getjTextFieldTelefone().setText(telefone);
        view.getjTextFieldEmail().setText(email);
        view.getjTextFieldEndereco().setText(endereco);
        view.getjTextFieldCep().setText(cep);
    }
    
    public void limparTela(){
        view.getjTextFieldNome().setText("");
        view.getjTextFieldTelefone().setText("");
        view.getjTextFieldEmail().setText("");
        view.getjTextFieldEndereco().setText("");
        view.getjTextFieldCep().setText("");  
    }
    
}
