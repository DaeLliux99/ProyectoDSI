/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.vista;

import com.mycompany.app.controlador.Controlador;
import com.mycompany.app.modelo.Modelo;

/**
 *
 * @author esteban
 */
public interface Vista {

    public Vista setModelo(Modelo modelo);

    public Vista setControlador(Controlador controlador);

    public void aviso(String error);

}
