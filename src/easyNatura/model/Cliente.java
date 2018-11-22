/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model;

/**
 *
 * @author pedro
 */
public class Cliente extends Pessoa{
    
    private String endereco;
    private String cep;
    
    public Cliente(int id, String nome, String telefone, String email, String endereco, String cep) {
        super(id, nome, telefone, email);
        this.endereco = endereco;
        this.cep = cep;
    }

    public Cliente(int id, String nome, String telefone, String endereco, String cep) {
        super(id, nome, telefone);
        this.endereco = endereco;
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
}
