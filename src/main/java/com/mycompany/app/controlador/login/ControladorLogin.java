/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.controlador.login;

import com.mycompany.app.controlador.Controlador;
import com.mycompany.app.modelo.Modelo;
import com.mycompany.app.vista.Login;
import com.mycompany.app.vista.Vista;

/**
 *
 * @author esteban
 */
public class ControladorLogin implements Controlador{
    
    private Vista login;
    private Modelo modeloUsuario;
    
    
    public ControladorLogin() {
        
    }
    
    public ControladorLogin(Login login) {
        this.login = login;
    }

    @Override
    public Controlador setVista(Vista vista) {
        this.login = vista;
        return this;
    }

    @Override
    public Controlador setModelo(Modelo modelo) {
        this.modeloUsuario = modelo;
        return this;
    }
}
