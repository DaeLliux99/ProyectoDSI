/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.controlador.login;

import com.mycompany.app.controlador.Controlador;
import com.mycompany.app.modelo.Modelo;
import com.mycompany.app.modelo.usuario.ModeloUsuario;
import com.mycompany.app.modelo.usuario.Usuario;
import com.mycompany.app.vista.Login;
import com.mycompany.app.vista.Vista;

/**
 *
 * @author esteban
 */
public class ControladorLogin implements Controlador{
    
    private Login login;
    private ModeloUsuario modeloUsuario;
    
    
    public ControladorLogin() {
        
    }
    
    public ControladorLogin(Login login) {
        this.login = login;
    }

    @Override
    public Controlador setVista(Vista vista) {
        this.login = (Login) vista;
        return this;
    }

    @Override
    public Controlador setModelo(Modelo modelo) {
        this.modeloUsuario = (ModeloUsuario) modelo;
        return this;
    }
    
    public void verificarCuenta() {
        Usuario usuario = login.getUsuario();
        if (usuario.getNombreUsuario().isEmpty() || usuario.getContraseña().isEmpty()) {
            System.out.println("Nombre de usuario vaciooooo");
        } else if (!modeloUsuario.verificarCuenta(usuario)){
            System.out.println("Usuario o contraseña incorrectos");
        } else {
            System.out.println("Registrado correctamente!");
        }
    }
}
