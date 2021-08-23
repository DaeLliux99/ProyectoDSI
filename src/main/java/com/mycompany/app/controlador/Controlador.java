/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.controlador;

import com.mycompany.app.modelo.Modelo;
import com.mycompany.app.vista.Vista;

/**
 *
 * @author esteban
 */
public interface Controlador {
    public Controlador setVista(Vista vista);
    public Controlador setModelo(Modelo modelo);
}
