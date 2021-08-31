/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.item;

import com.mycompany.app.modelo.paquete.Paquete;
import com.mycompany.app.modelo.pedido.Pedido;
import java.io.Serializable;

/**
 *
 * @author esteban
 */
public class Item implements Serializable{
    private Integer id;
    private Paquete paquete;
    private Integer cantidad;
    private Pedido pedido;
    
    public Item() {
        
    }
    
    public Item(Paquete paquete, Integer cantidad) {
        this.paquete = paquete;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public Item setId(Integer id) {
        this.id = id;
        return this;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public Item setPaquete(Paquete paquete) {
        this.paquete = paquete;
        return this;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Item setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Item setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }
    
    
}
