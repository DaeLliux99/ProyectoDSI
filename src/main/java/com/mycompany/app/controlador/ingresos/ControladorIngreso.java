/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.controlador.ingresos;

import com.mycompany.app.controlador.Controlador;
import com.mycompany.app.modelo.Modelo;
import com.mycompany.app.modelo.ModeloIngreso;
import com.mycompany.app.modelo.paquete.Paquete;
import com.mycompany.app.modelo.producto.Producto;
import com.mycompany.app.vista.VistaIngreso;
import com.mycompany.app.vista.Vista;

/**
 *
 * @author esteban
 */
public class ControladorIngreso implements Controlador{
    private VistaIngreso vistaIngreso;
    private ModeloIngreso modeloIngreso;
    
    public ControladorIngreso() {
        
    }
    
    public ControladorIngreso(VistaIngreso vi) {
        this.vistaIngreso = vi;
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
        Producto producto = vistaIngreso.getProducto();
        Paquete paquete = vistaIngreso.getPaquete();
        if (producto.getNombre().isEmpty()) {
            vistaIngreso.error("Campos vacios");
        } else if (!modeloIngreso.agregarPaquete(paquete, producto)) {
            vistaIngreso.error("No se pudo agregar paquete");
        } else {
            System.out.println("Paquete registrado con exito");
        }
        
    }
}
