/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.usuario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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
        } catch (IOException ioe) {
            System.out.println("Error de entrada/salida al cargar los datos");
        } catch (ClassNotFoundException ex) {
            System.out.println("El fichero contiene datos erroneos");
        }
        return null;
    }
}