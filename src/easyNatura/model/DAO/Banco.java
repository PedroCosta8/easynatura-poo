/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model.DAO;

import easyNatura.model.Cliente;
import easyNatura.model.Produto;
import easyNatura.model.Usuario;
import easyNatura.model.Venda;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class Banco {
    
    public static ArrayList<Usuario> usuario;
    public static ArrayList<Cliente> cliente;
    public static ArrayList<Venda> venda;
    public static ArrayList<Produto> produto;
    
    public static void inicia(){
        usuario = new ArrayList<>();
        cliente = new ArrayList<>();
        venda = new ArrayList<>();
        produto = new ArrayList<>();
        
        Usuario usuario1 = new Usuario(0, "administrador", "0000", "admin@admin.com", "admin", "admin");
        usuario.add(usuario1);
    }
}
