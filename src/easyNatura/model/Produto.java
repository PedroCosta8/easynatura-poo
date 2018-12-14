/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model;

import easyNatura.exceptions.QuantidadeInvalidaException;
import easyNatura.exceptions.ValorInvalidoException;


/**
 *
 * @author pedro
 */


public class Produto {
    
    private int id;
    private String nome;
    private double valor;
    private int quantidade;

    public Produto(int codigo, String nome, double valor, int quantidade) throws QuantidadeInvalidaException,
            ValorInvalidoException {
        this.nome = nome;
        this.id = codigo;
  	if(valor < 0) throw new ValorInvalidoException("Valor inválido\nValor deve ser maior que 0");
        this.valor = valor;
        if(quantidade < 0) throw new QuantidadeInvalidaException("Quantidade inválida\nQuantidade deve ser maior que 0");
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

    public void setValor(double valor) throws ValorInvalidoException {
        if(valor < 0) throw new ValorInvalidoException("Valor inválido\nValor deve ser maior que 0");
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws QuantidadeInvalidaException {
        if(quantidade < 0) throw new QuantidadeInvalidaException("Quantidade inválida\nQuantidade deve ser maior que 0");
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return this.getNome(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
