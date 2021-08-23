/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.paquete;

import com.mycompany.app.modelo.producto.Producto;

/**
 *
 * @author esteban
 */
public class Paquete {
    private String item;
    private Producto producto;
    private Integer cantidad;

    public Paquete(String item, Producto producto, Integer cantidad) {
        this.item = item;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
