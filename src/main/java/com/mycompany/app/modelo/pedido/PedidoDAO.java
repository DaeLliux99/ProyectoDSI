/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.pedido;

import static com.mycompany.app.modelo.conexion.Conexion.*;
import com.mycompany.app.modelo.usuario.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class PedidoDAO {
    
    public List<Pedido> seleccionarPedido(int idUsuario) {
        //Esta funcion hace un SELECT y retorna el primer paquete que encuentra segun el codigo del producto
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List <Pedido> pedidos = new ArrayList<>();
        Pedido pedido = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM vistaPedido WHERE idUsuario = ?");
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer idPedido = rs.getInt("idpedido");
                String nombreUsuario = rs.getNString("nombreUsuario");
                String contraseña = rs.getNString("contraseña");
                String cargo = rs.getNString("cargo");
                Usuario usuario = new Usuario(idUsuario, nombreUsuario, contraseña, cargo);
                pedido = new Pedido(idPedido, usuario);
                pedidos.add(pedido);
                //System.out.println(paquete.getCodigo());
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
    
    public Pedido seleccionarUltimoPedido(int idUsuario) {
        //Esta funcion hace un SELECT y retorna el primer paquete que encuentra segun el codigo del producto
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pedido pedido = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM vistaPedido WHERE idpedido = (SELECT max(idpedido) FROM vistaPedido WHERE idUsuario = ?)");
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer idPedido = rs.getInt("idpedido");
                String nombreUsuario = rs.getNString("nombreUsuario");
                String contraseña = rs.getNString("contraseña");
                String cargo = rs.getNString("cargo");
                Usuario usuario = new Usuario(idUsuario, nombreUsuario, contraseña, cargo);
                pedido = new Pedido(idPedido, usuario);
                //System.out.println(paquete.getCodigo());
                break;
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
        return pedido;
    }
    
    public void insertarPedido(Pedido pedido) {
        //Esta funcion hace un INSERT a la tabla Paquete con el parametro correspondiente
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO pedido (idUsuario) VALUES (?)");
            stmt.setInt(1, pedido.getUsuario().getId());
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
