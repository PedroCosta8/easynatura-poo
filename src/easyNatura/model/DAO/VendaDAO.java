/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model.DAO;

import easyNatura.model.Venda;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class VendaDAO {
    
    public void insert(Venda venda){
          
        if(venda.getId() == 0){
            venda.setId(proximoId());
            Banco.venda.add(venda);
        }   
    }
    
    public boolean update(Venda agendamento){
        
        for (int i = 0; i < Banco.venda.size(); i++) {
            if(idSaoIguais(Banco.venda.get(i),agendamento)){
                Banco.venda.set(i, agendamento);
                return true;
            }
        }
        return false;      

    }
    
    public ArrayList<Venda> selectAll(){
        return Banco.venda;
    }
    
    public boolean delete(Venda venda){
        for (Venda vendaLista : Banco.venda) {
            if(idSaoIguais(vendaLista,venda)){
                Banco.venda.remove(vendaLista);
                return true;
            }
        }
        return false;
    }
    
    private boolean idSaoIguais(Venda venda, Venda vendaAComparar) {
        return venda.getId() ==  vendaAComparar.getId();
    }
    
    
    private int proximoId(){
        
        int maiorId = 0;
        
        for (Venda venda : Banco.venda) {           
           int id = venda.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
        }
        
        return maiorId + 1;
    }
}
