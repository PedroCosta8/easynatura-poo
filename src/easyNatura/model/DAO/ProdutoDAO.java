/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model.DAO;

import com.google.gson.Gson;
import easyNatura.model.Produto;
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
public class ProdutoDAO {
    
    public void inserir(Produto produto){
          
        if(produto.getId() == 0){
            Gson gson = new Gson();
            String json;
            produto.setId(proximoId());
//            Banco.produtos.add(produto);
//            json = gson.toJson(Banco.produtos, Banco.typeProduto);
            if(Banco.produtos != null){
                Banco.produtos.add(produto);
                json = gson.toJson(Banco.produtos, Banco.typeProduto);
            }
            else{
                ArrayList<Produto> p = new ArrayList<>();
                p.add(produto);
                json = gson.toJson(p, Banco.typeProduto);
                Banco.produtos = p;
            }
            File arquivo = new File("produtos.json");
        try {
                try (FileWriter grava = new FileWriter(arquivo); PrintWriter escreve = new PrintWriter(grava)) {
                    escreve.println(json);
                }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar");
        }
        }   
    }
    
    public boolean atualizar(Produto produto){
        Gson gson = new Gson();
        String json;
        if(Banco.produtos != null){
          for (int i = 0; i < Banco.produtos.size(); i++) {
            if(idSaoIguais(Banco.produtos.get(i),produto)){
                Banco.produtos.set(i, produto);
                json = gson.toJson(Banco.produtos, Banco.typeProduto);
                File arquivo = new File("produtos.json");
                try {
                    try (FileWriter grava = new FileWriter(arquivo); PrintWriter escreve = new PrintWriter(grava)) {
                        escreve.println(json);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível atualizar");;
                }
                return true;
            }
          }  
        }
        return false;      

    }
    
    public ArrayList<Produto> retornaTodos(){
        return Banco.produtos;
    }
    
    public boolean deletar(Produto produto){
        Gson gson = new Gson();
        String json;
        if(Banco.produtos != null){
          for (Produto produtoLista : Banco.produtos) {
            if(idSaoIguais(produtoLista,produto)){
                Banco.produtos.remove(produtoLista);
                json = gson.toJson(Banco.produtos, Banco.typeProduto);
                File arquivo = new File("produtos.json");
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
    
    private boolean idSaoIguais(Produto produto, Produto produtoAComparar) {
        return produto.getId() ==  produtoAComparar.getId();
    }
    
    
    private int proximoId(){;
        
        int maiorId = 0;
        if(Banco.produtos != null){
          for (Produto produto : Banco.produtos) {           
           int id = produto.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
          }  
        }
        
        
        return maiorId + 1;
    }
}
