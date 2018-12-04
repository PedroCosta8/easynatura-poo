/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model.DAO;

import com.google.gson.Gson;
import easyNatura.model.Produto;
import easyNatura.model.Venda;
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
public class VendaDAO {
    
    public void inserir(Venda venda){
          
        if(venda.getId() == 0){
            Produto p = venda.getProduto();
            int qtdVenda = venda.getQuantidade();
            int qtdProduto = p.getQuantidade();
            if(qtdVenda <= qtdProduto){
                p.setQuantidade(qtdProduto - qtdVenda);
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.atualizar(p);
            }
            else{
                JOptionPane.showMessageDialog(null, "Quantidade inválida\nVenda não efetuada");
                return;
            }
            Gson gson = new Gson();
            String json;
            venda.setId(proximoId());
            if(Banco.vendas != null){
                Banco.vendas.add(venda);
                json = gson.toJson(Banco.vendas, Banco.typeVenda);
            }
            else{
                ArrayList<Venda> v = new ArrayList<>();
                v.add(venda);
                json = gson.toJson(v, Banco.typeVenda);
                Banco.vendas = v;
            }
            File arquivo = new File("vendas.json");
        try {
                try (FileWriter grava = new FileWriter(arquivo); PrintWriter escreve = new PrintWriter(grava)) {
                    escreve.println(json);
                }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar");
        }
        }   
    }
    
    public boolean atualizar(Venda venda){
        Gson gson = new Gson();
        String json;
        if(Banco.vendas != null){
          for (int i = 0; i < Banco.vendas.size(); i++) {
            if(idSaoIguais(Banco.vendas.get(i),venda)){
                Banco.vendas.set(i, venda);
                json = gson.toJson(Banco.vendas, Banco.typeVenda);
                File arquivo = new File("vendas.json");
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
    
    public ArrayList<Venda> retornaTodos(){
        return Banco.vendas;
    }
    
    public boolean deletar(Venda venda){
        Gson gson = new Gson();
        String json;
        if(Banco.vendas != null){
          for (Venda vendaLista : Banco.vendas) {
            if(idSaoIguais(vendaLista,venda)){
                Banco.vendas.remove(vendaLista);
                json = gson.toJson(Banco.vendas, Banco.typeVenda);
                File arquivo = new File("vendas.json");
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
    
    private boolean idSaoIguais(Venda venda, Venda vendaAComparar) {
        return venda.getId() ==  vendaAComparar.getId();
    }
    
    
    private int proximoId(){;
        
        int maiorId = 0;
        if(Banco.vendas != null){
          for (Venda venda : Banco.vendas) {           
           int id = venda.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
          }  
        }
        
        
        return maiorId + 1;
    }
}
