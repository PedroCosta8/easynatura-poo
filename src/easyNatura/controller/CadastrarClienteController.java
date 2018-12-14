/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller;

import easyNatura.controller.helpers.CadastrarClienteHelper;
import easyNatura.model.Cliente;
import easyNatura.model.DAO.ClienteDAO;
import easyNatura.view.CadastrarCliente;
import easyNatura.exceptions.EmailInvalidoException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class CadastrarClienteController {
    
    private final CadastrarCliente view;
    private final CadastrarClienteHelper helper;

    public CadastrarClienteController(CadastrarCliente view) {
        this.view = view;
        this.helper = new CadastrarClienteHelper(view);
    }
    
    public void cadastrar() throws EmailInvalidoException {
        Cliente cliente = helper.getCliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.inserir(cliente);
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
        view.dispose();
    }
    
}
