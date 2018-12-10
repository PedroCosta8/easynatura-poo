package easyNatura;

import easyNatura.model.DAO.Banco;
import easyNatura.view.Login;

public class EasyNatura { 
    
    public static void main(String[] args){
        Banco.inicia();
        Login loginView = new Login();
        loginView.setVisible(true);
    }
}
