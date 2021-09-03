/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.paquete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.mycompany.app.modelo.conexion.Conexion.*;
import com.mycompany.app.modelo.producto.Producto;
import com.mycompany.app.modelo.usuario.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author esteban
 */
public class PaqueteDAO {
    //private Paquete paquete;
    String data;
    
    public PaqueteDAO() {
        data = "paquetes.bin";
    }
    /*
    public List <Paquete> obtenerPaquetes() {
        List <Paquete> paquetes;
        try {
            FileInputStream fis = new FileInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(fis);
            paquetes = (ArrayList<Paquete>) ois.readObject();
            ois.close();
            System.out.println("Datos cargados con exito");
            return paquetes;
        } catch (FileNotFoundException fnde) {
            System.out.println("No se ha encontrado el fichero de usuarios");
            paquetes = new ArrayList<>();
            //productos.add(new Paquete());
            //productos.add(new Paquete());
            try {
                FileOutputStream fos = new FileOutputStream(data);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(paquetes);
                oos.close();
                System.out.println("Datos guardados con éxito");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return paquetes;
        } catch (IOException ioe) {
            System.out.println("Error de entrada/salida al cargar los datos");
        } catch (ClassNotFoundException ex) {
            System.out.println("El fichero contiene datos erroneos");
        }
        return null;
    }
    */
    
    public List<Paquete> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paquete paquete = null;
        List<Paquete> paquetes = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM vistaPaquete");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer idPaquete = rs.getInt("idpaquete");
                Integer cantidad = rs.getInt("cantidad");
                String codigo = rs.getNString("codPaquete");
                Integer idProducto = rs.getInt("idProducto");
                String codigoProducto = rs.getNString("codigoProducto");
                String nombre = rs.getNString("nombre");
                Integer idUsuario = rs.getInt("idUsuario");
                String nombreUsuario = rs.getNString("nombreUsuario");
                String contraseña = rs.getNString("contraseña");
                String cargo = rs.getNString("cargo");
                Producto producto = new Producto(idProducto, codigoProducto, nombre);
                Usuario usuario = new Usuario(idUsuario, nombreUsuario, contraseña, cargo);
                paquetes.add(new Paquete(idPaquete, codigo, usuario, producto, cantidad));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return paquetes;
    }
    
    public List<Paquete> seleccionarPrimero(String codigoProducto) {
        //Esta funcion hace un SELECT y retorna el primer paquete que encuentra segun el codigo del producto
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paquete paquete = null;
        List<Paquete> paquetes = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM vistaPaquete WHERE codigoProducto = ?");
            stmt.setString(1, codigoProducto);
            //stmt.setInt(2, cantidadItem);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer idPaquete = rs.getInt("idpaquete");
                Integer cantidad = rs.getInt("cantidad");
                String codigo = rs.getNString("codPaquete");
                Integer idProducto = rs.getInt("idProducto");
                String nombre = rs.getNString("nombre");
                Integer idUsuario = rs.getInt("idUsuario");
                String nombreUsuario = rs.getNString("nombreUsuario");
                String contraseña = rs.getNString("contraseña");
                String cargo = rs.getNString("cargo");
                Producto producto = new Producto(idProducto, codigoProducto, nombre);
                Usuario usuario = new Usuario(idUsuario, nombreUsuario, contraseña, cargo);
                paquete = new Paquete(idPaquete, codigo, usuario, producto, cantidad);
                paquetes.add(paquete);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return paquetes;
    }
    
    public Paquete seleccionarPaquete(String codigoPaquete) {
        //Esta funcion hace un SELECT y retorna el primer paquete que encuentra segun el codigo del producto
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paquete paquete = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM vistaPaquete WHERE codPaquete = ?");
            stmt.setString(1, codigoPaquete);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer idPaquete = rs.getInt("idpaquete");
                Integer cantidad = rs.getInt("cantidad");
                String codigo = rs.getNString("codPaquete");
                Integer idProducto = rs.getInt("idProducto");
                String codigoProducto = rs.getNString("codigoProducto");
                String nombre = rs.getNString("nombre");
                Integer idUsuario = rs.getInt("idUsuario");
                String nombreUsuario = rs.getNString("nombreUsuario");
                String contraseña = rs.getNString("contraseña");
                String cargo = rs.getNString("cargo");
                Producto producto = new Producto(idProducto, codigoProducto, nombre);
                Usuario usuario = new Usuario(idUsuario, nombreUsuario, contraseña, cargo);
                paquete = new Paquete(idPaquete, codigo, usuario, producto, cantidad);
                //System.out.println(paquete.getCodigo());
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return paquete;
    }
    
    public void insertarPaquete(Paquete paquete) {
        //Esta funcion hace un INSERT a la tabla Paquete con el parametro correspondiente
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("INSERT INTO paquete (cantidad, idUsuario, codPaquete, idProducto) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, paquete.getCantidad());
            stmt.setInt(2, paquete.getUsuario().getId());
            stmt.setString(3, paquete.getCodigo());
            stmt.setInt(4, paquete.getProducto().getId());
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
    
    public void modificarPaquete(Paquete paquete) {
        //Esta funcion hace un INSERT a la tabla Paquete con el parametro correspondiente
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE paquete SET cantidad = ?, idUsuario = ?, codPaquete = ?, idProducto = ? WHERE idpaquete = ?");
            stmt.setInt(1, paquete.getCantidad());     
            stmt.setInt(2, paquete.getUsuario().getId());
            stmt.setString(3, paquete.getCodigo()); 
            stmt.setInt(4, paquete.getProducto().getId()); 
            stmt.setInt(5, paquete.getIdPaquete());
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
    
    /*
    public void guardar(List <Paquete> paquetes) {
        try {
            FileOutputStream fos = new FileOutputStream(data);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(paquetes);
            oos.close();
            System.out.println("Datos guardados con éxito");
        }
        catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    */
}
