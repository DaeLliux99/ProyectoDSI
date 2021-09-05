/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.producto;

import static com.mycompany.app.modelo.conexion.Conexion.*;
import com.mycompany.app.modelo.usuario.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class ProductoDAO {
    String data;
    
    public ProductoDAO() {
        data = "productos.bin";
    }
    
    public List <Producto> obtenerProductos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;        
        List <Producto> productos = new ArrayList<>();

        //List<Producto> productos = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM producto");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer idProducto= rs.getInt("idProducto");
                String codigoProducto = rs.getNString("codigoProducto");
                String nombre = rs.getNString("nombre");
                producto = new Producto(idProducto, codigoProducto, nombre);
                productos.add(producto);
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
        return productos;
    }
    
    public Producto seleccionarProducto(String nombreProducto) {
        //Esta funcion hace un SELECT y retorna el primer paquete que encuentra segun el codigo del producto
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        //List<Producto> productos = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM producto WHERE nombre = ?");
            stmt.setString(1, nombreProducto);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer idProducto= rs.getInt("idProducto");
                String codigoProducto = rs.getNString("codigoProducto");
                String nombre = rs.getNString("nombre");
                producto = new Producto(idProducto, codigoProducto, nombre);
                
                System.out.println(producto.getNombre());
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
        return producto;
    }
    
    public Producto seleccionarProducto(Integer idProducto) {
        //Esta funcion hace un SELECT y retorna el primer paquete que encuentra segun el codigo del producto
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        //List<Producto> productos = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM producto WHERE idProducto = ?");
            stmt.setInt(1, idProducto);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigoProducto = rs.getNString("codigoProducto");
                String nombre = rs.getNString("nombre");
                producto = new Producto(idProducto, codigoProducto, nombre);
                break;
            }
        } catch (SQLException ex) {
            //Algo ira aca ps
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return producto;
    }
    
    public Producto seleccionarProductoXCodigo(String codigoProducto) {
        //Esta funcion hace un SELECT y retorna el primer paquete que encuentra segun el codigo del producto
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        //List<Producto> productos = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM producto WHERE codigoProducto = ?");
            stmt.setString(1, codigoProducto);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer idProducto = rs.getInt("idProducto");
                String nombre = rs.getNString("nombre");
                producto = new Producto(idProducto, codigoProducto, nombre);
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
        return producto;
    }
}
