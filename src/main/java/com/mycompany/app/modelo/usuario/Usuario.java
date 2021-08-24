/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo.usuario;

import java.io.Serializable;

/**
 *
 * @author esteban
 */
public class Usuario implements Serializable {

    private String nombreUsuario;
    private String contraseña;
    private String cargo;

    public Usuario() {

    }

    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public Usuario(String nombreUsuario, String contraseña, String cargo) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.cargo = cargo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (this.nombreUsuario.equals(((Usuario) obj).nombreUsuario) ||
                this.contraseña.equals(((Usuario) obj).contraseña));
    }

    @Override
    public int hashCode() {
        return nombreUsuario.hashCode();
    }

}
