/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.usuario;

import com.mycompany.app.modelo.Modelo;
import com.mycompany.app.vista.Login;
import com.mycompany.app.vista.Vista;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class ModeloUsuario implements Modelo{
    private Vista login;
    List <Usuario> usuarios;
    
    public ModeloUsuario() {
        usuarios = new ArrayList<>();
    }
    
    @Override
    public Modelo setVista(Vista vista) {
        this.login = login;
        return this;
    }
    
    @Override
    public ModeloUsuario cargar() {
        //Aca se cargara un archivo para los usuarios
        UsuarioDAO udao = new UsuarioDAO();
        usuarios = udao.obtenerUsuarios();
        return this;
    }

    
}
