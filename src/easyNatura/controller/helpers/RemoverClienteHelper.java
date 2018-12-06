/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller.helpers;

import easyNatura.model.Cliente;
import easyNatura.view.RemoverCliente;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author pedro
 */
public class RemoverClienteHelper {
    
    private final RemoverCliente view;

    public RemoverClienteHelper(RemoverCliente view) {
        this.view = view;
    }
    
    public void preencherComboBoxCliente(ArrayList<Cliente> clientes){
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxCliente().getModel();
        if(comboBoxModel != null){
            for(Cliente cliente : clientes){
                comboBoxModel.addElement(cliente);
            }
        }
    }
}
