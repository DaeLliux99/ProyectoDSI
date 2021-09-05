/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.controlador.ingresos;

import com.mycompany.app.controlador.Controlador;
import com.mycompany.app.controlador.login.ControladorLogin;
import com.mycompany.app.modelo.Modelo;
import com.mycompany.app.modelo.ModeloIngreso;
import com.mycompany.app.modelo.ModeloLogin;
import com.mycompany.app.vista.VistaIngreso;
import com.mycompany.app.vista.Vista;
import com.mycompany.app.vista.VistaLogin;

/**
 *
 * @author esteban
 */
public class ControladorIngreso implements Controlador{
    private VistaIngreso vistaIngreso;
    private ModeloIngreso modeloIngreso;
    
    public ControladorIngreso() {
        
    }

    @Override
    public Controlador setVista(Vista vista) {
        this.vistaIngreso = (VistaIngreso) vista;
        return this;
    }

    @Override
    public Controlador setModelo(Modelo modelo) {
        this.modeloIngreso = (ModeloIngreso) modelo;
        return this;
    }
    
    public void registrarPaquete() {
        boolean vacio = vistaIngreso.obtenerCodigoPaquete().isEmpty() || 
                vistaIngreso.obtenerNombreProducto().isEmpty() || 
                vistaIngreso.obtenerCantidadPaquete().isEmpty();
        if (vacio) {
            vistaIngreso.aviso("Campos vacios");
        } else if (!modeloIngreso.agregarPaquete()) {
            vistaIngreso.aviso("No se pudo agregar paquete");
        } else {
            vistaIngreso.aviso("Paquete registrado con exito");
        }
    }
    
        public void cerrarSesion() {
        this.vistaIngreso.setVisible(false);
        ModeloLogin mu = new ModeloLogin().cargar();
        VistaLogin login = new VistaLogin();
        ControladorLogin cl = new ControladorLogin();
        mu.setVista(login);
        cl.setModelo(mu).setVista(login);
        login.setControlador(cl).setModelo(mu);
        login.mostrar();
    }
}
