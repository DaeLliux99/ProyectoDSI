/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.item;

import static com.mycompany.app.modelo.conexion.Conexion.*;
import java.sql.*;

/**
 *
 * @author esteban
 */
public class ItemDAO {
    
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
