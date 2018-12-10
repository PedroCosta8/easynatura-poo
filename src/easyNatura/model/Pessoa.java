/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model;

import easyNatura.exceptions.EmailInvalidoException;

/**
 *
 * @author pedro
 */
abstract public class Pessoa {
    
    protected int id;
    protected String nome;
    protected String telefone;
    protected String email;

    public Pessoa(int id, String nome, String telefone, String email) throws
            EmailInvalidoException{
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        if(!email.contains(".com") || !email.contains("@")) throw new EmailInvalidoException("Email inválido");
        this.email = email;
    }

    public Pessoa(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailInvalidoException{
        if(!email.contains(".com") || !email.contains("@")) throw new EmailInvalidoException("Email inválido");
        this.email = email;
    }
    
    
}
