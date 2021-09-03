/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.controlador.egresos;

import com.mycompany.app.controlador.Controlador;
import com.mycompany.app.modelo.Modelo;
import com.mycompany.app.modelo.ModeloEgreso;
import com.mycompany.app.vista.Vista;
import com.mycompany.app.vista.VistaEgreso;

/**
 *
 * @author esteban
 */
public class ControladorEgreso implements Controlador{
    private VistaEgreso ve;
    private ModeloEgreso me;
    
    @Override
    public Controlador setVista(Vista vista) {
        this.ve = (VistaEgreso) vista;
        return this;
    }

    @Override
    public Controlador setModelo(Modelo modelo) {
        this.me = (ModeloEgreso) modelo;
        return this;
    }
    
    public void agregarItem() {
        if (ve.obtenerCodigoProducto().isEmpty() || ve.obtenerCantidadItem().isEmpty()) {
            ve.aviso("Campos vacios");
        } else if (!me.agregarItem()) {
            ve.aviso("No se pudo ingresar/actualizar el item");
        } else {
            System.out.println("Item agregado correctamente");
        }
    }

    public void guardarPedido() {
        if (me.getPedido().getItems().isEmpty()) {
            ve.aviso("Pedido vacio, no se puede registrar");
        } else if (!me.guardarPedido()) {
            ve.aviso("No se pudo realizar el pedido");
        } else {
            ve.aviso("Pedido registrado con éxito");
        }
    }

    public void reiniciarAtributos() {
        me.reiniciarAtributos();
    }
    
}
