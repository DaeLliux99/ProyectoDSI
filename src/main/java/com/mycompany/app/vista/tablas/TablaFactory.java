/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.vista.tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author esteban
 */
public abstract class TablaFactory {
    public TablaFactory() {
        
    }
    
    public abstract AbstractTableModel fabricarTabla(List objetos);
    public abstract AbstractTableModel fabricarTabla();
    
    public static AbstractTableModel crearTabla(String tipoTabla, List objetos) {
        AbstractTableModel atm = null;
        if ("items".equals(tipoTabla)) {
            atm = new TablaFactoryItems().fabricarTabla(objetos);
        }
        if ("paquetes".equals(tipoTabla)) {
            atm = new TablaFactoryPaquetes().fabricarTabla(objetos);
        }
        return atm;
    }
    
    public static AbstractTableModel crearTabla(String tipoTabla) {
        AbstractTableModel atm = null;
        if ("items".equals(tipoTabla)) {
            atm = new TablaFactoryItems().fabricarTabla();
        }
        if ("paquetes".equals(tipoTabla)) {
            atm = new TablaFactoryPaquetes().fabricarTabla();
        }
        return atm;
    }
}
