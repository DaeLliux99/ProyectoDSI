/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.modelo;

import com.mycompany.app.vista.Vista;

/**
 *
 * @author esteban
 */
public interface Modelo {
    public Modelo setVista(Vista vista);
    public Modelo cargar();
}
