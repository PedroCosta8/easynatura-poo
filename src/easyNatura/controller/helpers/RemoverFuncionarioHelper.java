/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller.helpers;

import easyNatura.model.Usuario;
import easyNatura.view.RemoverFuncionario;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author pedro
 */
public class RemoverFuncionarioHelper {
    
    private final RemoverFuncionario view;

    public RemoverFuncionarioHelper(RemoverFuncionario view) {
        this.view = view;
    }
    
    public void preencherComboBoxFuncionarios(ArrayList<Usuario> usuarios){
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxFuncionarios().getModel();
        if(comboBoxModel != null){
            for(Usuario usuario : usuarios){
                comboBoxModel.addElement(usuario);
            }
        }
    }
}
