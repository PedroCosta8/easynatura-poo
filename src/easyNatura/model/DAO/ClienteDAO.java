/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model.DAO;

import easyNatura.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class ClienteDAO {
    
    public void inserir(Cliente cliente){
        Banco.cliente.add(cliente);
    }
    
    public boolean atualizar(Cliente cliente){
        
        for (int i = 0; i < Banco.cliente.size(); i++) {
            if(idSaoIguais(Banco.cliente.get(i),cliente)){
                Banco.cliente.set(i, cliente);
                return true;
            }
        }
        return false;      

    }
    
    public ArrayList<Cliente> retornaTodos(){
        return Banco.cliente;
    }
    
    public boolean deletar(Cliente cliente){
        for (Cliente clienteLista : Banco.cliente) {
            if(idSaoIguais(clienteLista,cliente)){
                Banco.cliente.remove(clienteLista);
                return true;
            }
        }
        return false;
    }
    
    private boolean idSaoIguais(Cliente cliente, Cliente clienteAComparar) {
        return cliente.getId() ==  clienteAComparar.getId();
    }
}
