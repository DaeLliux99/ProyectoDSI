/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.vista.tablas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.mycompany.app.modelo.paquete.Paquete;
import java.util.Arrays;
/**
 *
 * @author esteban
 */
public class TablaPaquetes extends AbstractTableModel{
    
    private List<String> columnas;
    private List<Paquete> paquetes;
    
    public TablaPaquetes(List<Paquete> paquetes) {
        columnas = Arrays.asList("Item", "Codigo", "Nombre", "Cantidad");
        this.paquetes = paquetes;
    }
    
    @Override
    public int getRowCount() {
        return paquetes.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paquete paquete = paquetes.get(0);
        if (rowIndex >= 0) {
            paquete = paquetes.get(rowIndex);
        }
        switch (columnIndex) {
            case 0: return paquete.getItem();
            case 1: return paquete.getProducto().getCodigo();
            case 2: return paquete.getProducto().getNombre();
            case 3: return paquete.getCantidad();
            default: return paquete;
        }
    }
    
}