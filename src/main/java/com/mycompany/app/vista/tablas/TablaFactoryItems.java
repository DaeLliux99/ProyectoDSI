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
public class TablaFactoryItems extends TablaFactory{

    @Override
    public AbstractTableModel fabricarTabla() {
        return new TablaItems();
    }

    @Override
    public AbstractTableModel fabricarTabla(List objetos) {
        return new TablaItems((List)objetos);
    }
    
}
