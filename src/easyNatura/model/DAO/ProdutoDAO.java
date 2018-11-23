/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model.DAO;

import easyNatura.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class ProdutoDAO {
    
    public void inserir(Produto produto){
          
        if(produto.getId() == 0){
            produto.setId(proximoId());
            Banco.produto.add(produto);
        }   
    }
    
    public boolean atualizar(Produto produto){
        
        for (int i = 0; i < Banco.produto.size(); i++) {
            if(idSaoIguais(Banco.produto.get(i),produto)){
                Banco.produto.set(i, produto);
                return true;
            }
        }
        return false;      

    }
    
    public ArrayList<Produto> retornaTodos(){
        return Banco.produto;
    }
    
    public boolean deletar(Produto venda){
        for (Produto produtoLista : Banco.produto) {
            if(idSaoIguais(produtoLista,venda)){
                Banco.produto.remove(produtoLista);
                return true;
            }
        }
        return false;
    }
    
    private boolean idSaoIguais(Produto produto, Produto produtoAComparar) {
        return produto.getId() ==  produtoAComparar.getId();
    }
    
    
    private int proximoId(){
        
        int maiorId = 0;
        
        for (Produto produto : Banco.produto) {           
           int id = produto.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
        }
        
        return maiorId + 1;
    }
}
