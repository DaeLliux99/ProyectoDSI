/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.vista.tablas;

import com.mycompany.app.modelo.paquete.Paquete;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author esteban
 */
public class TablaFactoryPaquetes extends TablaFactory{

    @Override
    public AbstractTableModel fabricarTabla() {
        return new TablaPaquetes();
    }

    @Override
    public AbstractTableModel fabricarTabla(List objetos) {
        //List<Paquete> paquetes = (List<Paquete>) (paquetes)objetos;
        return new TablaPaquetes((List) objetos);
    }
    
}
