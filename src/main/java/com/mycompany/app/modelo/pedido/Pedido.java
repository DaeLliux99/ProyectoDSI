/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.pedido;

import com.mycompany.app.modelo.item.Item;
import com.mycompany.app.modelo.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class Pedido {
    private Integer id;
    private List<Item> items;
    private Usuario usuario;

    public Pedido(List<Item> items, Usuario usuario) {
        this.items = items;
        this.usuario = usuario;
    }

    public Pedido() {
        items = new ArrayList<>();
    }

    public Pedido(Integer id, Usuario usuario) {
        items = new ArrayList<>();
        this.id = id;
        this.usuario = usuario;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void agregarItem(Item item) {
        this.items.add(item);
    }
    
}
