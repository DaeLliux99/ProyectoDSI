/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.controlador.login;

import com.mycompany.app.controlador.Controlador;
import com.mycompany.app.controlador.ingresos.ControladorIngreso;
import com.mycompany.app.modelo.Modelo;
import com.mycompany.app.modelo.ModeloIngreso;
import com.mycompany.app.modelo.ModeloLogin;
import com.mycompany.app.modelo.usuario.Usuario;
import com.mycompany.app.vista.VistaLogin;
import com.mycompany.app.vista.Vista;
import com.mycompany.app.vista.VistaIngreso;

/**
 *
 * @author esteban
 */
public class ControladorLogin implements Controlador{
    
    private VistaLogin login;
    private ModeloLogin modeloUsuario;
    
    
    public ControladorLogin() {
        
    }
    
    public ControladorLogin(VistaLogin login) {
        this.login = login;
    }

    @Override
    public Controlador setVista(Vista vista) {
        this.login = (VistaLogin) vista;
        return this;
    }

    @Override
    public Controlador setModelo(Modelo modelo) {
        this.modeloUsuario = (ModeloLogin) modelo;
        return this;
    }
    
    public void verificarCuenta() {
        Usuario usuario = login.getUsuario();
        int swapVista;
        if (usuario.getNombreUsuario().isEmpty() || usuario.getContraseña().isEmpty()) {
            login.error("Nombre de usuario o contraseña vacios");
            return;
        }
        swapVista = modeloUsuario.verificarCuenta(usuario);
        switch (swapVista) {
            case 0: login.error("Usuario o contraseña incorrectos"); break;
            case 1: cambiarVistaIngreso(); break;
            case 2: cambiarVistaEgreso(); break;
        }
    }
    
    private void cambiarVistaIngreso(){
        login.setVisible(false);
        System.out.println("Loggeado correctamente!");
        ModeloIngreso mi = new ModeloIngreso().cargar();
        VistaIngreso vi = new VistaIngreso();
        ControladorIngreso ci = new ControladorIngreso();
        mi.setVista(vi);
        ci.setModelo(mi).setVista(vi);
        vi.setControlador(ci).setModelo(mi);
        vi.mostrar();
    }
    
    private void cambiarVistaEgreso(){
        System.out.println("Gaaaaaa");
    }
}
