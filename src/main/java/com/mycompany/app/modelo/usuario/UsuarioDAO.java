/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.usuario;

import static com.mycompany.app.modelo.conexion.Conexion.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esteban
 */
public class UsuarioDAO {
    String data;
    
    public UsuarioDAO() {
        data = "usuarios.bin";
    }
    
    public List <Usuario> obtenerUsuarios() {
        List <Usuario> usuarios;
        try {
            FileInputStream fis = new FileInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(fis);
            usuarios = (ArrayList<Usuario>) ois.readObject();
            ois.close();
            System.out.println("Datos cargados con exito");
            return usuarios;
        } catch (FileNotFoundException fnde) {
            System.out.println("No se ha encontrado el fichero de usuarios");
            usuarios = new ArrayList<>();
            usuarios.add(new Usuario("123", "123", "almacenero"));
            usuarios.add(new Usuario("456", "456", "cajero"));
            try {
                FileOutputStream fos = new FileOutputStream(data);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(usuarios);
                oos.close();
                System.out.println("Datos guardados con éxito");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return usuarios;
        } catch (IOException ioe) {
            System.out.println("Error de entrada/salida al cargar los datos");
        } catch (ClassNotFoundException ex) {
            System.out.println("El fichero contiene datos erroneos");
        }
        return null;
    }
    
    public Usuario obtenerUsuario(Usuario usuario) {
        //Esta funcion hace un SELECT y retorna el primer paquete que encuentra segun el codigo del producto
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario u = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM usuario WHERE nombreUsuario = ? and contraseña = ?");
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContraseña());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer idUsuario = rs.getInt("idUsuario");
                String nombreUsuario = rs.getNString("nombreUsuario");
                String contraseña = rs.getNString("contraseña");
                String cargo = rs.getNString("cargo");
                u = new Usuario(idUsuario, nombreUsuario, contraseña, cargo);
                return u;
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
        return null;
    }
}
