/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.paquete;

import com.mycompany.app.modelo.producto.Producto;
import com.mycompany.app.modelo.usuario.Usuario;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author esteban
 */
public class Paquete implements Serializable{
    private Integer idPaquete;
    private String codigo;
    private Usuario usuario;
    private Producto producto;
    private Integer cantidad;

    public Paquete(Integer idPaquete, String codigo, Usuario usuario, Producto producto, Integer cantidad) {
        this.idPaquete = idPaquete;
        this.codigo = codigo;
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
    }

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

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
