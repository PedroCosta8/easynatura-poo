/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura;

import easyNatura.model.DAO.Banco;
import easyNatura.view.Login;
import java.io.FileNotFoundException;

/**
 *
 * @author pedro
 */
public class EasyNatura {
    
    public static void main(String[] args){
        Banco.inicia();
        Login loginView = new Login();
        loginView.setVisible(true);
    }
}
