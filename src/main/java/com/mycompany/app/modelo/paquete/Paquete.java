/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.paquete;

import com.mycompany.app.modelo.producto.Producto;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author esteban
 */
public class Paquete implements Serializable{
    private String codigo;
    private Producto producto;
    private Integer cantidad;

    public Paquete(String item, Producto producto, Integer cantidad) {
        this.codigo = item;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Paquete() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public Paquete setCodigo(String item) {
        this.codigo = item;
        return this;
    }

    public Producto getProducto() {
        return producto;
    }

    public Paquete setProducto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Paquete setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    @Override
    public int hashCode() {
        return this.codigo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (this.codigo.equals(((Paquete) obj).getCodigo()));
    }
}
