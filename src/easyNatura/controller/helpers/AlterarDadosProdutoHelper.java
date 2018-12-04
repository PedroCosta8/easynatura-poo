/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.controller.helpers;

import easyNatura.model.Produto;
import easyNatura.view.AlterarDadosProduto;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author pedro
 */
public class AlterarDadosProdutoHelper {
    
    private final AlterarDadosProduto view;
    
    public AlterarDadosProdutoHelper(AlterarDadosProduto view){
         this.view = view;
    }
    
    public void preencherComboBoxProduto(ArrayList<Produto> produtos){
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxProdutos().getModel();
        if(comboBoxModel != null){
            for(Produto produto : produtos){
                comboBoxModel.addElement(produto);
            }
        }
    }
}
