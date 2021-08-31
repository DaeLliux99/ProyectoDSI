/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.vista.tablas;

import com.mycompany.app.modelo.item.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author esteban
 */
public class TablaItems extends AbstractTableModel{
    private List<String> columnas;
    private List<Item> items;
    
    public TablaItems() {
        columnas = Arrays.asList("ID", "Cod. Paquete", "Producto", "Cantidad");
        items = new ArrayList<>();
    }
    
    public TablaItems(List<Item> items) {
        columnas = Arrays.asList("ID", "Cod. Paquete", "Producto", "Cantidad");
        this.items = items;
        //System.out.println(columnas.size());
        //System.out.println(items.size());
    }
    
    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = items.get(0);
        if (rowIndex >= 0) {
            item = items.get(rowIndex);
        }
        switch (columnIndex) {
            case 0: return rowIndex + 1;
            case 1: return item.getId();
            case 2: return item.getPaquete().getProducto().getNombre();
            case 3: return item.getCantidad();
            default: return item;
        }
    }
    
    @Override
    public String getColumnName(int columna) {
        return columnas.get(columna);
    }
}
