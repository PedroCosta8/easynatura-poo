/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model.DAO;

import com.google.gson.Gson;
import easyNatura.model.Cliente;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class ClienteDAO {
    
    public void inserir(Cliente cliente){
          
        if(cliente.getId() == 0){
            Gson gson = new Gson();
            String json;
            cliente.setId(proximoId());
            if(Banco.clientes != null){
                Banco.clientes.add(cliente);
                json = gson.toJson(Banco.clientes, Banco.typeCliente);
            }
            else{
                ArrayList<Cliente> c = new ArrayList<>();
                c.add(cliente);
                json = gson.toJson(c, Banco.typeCliente);
                Banco.clientes = c;
            }
            File arquivo = new File("clientes.json");
        try {
                try (FileWriter grava = new FileWriter(arquivo); PrintWriter escreve = new PrintWriter(grava)) {
                    escreve.println(json);
                }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar");
        }
        }   
    }
    
    public boolean atualizar(Cliente cliente){
        Gson gson = new Gson();
        String json;
        if(Banco.clientes != null){
          for (int i = 0; i < Banco.clientes.size(); i++) {
            if(idSaoIguais(Banco.clientes.get(i),cliente)){
                Banco.clientes.set(i, cliente);
                json = gson.toJson(Banco.clientes, Banco.typeCliente);
                File arquivo = new File("clientes.json");
                try {
                    try (FileWriter grava = new FileWriter(arquivo); PrintWriter escreve = new PrintWriter(grava)) {
                        escreve.println(json);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível atualizar");
                }
                return true;
            }
          }  
        }
        return false;      

    }
    
    public ArrayList<Cliente> retornaTodos(){
        return Banco.clientes;
    }
    
    @SuppressWarnings("empty-statement")
    public boolean deletar(Cliente cliente){
        Gson gson = new Gson();
        String json;
        if(Banco.clientes != null){
          for (Cliente clienteLista : Banco.clientes) {
            if(idSaoIguais(clienteLista,cliente)){
                Banco.clientes.remove(clienteLista);
                json = gson.toJson(Banco.clientes, Banco.typeCliente);
                File arquivo = new File("clientes.json");
                try {
                    try (FileWriter grava = new FileWriter(arquivo); PrintWriter escreve = new PrintWriter(grava)) {
                        escreve.println(json);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível deletar");
                }
                return true;
            }
          }  
        }
        return false;
    }
    
    private boolean idSaoIguais(Cliente cliente, Cliente clienteAComparar) {
        return cliente.getId() ==  clienteAComparar.getId();
    }
    
    
    private int proximoId(){;
        
        int maiorId = 0;
        if(Banco.clientes != null){
          for (Cliente cliente : Banco.clientes) {           
           int id = cliente.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
          }  
        }
        
        
        return maiorId + 1;
    }
}
