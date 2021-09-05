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
import com.mycompany.app.modelo.usuario.Usuario;
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
    private Usuario usuario;
    
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
        paquetes = qdao.seleccionar();
        productos = pdao.obtenerProductos();
        return this;
    }
    
    public boolean agregarPaquete() {
        Paquete paquete = new Paquete();
        Producto producto = pdao.seleccionarProducto(vi.obtenerNombreProducto());
        if (qdao.seleccionarPaquete(vi.obtenerCodigoPaquete()) != null) return false;
        if (producto == null) return false;
        paquete.setCodigo(vi.obtenerCodigoPaquete());
        paquete.setCantidad(Integer.parseInt(vi.obtenerCantidadPaquete()));
        paquete.setProducto(producto);
        paquete.setUsuario(usuario);
        qdao.insertarPaquete(paquete);
        paquetes = qdao.seleccionar();
        vi.listaPaqueteCambiada();
        return true;
    }
    
    public List<Paquete> getPaquetes() {
        return this.paquetes;
    }
    
    public List<Producto> getProductos() {
        return this.productos;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public ModeloIngreso setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }
}
