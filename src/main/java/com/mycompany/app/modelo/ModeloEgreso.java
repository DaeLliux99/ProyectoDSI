/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo;

import com.mycompany.app.modelo.item.Item;
import com.mycompany.app.modelo.item.ItemDAO;
import com.mycompany.app.modelo.paquete.Paquete;
import com.mycompany.app.modelo.pedido.Pedido;
import com.mycompany.app.modelo.pedido.PedidoDAO;
import com.mycompany.app.vista.Vista;
import com.mycompany.app.vista.VistaEgreso;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class ModeloEgreso implements Modelo{
    
    private VistaEgreso ve;
    private Pedido pedido;
    private List<Pedido> pedidos;
    private PedidoDAO pedidoDAO;
    private ItemDAO itemDAO;
    
    public ModeloEgreso() {
        this.pedidos = new ArrayList<>();
        this.pedido = new Pedido();
    }
    
    @Override
    public Modelo setVista(Vista vista) {
        this.ve = (VistaEgreso) vista;
        return this;
    }

    @Override
    public ModeloEgreso cargar() {
        return this;
    }

    public List<Item> getItems() {
        return pedido.getItems();
    }
    
    
}
