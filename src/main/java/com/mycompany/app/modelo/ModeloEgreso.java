/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo;

import com.mycompany.app.modelo.item.Item;
import com.mycompany.app.modelo.item.ItemDAO;
import com.mycompany.app.modelo.paquete.Paquete;
import com.mycompany.app.modelo.paquete.PaqueteDAO;
import com.mycompany.app.modelo.pedido.Pedido;
import com.mycompany.app.modelo.pedido.PedidoDAO;
import com.mycompany.app.modelo.producto.Producto;
import com.mycompany.app.modelo.producto.ProductoDAO;
import com.mycompany.app.modelo.usuario.Usuario;
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
    //private List<Pedido> pedidos;
    private PedidoDAO pedidoDAO;
    private PaqueteDAO paqueteDAO;
    private ProductoDAO productoDAO;
    private ItemDAO itemDAO;
    private Usuario usuario;
    
    public ModeloEgreso() {
        this.productoDAO = new ProductoDAO();
        this.paqueteDAO = new PaqueteDAO();
        this.pedidoDAO = new PedidoDAO();
        this.itemDAO = new ItemDAO();
        //this.pedidos = new ArrayList<>();
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

    public boolean agregarItem() {
        Integer cantidad = Integer.parseInt(ve.obtenerCantidadItem());
        String codigo = ve.obtenerCodigoProducto();
        Paquete paquete;
        Producto producto = productoDAO.seleccionarProductoXCodigo(codigo);
        if (producto == null) return false;
        int total = obtenerTotalProductos(codigo);
        for (Item i: pedido.getItems()) {
            if (i.getProducto().equals(producto)) {
                if (i.getCantidad() + cantidad > total) return false;
                i.setCantidad(i.getCantidad() + cantidad);
                ve.listaItemCambiada();
                return true;
            }
        }
        if (cantidad > total) return false;
        pedido.agregarItem(new Item(producto,cantidad,pedido));
        ve.listaItemCambiada();
        return true;
    }
    
    private int obtenerTotalProductos(String codigoProducto) {
        int total = 0;
        List<Paquete> paquetes = paqueteDAO.seleccionarPrimero(codigoProducto);
        if (paquetes.isEmpty()) return 0;
        for (Paquete p: paquetes) {
            total = total + p.getCantidad();
        }
        return total;
    }

    public ModeloEgreso setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.pedido.setUsuario(usuario);
        return this;
    }
    
    public Pedido getPedido() {
        return this.pedido;
    }

    public boolean guardarPedido() {
        List<Item> items = pedido.getItems();
        pedidoDAO.insertarPedido(pedido);
        pedido = pedidoDAO.seleccionarPedido(pedido.getUsuario().getId());
        pedido.setItems(items);
        for (Item i: pedido.getItems()) {
            i.setPedido(pedido);
            List<Paquete> paquetes = paqueteDAO.seleccionarPrimero(i.getProducto().getCodigo());
            int diferencia = i.getCantidad();
            for (Paquete p: paquetes) {
                diferencia = p.getCantidad() - diferencia;
                if (diferencia < 0) {
                    p.setCantidad(0);
                    paqueteDAO.modificarPaquete(p);
                    diferencia = -1*diferencia;
                } else {
                    p.setCantidad(diferencia);
                    paqueteDAO.modificarPaquete(p);
                    break;
                }
            }
            itemDAO.insertarItem(i);
        }
        reiniciarAtributos();
        ve.listaItemCambiada();
        return true;
    }

    public void reiniciarAtributos() {
        this.pedido = new Pedido();
    }
}
