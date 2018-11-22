/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model;

import java.util.Date;

/**
 *
 * @author pedro
 */
public class Venda {
    
    private int id;
    private Cliente cliente;
    private Produto produto;
    private Date data;

    public Venda(int id, Cliente cliente, Produto produto, Date data) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
