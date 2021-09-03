/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.item;

import com.mycompany.app.modelo.paquete.Paquete;
import com.mycompany.app.modelo.pedido.Pedido;
import com.mycompany.app.modelo.producto.Producto;
import java.io.Serializable;

/**
 *
 * @author esteban
 */
public class Item implements Serializable{
    private Integer id;
    private Producto producto;
    private Integer cantidad;
    private Pedido pedido;
    
    public Item() {
        
    }
    
    public Item(Producto producto, Integer cantidad, Pedido pedido) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.pedido = pedido;
    }

    public Item(Integer id, Producto producto, Integer cantidad, Pedido pedido) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public Item setId(Integer id) {
        this.id = id;
        return this;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
