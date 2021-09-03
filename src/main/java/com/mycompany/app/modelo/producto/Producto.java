/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.producto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author esteban
 */
public class Producto implements Serializable{
    
    private Integer id;
    private String codigo;
    private String nombre;

    public Producto() {
        
    }
    
    public Producto(Integer id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public Producto setId(Integer id) {
        this.id = id;
        return this;
    }
    
    public Producto(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public Producto setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto setNombre(String nombre) {
        this.nombre = nombre;
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
        return (this.codigo.equals(((Producto) obj).codigo) ||
                this.nombre.equals(((Producto) obj).nombre));
    }
}
