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
public class Produto {
    
    private int id;
    private String nome;
    private double valor;
    private int quantidade;

    public Produto(int codigo, String nome, double valor, int quantidade) {
        this.nome = nome;
        this.id = codigo;
        this.valor = valor;
        this.quantidade = quantidade;
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
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return this.getNome(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
