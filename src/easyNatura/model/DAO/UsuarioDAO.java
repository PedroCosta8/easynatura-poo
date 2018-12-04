/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model.DAO;

import com.google.gson.Gson;
import easyNatura.model.Usuario;
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
public class UsuarioDAO {
    
    public void inserir(Usuario usuario){
          
        if(usuario.getId() == 0){
            Gson gson = new Gson();
            String json;
            usuario.setId(proximoId());
            if(Banco.usuarios != null){
                Banco.usuarios.add(usuario);
                json = gson.toJson(Banco.usuarios, Banco.typeUsuario);
            }
            else{
                ArrayList<Usuario> u = new ArrayList<>();
                u.add(usuario);
                json = gson.toJson(u, Banco.typeUsuario);
                Banco.usuarios = u;
            }
            File arquivo = new File("usuarios.json");
        try {
                try (FileWriter grava = new FileWriter(arquivo); PrintWriter escreve = new PrintWriter(grava)) {
                    escreve.println(json);
                }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar");
        }
        }   
    }
    
    @SuppressWarnings("empty-statement")
    public boolean atualizar(Usuario usuario){
        Gson gson = new Gson();
        String json;
        if(Banco.usuarios != null){
          for (int i = 0; i < Banco.usuarios.size(); i++) {
            if(idSaoIguais(Banco.usuarios.get(i),usuario)){
                Banco.usuarios.set(i, usuario);
                json = gson.toJson(Banco.usuarios, Banco.typeUsuario);
                File arquivo = new File("usuarios.json");
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
    
    public ArrayList<Usuario> retornaTodos(){
        return Banco.usuarios;
    }
    
    public boolean deletar(Usuario usuario){
        Gson gson = new Gson();
        String json;
        if(Banco.usuarios != null){
          for (Usuario usuarioLista : Banco.usuarios) {
            if(idSaoIguais(usuarioLista,usuario)){
                Banco.usuarios.remove(usuarioLista);
                json = gson.toJson(Banco.usuarios, Banco.typeUsuario);
                File arquivo = new File("usuarios.json");
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
    
    public Usuario selectPorLoginESenha(Usuario usuario){
        if(Banco.usuarios != null){
          for (Usuario usuarioLista : Banco.usuarios) {
            if(loginESenhaSaoIguais(usuarioLista,usuario)){
                return usuarioLista;
            }
          }  
        }
        
        return null;
    }
    
    private boolean loginESenhaSaoIguais(Usuario usuario, Usuario usuarioAPesquisar) {
        return usuario.getLogin().equals(usuarioAPesquisar.getLogin()) && usuario.getSenha().equals(usuarioAPesquisar.getSenha());
    }
    
    private boolean idSaoIguais(Usuario usuario, Usuario usuarioAComparar) {
        return usuario.getId() ==  usuarioAComparar.getId();
    }
    
    
    private int proximoId(){;
        
        int maiorId = 0;
        if(Banco.usuarios != null){
          for (Usuario usuario : Banco.usuarios) {           
           int id = usuario.getId();
            
            if(maiorId < id){
                maiorId = id;
            }
          }  
        }
        
        
        return maiorId + 1;
    }
}
