/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo;

import com.mycompany.app.modelo.Modelo;
import com.mycompany.app.modelo.usuario.Usuario;
import com.mycompany.app.modelo.usuario.UsuarioDAO;
import com.mycompany.app.vista.VistaLogin;
import com.mycompany.app.vista.VistaEgreso;
import com.mycompany.app.vista.VistaIngreso;
import com.mycompany.app.vista.Vista;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class ModeloLogin implements Modelo{
    private VistaLogin login;
    private VistaEgreso ve;
    private VistaIngreso vi;
    private List <Usuario> usuarios;
    private UsuarioDAO udao;
    private Usuario usuario;
    
    public ModeloLogin() {
        udao = new UsuarioDAO();
        usuarios = new ArrayList<>();
    }
    
    @Override
    public Modelo setVista(Vista vista) {
        this.login = (VistaLogin) vista;
        return this;
    }
    
    @Override
    public ModeloLogin cargar() {
        //Aca se cargara un archivo para los usuarios
        //usuarios = udao.obtenerUsuarios();
        return this;
    }

    public int verificarCuenta(Usuario anonimo) {
        usuario = udao.obtenerUsuario(anonimo);
        if (usuario == null) return 0;
        
        if (usuario.getCargo().equals("almacenero")) return 1;

        if (usuario.getCargo().equals("cajero")) return 2;
        
        return 0;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
}
