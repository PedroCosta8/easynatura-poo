/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyNatura.model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class Venda {
    
    private int id;
    private Cliente cliente;
    private Produto produto;
    private Date data;
    private int quantidade;

    public Venda(int id, Cliente cliente, Produto produto, String data, int quantidade) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.quantidade = quantidade;
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
    
    public String getDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

    public String getHoraFormatada(){
        return new SimpleDateFormat("HH:mm").format(data);
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public double valorTotal(){
        return this.getProduto().getValor() * this.getQuantidade();
    }
}
