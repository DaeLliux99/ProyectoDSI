/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.item;

import static com.mycompany.app.modelo.conexion.Conexion.*;
import com.mycompany.app.modelo.pedido.Pedido;
import com.mycompany.app.modelo.producto.Producto;
import com.mycompany.app.modelo.usuario.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class ItemDAO {
    
    public List<Item> seleccionar(Integer idPedido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List <Item> pedidos = new ArrayList<>();
        Item item = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM vistaItem WHERE idpedido = ?");
            stmt.setInt(1, idPedido);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer idItem = rs.getInt("iditem");
                Integer cantidad = rs.getInt("cantidad");
                Integer idpedido = rs.getInt("idpedido");
                Integer idProducto = rs.getInt("idProducto");   
                String codigo = rs.getNString("codigoProducto");           
                String nombre = rs.getNString("nombre");
                Producto producto = new Producto(idProducto, codigo, nombre);
                Pedido pedido = new Pedido().setId(idpedido);
                item = new Item(idItem, producto, cantidad,pedido);
                pedidos.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return pedidos;
    }
    
    public void insertarItem(Item item) {
        //Esta funcion hace un INSERT a la tabla Paquete con el parametro correspondiente
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO item (cantidad, idpedido, idProducto) VALUES (?, ?, ?)");
            stmt.setInt(1, item.getCantidad());
            stmt.setInt(2, item.getPedido().getId());
            stmt.setInt(3, item.getProducto().getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
