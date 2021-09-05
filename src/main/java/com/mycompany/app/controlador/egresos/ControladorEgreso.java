/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.controlador.egresos;

import com.mycompany.app.controlador.Controlador;
import com.mycompany.app.controlador.login.ControladorLogin;
import com.mycompany.app.modelo.Modelo;
import com.mycompany.app.modelo.ModeloEgreso;
import com.mycompany.app.modelo.ModeloLogin;
import com.mycompany.app.vista.Vista;
import com.mycompany.app.vista.VistaEgreso;
import com.mycompany.app.vista.VistaLogin;

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

    public void cerrarSesion() {
        this.ve.setVisible(false);
        ModeloLogin mu = new ModeloLogin().cargar();
        VistaLogin login = new VistaLogin();
        ControladorLogin cl = new ControladorLogin();
        mu.setVista(login);
        cl.setModelo(mu).setVista(login);
        login.setControlador(cl).setModelo(mu);
        login.mostrar();
    }

    public void generarReporte() {
        me.generarReporte();
        ve.aviso("Se hizo el reporte en PDF satisfactoriamente!");
    }

    public void consultarNombreProducto() {
        String nombre = me.obtenerNombreProducto(ve.obtenerCodigoProducto());
        if (nombre == null) {
            ve.establecerNombre("");
        } else {
            ve.establecerNombre(nombre);
        }
    }    
}
