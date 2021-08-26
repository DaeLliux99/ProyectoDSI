/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo;

import com.mycompany.app.modelo.paquete.Paquete;
import com.mycompany.app.modelo.paquete.PaqueteDAO;
import com.mycompany.app.modelo.producto.Producto;
import com.mycompany.app.modelo.producto.ProductoDAO;
import com.mycompany.app.vista.VistaIngreso;
import com.mycompany.app.vista.Vista;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class ModeloIngreso implements Modelo {
    private VistaIngreso vi;
    private List <Producto> productos;
    private List <Paquete> paquetes;
    private ProductoDAO pdao;
    private PaqueteDAO qdao;
    
    public ModeloIngreso() {
        this.productos = new ArrayList<>();
        this.paquetes = new ArrayList<>();
        pdao = new ProductoDAO();
        qdao = new PaqueteDAO();
    }

    @Override
    public Modelo setVista(Vista vista) {
        this.vi = (VistaIngreso) vista;
        return this;
    }

    @Override
    public ModeloIngreso cargar() {
        productos = pdao.obtenerProductos();
        paquetes = qdao.obtenerPaquetes();
        return this;
    }
    
    public boolean agregarPaquete(Paquete paquete, Producto producto) {
        if (paquetes.contains(paquete)) {
            return false;
        }
        for (Producto p: productos) {
            if (p.equals(producto)) {
                this.paquetes.add(paquete.setProducto(p));
                qdao.guardar(paquetes);
                vi.listaPaqueteCambiada();
                return true;
            }
        }
        return false;
    }
    
    public List<Paquete> getPaquetes() {
        return this.paquetes;
    }
    
}
